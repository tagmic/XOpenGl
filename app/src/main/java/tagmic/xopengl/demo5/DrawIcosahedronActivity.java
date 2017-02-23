package tagmic.xopengl.demo5;

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
 * 绘制四边形
 */
public class DrawIcosahedronActivity extends AppCompatActivity implements IOpenglInterence {

    GLSurfaceView glSurfaceView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_draw_icosahedron);
        glSurfaceView = new GLSurfaceView(this);
        glSurfaceView.setRenderer(new OpenglRenderer(this));
        addContentView(glSurfaceView, new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.MATCH_PARENT));
    }

    /***
     * 四边形[2个三角形组成，4个顶点数据]
     */
    float[] data = new float[]{
            -0.3f,-0.3f,
            0.3f,-0.3f,
            -0.3f,0.3f,
            0.3f,0.3f
    };
    @Override
    public void DrawScene(GL10 gl) {
        //清理面板
        gl.glClearColor(0.0f,0.0f,0.0f,0.0f);
        gl.glClear(GL10.GL_COLOR_BUFFER_BIT|GL10.GL_DEPTH_BUFFER_BIT);
        //将顶点数据装载到buffer中
        ByteBuffer byteBuffer=ByteBuffer.allocateDirect(data.length*4);
        byteBuffer.order(ByteOrder.nativeOrder());
        FloatBuffer tertex=byteBuffer.asFloatBuffer();
        tertex.put(data);
        tertex.position(0);
        //初始化坐标转换
        gl.glLoadIdentity();
        //设置顶点颜色
        gl.glColor4f(1.0f,1.0f,1.0f,1.0f);
        //设置顶点大小
        gl.glPointSize(8.0f);
        gl.glTranslatef(0.0f, 0.0f, -4f);
        //打开管道
        gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
        //将顶点数据加入到缓冲区
        gl.glVertexPointer(2,GL10.GL_FLOAT,0,tertex);
        //设置绘制模式[每相邻三个顶点相连成三角形]
        gl.glDrawArrays(GL10.GL_TRIANGLE_STRIP,0,4);
        //关闭管道
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
