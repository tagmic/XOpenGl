package tagmic.xopengl.demo6;

import android.opengl.GLSurfaceView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;
import javax.microedition.khronos.opengles.GL10;
import tagmic.xopengl.IOpenglInterence;
import tagmic.xopengl.R;
import tagmic.xopengl.demo1.OpenglRenderer;

/**
 * 绘制正方体
 */
public class Demo6Activity extends AppCompatActivity implements IOpenglInterence {
    GLSurfaceView glSurfaceView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo6);
        glSurfaceView = (GLSurfaceView) findViewById(R.id.surface);
        glSurfaceView.setRenderer(new MyRenderer(this));
    }
    //正方形的8个顶点[6个面]
    float[] data = new float[]{
            -0.5f, -0.5f, 0.5f,//第一个面[正面]
            0.5f, -0.5f, 0.5f,
            -0.5f, 0.5f, 0.5f,
            0.5f, 0.5f, 0.5f,

            0.5f, -0.5f, 0.5f,//第二个面[右侧面]
            0.5f, -0.5f, -0.5f,
            0.5f, 0.5f, 0.5f,
            0.5f, 0.5f, -0.5f,

            0.5f, -0.5f, -0.5f,//第三个面[背面]
            -0.5f, -0.5f, -0.5f,
            0.5f, 0.5f, -0.5f,
            -0.5f, 0.5f, -0.5f,

            -0.5f, -0.5f, -0.5f,//第四个面[左面]
            -0.5f, -0.5f, 0.5f,
            -0.5f, 0.5f, -0.5f,
            -0.5f, 0.5f, 0.5f,

            -0.5f, 0.5f, 0.5f,//第五个面[上面]
            0.5f, 0.5f, 0.5f,
            -0.5f, 0.5f, -0.5f,
            0.5f, 0.5f, -0.5f,

            -0.5f, -0.5f, 0.5f,//第六个面[下面]
            0.5f, -0.5f, 0.5f,
            -0.5f, -0.5f, -0.5f,
            0.5f, -0.5f, -0.5f
    };
    //顶点索引顺序
    short[] index=new short[]{
            0,1,2,
            1,2,3,

            4,5,6,
            5,6,7,

            8,9,10,
            9,10,11,

            12,13,14,
            13,14,15,

            16,17,18,
            17,18,19,

            20,21,22,
            21,22,23

    };

    //  颜色数组
    float []  cubeColors = {
            1f,0f,0f,1f ,
            0f,1f,0f,1f,
            0f,0f,1f,1f,
            1f,0f,0f,1f,

            1f,0f,0f,1f ,
            0f,1f,0f,1f,
            0f,0f,1f,1f,
            1f,0f,0f,1f,

            1f,0f,0f,1f ,
            0f,1f,0f,1f,
            0f,0f,1f,1f,
            1f,0f,0f,1f,

            1f,0f,0f,1f ,
            0f,1f,0f,1f,
            0f,0f,1f,1f,
            1f,0f,0f,1f,


            1f,0f,0f,1f ,
            0f,1f,0f,1f,
            0f,0f,1f,1f,
            1f,0f,0f,1f,

            1f,0f,0f,1f ,
            0f,1f,0f,1f,
            0f,0f,1f,1f,
            1f,0f,0f,1f,
    };
    @Override
    public void DrawScene(GL10 gl) {
          //清理面板
        gl.glClear(GL10.GL_COLOR_BUFFER_BIT|GL10.GL_DEPTH_BUFFER_BIT);
        //装载数据
        ByteBuffer byteBuffer=ByteBuffer.allocateDirect(data.length*4);
        byteBuffer.order(ByteOrder.nativeOrder());
        FloatBuffer tritex=byteBuffer.asFloatBuffer();
        tritex.put(data);
        tritex.position(0);

        ByteBuffer byteBuffer1=ByteBuffer.allocateDirect(cubeColors.length*4);
        byteBuffer1.order(ByteOrder.nativeOrder());
        FloatBuffer tritex1=byteBuffer1.asFloatBuffer();
        tritex1.put(cubeColors);
        tritex1.position(0);

        ByteBuffer byteBuffer2=ByteBuffer.allocateDirect(index.length*2);
        byteBuffer2.order(ByteOrder.nativeOrder());
        ShortBuffer tritex2=byteBuffer2.asShortBuffer();
        tritex2.put(index);
        tritex2.position(0);

        //
        gl.glPointSize(8.0f);
        gl.glLoadIdentity();
        gl.glRotatef(rotate,0,1f,0);
        //
        gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
        gl.glEnableClientState(GL10.GL_COLOR_ARRAY);
        //
        gl.glVertexPointer(3,GL10.GL_FLOAT,0,tritex);
        gl.glColorPointer(4,GL10.GL_FLOAT,0,tritex1);
        gl.glDrawElements(GL10.GL_TRIANGLES,index.length,GL10.GL_UNSIGNED_SHORT,tritex2);
        gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);
        gl.glDisableClientState(GL10.GL_COLOR_ARRAY);
        rotate-=1;
    }

    float rotate;
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
