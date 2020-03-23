package cn.monk.juc.c_008;

import java.util.concurrent.TimeUnit;

/**
 * Created with IntelliJ IDEA.
 * User: Eden
 * Date: 2020/3/16
 * Time: 15:55
 * Description:
 * Talk is cheap. Show me the code. -- Linus Torvalds
 *
 *  面试题：模拟银行账户
 *  对业务写方法加锁
 *  对业务读方法不加锁
 *  这样行不行？
 *
 *  容易产生脏读问题（dirtyRead）
 */
public class Account {
    private String name;
    private double balance;

    public synchronized void set(String name, double balance) {
        this.name = name;

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.balance = balance;
    }

    public synchronized double getBalance(String name) {
        return this.balance;
    }

    public static void main(String[] args) {
        Account a = new Account();
        new Thread(()->a.set("zhangsan", 100.0)).start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(a.getBalance("zhangsan"));

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(a.getBalance("zhangsan"));
    }
}
