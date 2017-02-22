package tagmic.xopengl.demo1;

import android.opengl.GLSurfaceView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RelativeLayout;

import javax.microedition.khronos.opengles.GL10;

import tagmic.xopengl.IOpenglInterence;
import tagmic.xopengl.R;

public class Demo1Activity extends AppCompatActivity implements IOpenglInterence{

    GLSurfaceView glSurfaceView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo1);
        glSurfaceView=new GLSurfaceView(this);
        glSurfaceView.setRenderer(new OpenglRenderer(this));
        addContentView(glSurfaceView,new RelativeLayout.LayoutParams(200,200));
    }

    @Override
    public void DrawScene(GL10 gl) {
        gl.glClearColor(1.0f, 0.0f, 0.0f, 0.0f);
        // Clears the screen and depth buffer.
        gl.glClear(GL10.GL_COLOR_BUFFER_BIT
                | GL10.GL_DEPTH_BUFFER_BIT);
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
