package tagmic.xopengl.demo4;

import android.opengl.GLSurfaceView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

import javax.microedition.khronos.opengles.GL10;

import tagmic.xopengl.IOpenglInterence;
import tagmic.xopengl.R;
import tagmic.xopengl.demo1.OpenglRenderer;

/***
 * 绘制三角形
 */
public class GLTrianActivity extends AppCompatActivity implements IOpenglInterence {

    GLSurfaceView glSurfaceView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gltrian);
        glSurfaceView = new GLSurfaceView(this);
        glSurfaceView.setRenderer(new OpenglRenderer(this));
        addContentView(glSurfaceView, new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.MATCH_PARENT));
    }

    //定义三角形的顶点数据
    float[] data = new float[]{
            -1.0f, 1.0f, 0.0f,
            -1.0f, -1.0f, 0.0f,
            1.0f, -1.0f, 0.0f
    };

    @Override
    public void DrawScene(GL10 gl) {
      //清理面板
        gl.glClearColor(0.0f,0.0f,0.0f,0.0f);
        //清理缓存数据
        gl.glClear(GL10.GL_COLOR_BUFFER_BIT|GL10.GL_DEPTH_BUFFER_BIT);
        //使用floatbuffer装载数据
        ByteBuffer byteBuffer=ByteBuffer.allocateDirect(data.length*4);
        byteBuffer.order(ByteOrder.nativeOrder());
        FloatBuffer vertex=byteBuffer.asFloatBuffer();
        vertex.put(data);
        vertex.position(0);
        //初始化变换矩阵栈
        gl.glLoadIdentity();
        //坐标系转换
        gl.glTranslatef(0.0f,0.0f,-4f);
        //设置顶点颜色
        gl.glColor4f(1.0f,1.0f,1.0f,1.0f);
        //设置顶点大小
        gl.glPointSize(8.0f);
        //打开顶点管道
        gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
        //设置管道顶点数据
        gl.glVertexPointer(3,GL10.GL_FLOAT,0,vertex);
        //设置绘制模式
        gl.glDrawArrays(GL10.GL_TRIANGLE_STRIP,0,3);
        //关闭顶点管道
        gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);
    }

    @Override
    protected void onResume() {
        super.onResume();
        glSurfaceView.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        glSurfaceView.onPause();
    }
}
