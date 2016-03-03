package threadpool;

import java.lang.management.ManagementFactory;
import java.util.Scanner;

/**
 * Created by ning on 1/27/16.
 * * The Java Virtual Machine exits when the only threads running are all
 * * daemon threads.
 * 即：当线程只剩下守护线程的时候，JVM就会退出.但是如果还有其他的任意一个用户线程还在，JVM就不会退出.
 */
public class DaemonRunner implements Runnable {

    public void run() {
        while (true) {
            for (int i = 1; i <= 100; i++) {

                System.out.println(i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {

        getProcessId();
        Thread daemonThread = new Thread(new DaemonRunner());
        // 设置为守护进程
        daemonThread.setDaemon(true);
        daemonThread.start();
        System.out.println("isDaemon = " + daemonThread.isDaemon());
        Scanner scanner = new Scanner(System.in);
        // 接受输入，使程序在此停顿，一旦接受到用户输入,main线程结束，JVM退出!
        scanner.next();
        //AddShutdownHook方法增加JVM停止时要做处理事件：
        //当JVM退出时，打印JVM Exit语句.
        Runtime.getRuntime().addShutdownHook(new Thread(){
            @Override
            public void run() {
                // TODO Auto-generated method stub
                System.out.println("JVM Exit!");
            }
        });
    }

    public static String getProcessId(){
        String name = ManagementFactory.getRuntimeMXBean().getName();
        System.out.println(name);
        // get pid
        String pid = name.split("@")[0];
        System.out.println("Pid is:" +pid);
        return pid;
    }
}
