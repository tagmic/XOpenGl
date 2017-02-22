package tagmic.xopengl;

/**
 * Created by techssd on 2017/2/22.
 */

public class XConfig {
    /***
     * OpenGL的绘制模式
     */
    //1，GL_POINTS 绘制独立的点
    //2，GL_LINE_STRIP 绘制线段
    //3，GL_LINE_LOOP  绘制线段，但是首尾相连，构成一个封闭曲线。
    //4，GL_LINES      绘制多条线段，顶点两两相连
    //5，GL_TRIANGLES  每隔三个顶点相连成三角形，为多个三角形构成
    //6，GL_TRIANGLE_STRIP 每相邻三个顶点相连成三角形，为一系列三角形构成
    //7，GL_TRIANGLE_FAN 以一个点为三角形公共顶点，组成一系列相邻的三角形
    /***
     * OpenGL ES提供了两种方法来绘制一个空间几何图形：
     * 其中mode 为上述解释顶点的模式。
     * 顶点一般使用数组来定义，使用buffer来提高其性能。
     */
    //1, public abstract void glDrawArrays(int mode, int first, int count)使用VetexBuffer 来绘制，顶点的顺序由vertexBuffer中的顺序指定。
    //2, public abstract void glDrawElements(int mode, int count, int type, Buffer indices) ，可以重新定义顶点的顺序，顶点的顺序由indices Buffer 指定。

    /***
     * 有了顶点的定义数组，在打开顶点开关后，将顶点坐标传给OpenGL 管道的方法为：glVertexPointer：
     */
    //1，打开顶点管道开关  gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
    //2，关闭顶点管道开关  gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);

    //public void glVertexPointer(int size,int type,int stride,Buffer pointer)
    //1,size参数为顶点坐标维数  可以是2，3，4
    //2,type参数为顶点数据类型  可以是GL_BYTE, GL_SHORT, GL_FIXED,或 GL_FLOAT，缺省为浮点类型GL_FLOAT。
    //3,stride 参数为每个相邻顶点之间在数组中的间隔(字节数)，缺省为0表示顶点存储之间0间隔
    //4,pointer 参数为存储顶点的数组
    /***
     * 对应顶点除了可以为其定义坐标外，还可以指定颜色，材质，法线（用于光照处理）等。
     * glEnableClientState 和 glDisableClientState 可以控制的pipeline开关可以有：
     * GL_COLOR_ARRAY (颜色） ,GL_NORMAL_ARRAY (法线), GL_TEXTURE_COORD_ARRAY (材质), GL_VERTEX_ARRAY(顶点), GL_POINT_SIZE_ARRAY_OES等。
     * 对应的传入颜色，顶点，材质，法线的方法如下：
     * glColorPointer(int size,int type,int stride,Buffer pointer)
     * glVertexPointer(int size, int type, int stride, Buffer pointer)
     * glTexCoordPointer(int size, int type, int stride, Buffer pointer)
     * glNormalPointer(int type, int stride, Buffer pointer)
     * 如果需要使用三角形来构造复杂图形，可以使用GL_TRIANGLE_STRIP或GL_TRIANGLE_FAN模式，
     */
}
