package tagmic.xopengl.demo3;

import android.opengl.GLSurfaceView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RelativeLayout;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

import javax.microedition.khronos.opengles.GL10;

import tagmic.xopengl.IOpenglInterence;
import tagmic.xopengl.R;
import tagmic.xopengl.demo1.OpenglRenderer;

/***
 * 绘制线段
 */
public class GLlinesActivity extends AppCompatActivity implements IOpenglInterence {

    GLSurfaceView glSurfaceView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gllines);
        glSurfaceView = new GLSurfaceView(this);
        glSurfaceView.setRenderer(new OpenglRenderer(this));
        addContentView(glSurfaceView, new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.MATCH_PARENT));
    }

    //定义两个顶点的数组
    float[] points = new float[]{
            -1.0f, 1.0f, 0.0f,
            -1.0f, -1.0f , 0.0f,
            1.0f,-1.0f,0.0f,
            1.0f,1.0f,0.0f
    };

    @Override
    public void DrawScene(GL10 gl) {
        //清理面板
        gl.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        gl.glClear(GL10.GL_COLOR_BUFFER_BIT | GL10.GL_DEPTH_BUFFER_BIT);
        //使用FloatBuffer装载数据
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(points.length * 4);
        byteBuffer.order(ByteOrder.nativeOrder());
        FloatBuffer vertex = byteBuffer.asFloatBuffer();
        vertex.put(points);
        vertex.position(0);
        //设置顶点颜色
        gl.glColor4f(1.0f,0.0f,0.0f,1.0f);
        //设置顶点大小
        gl.glPointSize(8.0f);
        gl.glLoadIdentity();
        gl.glTranslatef(0, 0, -4);
        //打开顶点管道
        gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
        //将顶点数据交付给gl库
        gl.glVertexPointer(2, GL10.GL_FLOAT, 0, vertex);
        //设置绘制模式(线段)
        gl.glDrawArrays(GL10.GL_LINE_LOOP, 0,4);
        //关闭顶点管道
        gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);

    }

    @Override
    protected void onPause() {
        super.onPause();
        glSurfaceView.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        glSurfaceView.onResume();
    }
}
