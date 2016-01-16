package entitys;

import java.util.Random;

/**
 * Created by ning on 1/14/16.
 */
public class Producer extends Thread {
    private Factory factory;

    public Producer(Factory factory){
        this.factory=factory;
    }
    @Override
    public void run() {
        while (true){
            String goods=getRandomNum();
            factory.putOne(goods);
//            System.out.println(this.getName()+this.getId()+"--> produce "+ goods);
        }
    }

    private String getRandomNum(){
        Random random=new Random();
        int num=random.nextInt(20);
        return "goods"+num;
    }
}
