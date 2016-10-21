package com.oliver.oj;


import java.util.HashSet;
import java.util.HashMap;
import java.util.Map;


/**
 * @param line 为单行测试数据
 * @return 处理后的结果
 */

/**
 * Created by ning on 10/13/16.
 */
public class OJ {


    /**
     * A+B
     * @param line
     * @return
     */
    public static String solution01(String line) {
        String[] params = line.split(" ");
        int a = Integer.valueOf(params[0]);
        int b = Integer.valueOf(params[1]);
        while (b != 0) {
            int carry = a & b;
            a = a ^ b;
            b = carry << 1;
        }
        return String.valueOf(a);
    }

    /**
     * 取差集
     * @param line
     * @return
     */
    public static String solution02(String line) {
        String[] params = line.split(" +");
        HashSet<String> result = new HashSet<String>();
        HashSet<String> set01 = new HashSet<String>();
        HashSet<String> set02 = new HashSet<String>();
        for (String item : params) {
            if (set01.contains(item)) {
                set02.add(item);
            } else {
                set01.add(item);
            }
        }
        result.addAll(set01);
        result.removeAll(set02);
        Object[] array = result.toArray();
        return array[0].toString();
    }


    /**
     * 跳台阶
     * @param line
     * @return
     */
    public static String solution05(String line) {
        String[] params = line.split(" +");
        Integer target = Integer.valueOf(params[0]);
        String result = String.valueOf(JumpFloor(target));
        return result;
    }

    private static int JumpFloor(int target) {
        if (target == 1 || target == 0) {
            return 1;
        } else {
            return JumpFloor(target - 2) + JumpFloor(target - 1);
        }
    }


    /**
     *找出第一个缺失的正数
     * @param line
     * @return
     */
    public static String solution06(String line) {
        String[] params = line.split(",");

        Map<Integer, Boolean> map = new HashMap<Integer, Boolean>();
        int minimum = Integer.MAX_VALUE;

        for (int i = 0; i < params.length; i++) {
            Integer item = Integer.valueOf(params[i]);
            if (item > 0) {
                map.put(item, true);
                minimum = Math.min(minimum, item);

            }
        }
        if (minimum == Integer.MAX_VALUE || minimum != 1)
            return "1";
        while (map.containsKey(minimum)) {
            minimum++;
        }

        return String.valueOf(minimum);
    }


    /**
     * 出现频率最高的前K个数
     * @param line
     * @return
     */
    public static String solution07(String line) {
        // 在此处理单行数据
        String[] params = line.split(" +");
        int k = Integer.valueOf(params[1]);
        String[] array = params[0].split(",");
        System.out.println(k);
        // 返回处理后的结果
        return "";
    }


    /**
     * 输出最长连续数列长度
     * @param line
     * @return
     */
    public static String solution08(String line) {
        // 在此处理单行数据
        String[] params = line.split(",");
        Map<Integer, Boolean> map = new HashMap<Integer, Boolean>();
        int minimum = Integer.MAX_VALUE;
        int maxmum = Integer.MIN_VALUE;
        for (int i = 0; i < params.length; i++) {
            Integer item = Integer.valueOf(params[i]);
            map.put(item, true);
            minimum = Math.min(minimum, item);
            maxmum = Math.max(maxmum, item);
        }

        int count = 0;
        int max = 0;

        if (minimum == maxmum) {
            max = 1;
        }
        while (minimum < maxmum) {
            count = 0;
            while (map.containsKey(minimum)) {
                count++;
                minimum++;
            }
            minimum++;
            max = Math.max(count, max);
        }

        return String.valueOf(max);
    }


    /**
     * 找出数列中间值
     * @param line
     * @return
     */
    public static String solution09(String line) {
        String[] params = line.split(",");
        int length = params.length;
        if (length == 1) {
            return params[0];
        }
        int middle = (length + 1) / 2;
        int i;
        for (i = 0; i < length - 1; i++) {
            int nvalue = Integer.valueOf(params[i]);
            int next = Integer.valueOf(params[i + 1]);
            if (next < nvalue) {
                break;
            }
        }
        if (i == length - 1) {
            return params[middle - 1];
        } else {
            return params[(i + middle) % length];
        }
    }


