package chapter04;

import utils.CommonUtils;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;
import java.util.Scanner;

/**
 * 6-1
 */
public class MultiThread {

    public static void main(String[] args) {

        CommonUtils.getProcessId();

        // 获取Java线程管理MXBean
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        // 不需要获取同步的monitor和synchronizer信息，仅仅获取线程和线程堆栈信息
        ThreadInfo[] threadInfos = threadMXBean.dumpAllThreads(false, false);
        // 遍历线程信息，仅打印线程ID和线程名称信息
        for (ThreadInfo threadInfo : threadInfos) {
            System.out.println("[" + threadInfo.getThreadId() + "] " + threadInfo.getThreadName());
        }

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
}
