package cn.monk.juc.c_001;

/**
 * Created with IntelliJ IDEA.
 * User: Eden
 * Date: 2020/3/16
 * Time: 15:10
 * Description:
 * Talk is cheap. Show me the code. -- Linus Torvalds
 */
public class T {
    private int count = 10;
    private Object o = new Object();

    public void m() {
        synchronized(o) { //任何线程要执行下面的代码，必须先拿到o的锁
            count--;
            System.out.println(Thread.currentThread().getName() + " count = " + count);
        }
    }
}
