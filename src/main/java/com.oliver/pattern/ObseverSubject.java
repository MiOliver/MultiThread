package com.oliver.pattern;

import com.google.common.collect.Lists;
import com.oliver.pattern.Interface.Obsever;

import java.util.List;
import java.util.Random;

/**
 * Created by ning on 9/6/16.
 */
public class ObseverSubject {

    private List<Obsever> obsevers;

    public ObseverSubject() {
        obsevers=Lists.newArrayList();
    }

    /**
     * 注册
     * @param obsever
     */
    public void attach( Obsever obsever){
        if(obsevers!=null){
            obsevers.add(obsever);
        }
    }


    public void detack(Obsever obsever){
        obsevers.remove(obsever);
    }

    /**
     * 数据变化
     */
    public void change(){
        System.out.println("数据发生变化");
        for(Obsever obsever:obsevers){
            Random random=new Random();
            int value=random.nextInt(20);
            obsever.update(value+"");
        }
    }

}
