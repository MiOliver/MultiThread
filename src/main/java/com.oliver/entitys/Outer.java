package com.oliver.entitys;

/**
 * Created by ning on 9/26/16.
 */
public class Outer {
    public String outName;

    private static String staticOutName;

    public String getOutName() {
        return outName;
    }

    public void setOutName(String outName) {
        this.outName = outName;
    }

    public static String getStaticOutName() {
        return staticOutName;
    }

    public static void setStaticOutName(String staticOutName) {
        Outer.staticOutName = staticOutName;
    }

    public class Inner {
        private Outer outer=null;
        /**
         * 非静态内部类不能有静态成员
         */
//        private static String innerstatic="";

        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Inner(String name,Outer outer) {
            this.name = name;
            this.outer=outer;
        }

        public Outer getOuter() {
            return outer;
        }

        public void setOuter(Outer outer) {
            this.outer = outer;
        }
        /**
         * 非静态内部类能够访问外部类的静态和非静态成员
         */
        public String getOuterName(){
            return outName;
        }
        public String getOuterStaticName(){
            return staticOutName;
        }
    }

    public static class StaicInner{
        public static String addr="";
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public StaicInner(String name) {
            this.name = name;
        }
        /**
         * 静态类不能访问外部类的非静态成员。他只能访问外部类的静态成员
          */

//        public String getOuterName(){
//            return outName;
//        }


    }


}
