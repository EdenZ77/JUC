package cn.monk.juc.c_012_volatile;

import java.util.concurrent.TimeUnit;

/**
 * Created with IntelliJ IDEA.
 * User: Eden
 * Date: 2020/3/16
 * Time: 17:22
 * Description:
 * Talk is cheap. Show me the code. -- Linus Torvalds
 */
public class T01_HelloVolatile {
    /*volatile*/ boolean running = true; //对比一下有无volatile的情况下，整个程序运行结果的区别
    void m() {
        System.out.println("m start");
        while(running) {
        }
        System.out.println("m end!");
    }

    public static void main(String[] args) {
        T01_HelloVolatile t = new T01_HelloVolatile();

        new Thread(t::m, "t1").start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        t.running = false;
    }
}
