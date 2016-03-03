package entitys.produceAndCustomer;

/**
 * Created by ning on 1/14/16.
 */
public class Factory {
    private String[] content;
    private int index;
    public Factory() {
        content =new String[10];
        index=0;
    }
    public String takeOne(){
        synchronized (this){
            if(index==-1){
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }else{
                notifyAll();
                String result="";
                if(!"".equals(content[index])){
                    result=content[index];
                    content[index]="";
                    index--;
                    System.out.println("get-->"+ result);
                    return result;
                }
            }
        }
        return "";
    }

    public void putOne(String item){
        synchronized (this){
            if(index==10){
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }else{
                notifyAll();
                if((++index)<=9){
                    content[index]=item;
                    System.out.println("put-->"+ item);
                }else{
                    index=9;
                }
            }
        }
    }

}
