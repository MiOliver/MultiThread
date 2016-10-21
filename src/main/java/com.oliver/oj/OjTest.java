package com.oliver.oj;

import java.util.Date;

/**
 * Created by ning on 10/13/16.
 */
public class OjTest {
    public static void main(String args[]) throws Exception{

        long start=System.currentTimeMillis();
//       String result=OJ.solution("1,2,3,4,5,7,8,9,10,11,12,13");
        String result=OJ.solution("aabcc,dbbca,aadbbbaccc");
//      String result=OJ.solution("1231231237812739878951331231231237812739878951331231231237812739878951331231231237812739878951331231231237812739878951331231231237812739870 - 89513312312312378127398789513312312312378127398789513312312312378127398789513");
        long time=System.currentTimeMillis()-start;
        System.out.println(String.format("result is :%s; time is %s",result,time));

    }
}
