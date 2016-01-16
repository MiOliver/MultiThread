import entitys.*;

/**
 * Created by ning on 1/14/16.
 */
public class Main{

    public static void main(String args[]){
        System.out.println("i am born!");
        Factory factory = new Factory();
        Producer producer= new Producer(factory);
        Thread customer=new Thread(new Customer(factory));
        producer.start();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        customer.start();
    }
}