    /**
     * 大数减法
     * @param line
     * @return
     */
    public static String solution012(String line) {
        String[] params = line.split("-");
        String f = params[0].trim();
        String s = params[1].trim();
        // 将字符串翻转
        char[] a = new StringBuffer(f).reverse().toString().toCharArray();
        char[] b = new StringBuffer(s).reverse().toString().toCharArray();
        int lenA = a.length;
        int lenB = b.length;
        // 最大长度
        int len = lenA > lenB ? lenA : lenB;
        int[] result = new int[len];

        char sign = '+';
        // 判断最终结果的正负
        if (lenA < lenB) {
            sign = '-';
        } else if (lenA == lenB) {
            int i = lenA - 1;
            while (i > 0 && a[i] == b[i]) {
                i--;
            }
            if (a[i] < b[i]) {
                sign = '-';
            }
        }
        // 计算结果集，如果最终结果为正，那么就a-b否则的话就b-a
        for (int i = 0; i < len; i++) {
            int aint = i < lenA ? (a[i] - '0') : 0;
            int bint = i < lenB ? (b[i] - '0') : 0;
            if (sign == '+') {
                result[i] = aint - bint;
            } else {
                result[i] = bint - aint;
            }
        }
        for (int i = 0; i < result.length - 1; i++) {
            if (result[i] < 0) {
                result[i + 1] -= 1;
                result[i] += 10;
            }
        }

        StringBuffer sb = new StringBuffer();
        if (sign == '-') {
            sb.append('-');
        }
        // 判断是否有前置0
        boolean flag = true;
        for (int i = len - 1; i >= 0; i--) {
            if (result[i] == 0 && flag) {
                continue;
            } else {
                flag = false;
            }
            sb.append(result[i]);
        }
        if (sb.toString().equals("")) {
            sb.append("0");
        }
        // 返回值
        System.out.println(sb.toString());
        return sb.toString();
    }

