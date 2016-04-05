package test;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static java.math.BigDecimal.ROUND_HALF_EVEN;

/**
 * Created by ning on 4/4/16.
 * 银行家进舍设定
 */
public class Bank {
    public static void main(String[] args) {
            BigDecimal TWTAXRATE= new BigDecimal(0.05);
           BigDecimal PRE_TAXRATE=new BigDecimal(1.05);
        //存款
        BigDecimal d = new BigDecimal(888888);
        //月利率，乘3计算季利率
        BigDecimal r = new BigDecimal(0.001875*3);
        //计算利息
        BigDecimal i = d.multiply(r).setScale(2, RoundingMode.HALF_EVEN);
        System.out.println("季利息是："+i.doubleValue());
        BigDecimal bi= new BigDecimal(79.00).divide(PRE_TAXRATE,3,ROUND_HALF_EVEN);
        Double test  = new BigDecimal(79.00).divide(PRE_TAXRATE,3,RoundingMode.HALF_EVEN).doubleValue();
        System.out.println(test);
    }
}
