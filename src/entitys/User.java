package entitys;

import java.util.concurrent.locks.Lock;

/**
 * Created by ning on 16-1-17.
 */
public class User implements Runnable{

    private String username;
    private MyCount mycount;
    private int cash;
    private Lock lock;

    public User(String username, MyCount mycount, int cash, Lock lock) {
        this.username = username;
        this.mycount = mycount;
        this.cash = cash;
        this.lock = lock;
    }

    @Override
    public void run() {
        lock.lock();
        mycount.setCash(mycount.getCash()+cash);
        System.out.println(username+":现金操作，账户"+mycount.getOid()+","+this.cash+",余额："+mycount.getCash());
        lock.unlock();
    }

    public int getCash() {
        return cash;
    }

    public void setCash(int cash) {
        this.cash = cash;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }



    public MyCount getMycount() {
        return mycount;
    }

    public void setMycount(MyCount mycount) {
        this.mycount = mycount;
    }

    public Lock getLock() {
        return lock;
    }

    public void setLock(Lock lock) {
        this.lock = lock;
    }
}
