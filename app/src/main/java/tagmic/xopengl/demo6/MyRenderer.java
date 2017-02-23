package tagmic.xopengl.demo6;

import android.opengl.GLSurfaceView;
import android.opengl.GLU;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

import tagmic.xopengl.IOpenglInterence;

/**
 * Created by techssd on 2017/2/23.
 */

public class MyRenderer implements GLSurfaceView.Renderer {
    IOpenglInterence iOpenglInterence;

    public MyRenderer(IOpenglInterence iOpenglInterence) {
        this.iOpenglInterence = iOpenglInterence;
    }

    @Override
    public void onSurfaceCreated(GL10 gl, EGLConfig config) {
        gl.glClearColor(0, 0, 0, 0);

    }

    @Override
    public void onSurfaceChanged(GL10 gl, int width, int height) {
        gl.glViewport(0, 0, width, height);
    }

    @Override
    public void onDrawFrame(GL10 gl) {
        if (null!=iOpenglInterence)
            iOpenglInterence.DrawScene(gl);
    }
}
