package cn.monk.juc.c_003;

/**
 * Created with IntelliJ IDEA.
 * User: Eden
 * Date: 2020/3/16
 * Time: 15:23
 * Description:
 * Talk is cheap. Show me the code. -- Linus Torvalds
 */
public class T {
    private int count = 10;

    public synchronized void m() { //等同于在方法的代码执行时要synchronized(this)
        count--;
        System.out.println(Thread.currentThread().getName() + " count = " + count);
    }

}
