package com.oliver.guava;

/**
 * Created by ning on 9/18/16.
 */

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

public class Condition {

    public static void  main(String[] args){
        String name=new String("asdf");
        String name01=null;
        boolean flag=true;
        checkArgument(flag,"flag is %s",flag);
        checkNotNull(name,"name is %s",name);
        checkNotNull(name01,"name01 is %s",name01);
    }

}
