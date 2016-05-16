package com.oliver.chapter04;


import com.oliver.utils.CommonUtils;

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

        // ��ȡJava�̹߳���MXBean
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        // ����Ҫ��ȡͬ����monitor��synchronizer��Ϣ��������ȡ�̺߳��̶߳�ջ��Ϣ
        ThreadInfo[] threadInfos = threadMXBean.dumpAllThreads(false, false);
        // �����߳���Ϣ������ӡ�߳�ID���߳�������Ϣ
        for (ThreadInfo threadInfo : threadInfos) {
            System.out.println("[" + threadInfo.getThreadId() + "] " + threadInfo.getThreadName());
        }

        Scanner scanner = new Scanner(System.in);
        // �������룬ʹ�����ڴ�ͣ�٣�һ�����ܵ��û�����,main�߳̽�����JVM�˳�!
        scanner.next();
        //AddShutdownHook��������JVMֹͣʱҪ�������¼���
        //��JVM�˳�ʱ����ӡJVM Exit���.
        Runtime.getRuntime().addShutdownHook(new Thread(){
            @Override
            public void run() {
                // TODO Auto-generated method stub
                System.out.println("JVM Exit!");
            }
        });
    }
}
