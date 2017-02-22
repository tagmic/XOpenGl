package tagmic.xopengl.demo2;

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
 * 绘制一些点
 */
public class GLPointsActivity extends AppCompatActivity implements IOpenglInterence {

    GLSurfaceView glSurfaceView;

    float[] vertexArray = new float[]{
            -0.8f , -0.4f * 1.732f , 0.0f ,
            0.8f , -0.4f * 1.732f , 0.0f ,
            0.0f , 0.4f * 1.732f , 0.0f ,
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_glpoints);
        glSurfaceView=new GLSurfaceView(this);
        glSurfaceView.setRenderer(new OpenglRenderer(this));
        addContentView(glSurfaceView,new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT,RelativeLayout.LayoutParams.MATCH_PARENT));
    }
    @Override
    public void DrawScene(GL10 gl) {
        gl.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        // Clears the screen and depth buffer.
        gl.glClear(GL10.GL_COLOR_BUFFER_BIT
                | GL10.GL_DEPTH_BUFFER_BIT);
        ByteBuffer buffer=ByteBuffer.allocateDirect(vertexArray.length*4);
        buffer.order(ByteOrder.nativeOrder());
        FloatBuffer gloat=buffer.asFloatBuffer();
        gloat.put(vertexArray);
        gloat.position(0);
        //设置顶点的颜色 (红色)
        gl.glColor4f(1.0f, 0.0f, 0.0f, 1.0f);
        //设置顶点的大小
        gl.glPointSize(8f);
        //初始化变换矩阵栈
        gl.glLoadIdentity();
        //坐标转换（glTranslate*/glRotate*/glScale*）
        gl.glTranslatef(0, 0, -4);
        //打开顶点管道
        gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
        //设置顶点数据
        gl.glVertexPointer(2,GL10.GL_FLOAT,0,gloat);
        //设置绘制模式,绘制三个点，从0开始
        gl.glDrawArrays(GL10.GL_POINTS,0,3);
        //关闭顶点通道
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
