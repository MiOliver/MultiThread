package entitys;

/**
 * Created by ning on 1/14/16.
 */
public class Customer implements Runnable{

    private Factory factory;

    public Customer(Factory factory) {
        this.factory = factory;
    }

    @Override
    public void run() {
        while (true){
            String goods=factory.takeOne();
//            System.out.println("get-->"+ goods);
        }
    }
}
