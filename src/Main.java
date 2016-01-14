import entitys.Printer;
import entitys.PrinterRunnable;

/**
 * Created by ning on 1/14/16.
 */
public class Main{

    public static void main(String args[]){
        System.out.println("i am born!");
        Printer printer=new Printer();
        printer.run();
        Thread runnable=new Thread(new PrinterRunnable());
        runnable.run();
    }
}