    /**
     * 输出组合就和 等于目标数的排列数
     * @param line
     * @return
     */
    public static String solution12(String line) {
        // 在此处理单行数据
        String[] params = line.split(" +");
        int t = Integer.valueOf(params[1].trim());
        String[] array = params[0].split(",");
        int[] arrayInt = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            arrayInt[i] = Integer.valueOf(array[i]);
        }
        int total = calc(t, arrayInt);
        return String.valueOf(total);
    }


    private static int calc(int subValue, int[] params) {
        int sum = 0;
        int i;
        for (i = 0; i < params.length; i++) {
            if (subValue - params[i] > 0) {
                sum += calc(subValue - params[i], params);
            } else {
                sum += 1;
                break;
            }

        }
        return sum;
    }


    /**
     * 输出组合求和等于0的  组合数
     * @param line
     * @return
     */
    public static String solution21(String line) {
        String[] params = line.split(",");
        int[] arrayInt = new int[params.length];
        if(params.length<3){
            return "0";
        }
        for (int i = 0; i < params.length; i++) {
            arrayInt[i] = Integer.valueOf(params[i]);
        }
        insertSort(arrayInt);
        int sum = 0;
        int a = arrayInt[0];
        int b = arrayInt[1];
        int c = arrayInt[2];
        for (int i = 0; i < arrayInt.length; i++) {
            for (int j = i + 1; j < arrayInt.length; j++) {
                for (int k = j + 1; k < arrayInt.length; k++) {
                    if ((arrayInt[i] + arrayInt[j] + arrayInt[k]) == 0) {
                        if(i+j+k==3){
                            sum++;
                        }
                        if ((a != arrayInt[i]) || (b != arrayInt[j]) || (c != arrayInt[k]))
                        {
                            sum += 1;
                            a=arrayInt[i];
                            b=arrayInt[j];
                            c=arrayInt[k];
                        }
                    }
                }

            }
        }
        return String.valueOf(sum);
    }


    /**
     * 移除k位数字最小
     * @param line
     * @return
     */
    public static String solution16(String line) {
//        String[] params = line.split(",");
//        String arrStr=params[0].trim();
//        int[] arrayInt=new int[arrStr.length()];
//
//        for(int i=0;i<arrStr.length();i++){
//            arrayInt[i]=arrStr.charAt(i);
//        }
//
        return String.valueOf(11);
    }

    /**
     * 最少交换次数
     * @param line
     * @return
     */
    public static String solution17(String line) {
        String[] params = line.split(",");
        int[] arrayInt=new int[params.length];

        for(int i=0;i<params.length;i++){
            arrayInt[i]=Integer.valueOf(params[i]);
        }
        int count=0;
        for(int j=0;j<arrayInt.length-1;j++){
            for(int k=0;k<arrayInt.length-1;k++){
                int tem=0;
                if(arrayInt[k]>arrayInt[k+1]){
                    tem=arrayInt[k];
                    arrayInt[k]=arrayInt[k+1];
                    arrayInt[k+1]=tem;
                    count++;
                }
            }
        }
        return String.valueOf(count);
    }

    /**
     * 构建短字符串
     * @param line
     * @return
     */
    public static String solution18(String line) {
        String[] params = line.split(" +");
        String shortStr =params[0].trim();
        String longStr =params[1].trim();
        int flag[] =new int[longStr.length()];
        for(int j=0;j<longStr.length();j++){
            flag[j]=0;
        }
        for(int i=0;i<shortStr.length();i++){
            int j;
            for(j=0;j<longStr.length();j++){
                if(shortStr.charAt(i)==longStr.charAt(j)){
                    if(flag[j]==0){
                        flag[j]=1;
                        break;
                    }
                }
            }
            if(j==longStr.length()){
                return "false";
            }
        }
        return "true";
    }




    private static void insertSort(int[] array) {
        if (array.length == 0) {
            return;
        }
        for (int i = 1; i < array.length; i++) {
            int tem = array[i];
            int j = i - 1;
            for (; j >= 0 && array[j] > tem; j--) {
                array[j + 1] = array[j];
            }
            array[j + 1] = tem;
        }

    }

    /**
     *
     * @param s1
     * @param s2
     * @return
     */
    public static boolean compare(String s1, String s2) {
        byte[] b1 = s1.getBytes();
        byte[] b2 = s2.getBytes();

        int bCount[] = new int[256];
        for (int i = 0; i < 5; i++) {
            bCount[i] = 0;
        }

        for (int i = 0; i < b1.length; i++) {
            bCount[b1[i] - '0']++;
        }
        for (int i = 0; i < b2.length; i++) {
            bCount[b2[i] - '0']--;
        }
        for (int i = 0; i < 256; i++) {
            if (bCount[i] != 0) {
                return false;
            }
        }
        return true;
    }


    private static int subCalc(int subValue, int[] params, int position, int deep) {
        int sum = 0;
        int i;
        if (deep > 3) {
            return sum;
        }
        if (deep < 3) {
            sum += subCalc(subValue + params[position], params, position + 1, ++deep);
        } else {
            for (i = position; i < params.length; i++) {
                if (subValue + params[i] == 0) {
                    sum += 1;
                }

            }
        }
        return sum;
    }

    /**
     * 查找目标值
     * @param line
     * @return
     */
    public static String solution15(String line) {
        String[] params = line.split(" +");
        int goal =Integer.valueOf(params[1].trim());
        String[] array = params[0].split(",");
        int i;
        int result=-1;
        for (i = 0; i < array.length; i++) {
            int nvalue = Integer.valueOf(array[i]);
            if(goal==nvalue){
               result=i;
            }
        }
       return String.valueOf(result);
    }


    /**
     *
     * @param line
     * @return
     */
    public static String solution(String line) {
        String[] params = line.split(",");
        String s1 =params[0].trim();
        String s2 =params[1].trim();
        String s3 =params[2].trim();
        if(s1.length() + s2.length() != s3.length()) {
            return "false";
        }

        boolean[][] flags= new boolean[s1.length()+1][s2.length()+1];
        flags[0][0]= true;
        for(int i1=1;i1<= s1.length(); i1++){
            if(s3.charAt(i1-1) == s1.charAt(i1-1))
                flags[i1][0] = true;
        }
        for(int i2= 1;i2<= s2.length();i2++){
            if(s3.charAt(i2-1) == s2.charAt(i2-1))
                flags[0][i2] = true;
        }
        for(int i1=1;i1<=s1.length(); i1++){
            char c1 = s1.charAt(i1-1);
            for(int i2 = 1;i2<= s2.length();i2++){
                int i3 = i1+ i2;
                char c2 = s2.charAt(i2- 1);
                char c3 = s3.charAt(i3 -1);
                if(c1 == c3)
                    flags[i1][i2] =flags[i1][i2] || flags[i1-1][i2];
                if( c2== c3)
                    flags[i1][i2] = flags[i1][i2] || flags[i1][i2-1];

            }
        }
        return String.valueOf(flags[s1.length()][s2.length()]);

}



//    private static int[] remove(int[] params, int position) {
//        int[] newparam = new int[params.length - 1];
//        boolean flag=false;
//        for (int i = 0; i < params.length; i++) {
//            if (!flag && i< position) {
//                newparam[i] = params[i];
//            }else{
//                newparam[i] = params[(i==0?0:i-1)];
//            }
//        }
//        return newparam;
//    }


}
