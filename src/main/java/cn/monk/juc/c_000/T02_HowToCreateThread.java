package cn.monk.juc.c_000;

/**
 * Created with IntelliJ IDEA.
 * User: Eden
 * Date: 2020/3/16
 * Time: 14:23
 * Description:
 * Talk is cheap. Show me the code. -- Linus Torvalds
 */
public class T02_HowToCreateThread {
    static class MyThread extends Thread {
        @Override
        public void run() {
            System.out.println("Hello MyThread!");
        }
    }

    static class MyRun implements Runnable {
        @Override
        public void run() {
            System.out.println("Hello MyRun!");
        }
    }

    public static void main(String[] args) {
        new MyThread().start();
        new Thread(new MyRun()).start();
        new Thread(()->{
            System.out.println("Hello Lambda!");
        }).start();
    }
}
