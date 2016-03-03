package utils;

import java.lang.management.ManagementFactory;

/**
 * Created by ning on 1/27/16.
 */
public class CommonUtils {

    public static String getProcessId(){
        String name = ManagementFactory.getRuntimeMXBean().getName();
        System.out.println(name);
        // get pid
        String pid = name.split("@")[0];
        System.out.println("Pid is:" +pid);
        return pid;
    }

}
