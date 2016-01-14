package entitys;

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
            if(index==0){
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
                index++;
                content[index]=item;
            }
        }
    }

}
