package com.interview.Reentrant.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: wangtianzhu
 * @Date: 2021-10-18
 */
public class ReentrantLockTest {
    //参数为false，表明非公平锁机制；默认就是false
    private  static  final Lock lock1 = new ReentrantLock();
    private  static  final Lock lock3 = new ReentrantLock();
    //参数为true，表明实现公平锁机制
    private  static  final Lock lock2 = new ReentrantLock(true);

    public static void main(String[] args) {
//        new Thread(()->simpleTest(),"线程A").start();
//        new Thread(()->simpleTest(),"线程B").start();
//        new Thread(()->simpleTest(),"线程C").start();

//        new Thread(()->orderTest(),"线程E").start();
//        new Thread(()->orderTest(),"线程F").start();
//        new Thread(()->orderTest(),"线程G").start();


        new Thread(new ThreadDemo(lock1,lock3),"线程X").start();
        new Thread(new ThreadDemo(lock3,lock1),"线程Y").start();


    }

    /**
     * 简单实用类似 synchronized
     */
    public static void simpleTest(){
        for (int i=0; i<2;i++){

            try {
                lock1.lock();
                System.out.println(Thread.currentThread().getName()+" 获取锁");
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                System.out.println(Thread.currentThread().getName()+" 释放锁");
                lock1.unlock();
            }
        }
    }

    /**
     * 公平锁
     */
    public static void orderTest(){
        for (int i=0; i<2;i++){
            try {
                lock2.lock();
                System.out.println(Thread.currentThread().getName()+" 获取锁");
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                System.out.println(Thread.currentThread().getName()+" 释放锁");
                lock2.unlock();
            }
        }
    }

    /**
     * 超时等待:
     * tryLock方法来实现，可以选择传入时间参数，表示等待指定的时间，无参则表示立即返回锁申请的结果：
     * true表示获取锁成功，false表示获取锁失败。我们可以将这种方法用来解决死锁问题
     */
    public void timeOutTest(){

    }


}

class ThreadDemo implements Runnable{
    Lock firstLock;
    Lock secondLock;

    public ThreadDemo(Lock firstLock, Lock secondLock){
        this.firstLock = firstLock;
        this.secondLock = secondLock;
    }

    @Override
    public void run() {

        try {
            if (firstLock.tryLock()){
                TimeUnit.MICROSECONDS.sleep(10);
            }
            if (secondLock.tryLock()){
                TimeUnit.MICROSECONDS.sleep(10);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            firstLock.unlock();
            secondLock.unlock();
            System.out.println(Thread.currentThread().getName()+ "结束！");
        }
    }
}
