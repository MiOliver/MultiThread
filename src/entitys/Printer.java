package entitys;

import java.util.Date;

/**
 * Created by ning on 1/14/16.
 */
public class Printer extends Thread{
    @Override
    public void run() {
        try {
            System.out.println("-->"+new Date(System.currentTimeMillis())+":thread run!");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
