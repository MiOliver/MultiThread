package com.oliver.generic;


import java.awt.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by ning on 3/30/16.
 * http://qiemengdao.iteye.com/blog/1525624
 * 泛型程序设计
 */
public class GenericDemo {
    public static void main(String args[]){
        System.out.println("i am born!");
        genericandChild();
        shareTest();
    }

    /**
     * 非泛型
     * 因为程序员肯定知道自己存储在List里面的对象类型是Integer，
     * 但是在返回列表中元素时，还是必须强制转换类型，这是为什么呢？
     * 原因在于，编译器只能保证迭代器的next()方法返回的是Object类型的对象，
     * 为保证Integer变量的类型安全，所以必须强制转换。
     */
    public static void nogeneric(){
        List myIntList=new LinkedList();
        myIntList.add(new Integer(0));
        Integer x=(Integer)myIntList.iterator().next();
    }

    /**
     * 泛型
     */
    public static void generic(){
        List<Integer> myIntList=new LinkedList<Integer>(); //1’
        myIntList.add(new Integer(0)); //2’
        Integer x=myIntList.iterator().next(); //3’

    }

    /**
     * 泛型--子类型
     * 通常来说，如果Foo是Bar的子类型，G是一种带泛型的类型，
     * 则G<Foo>不是G<Bar>的子类型。这也许是泛型学习里面最让人容易混淆的一点
     */
    public static void genericandChild(){
        List<Apple> apples = new ArrayList<Apple>(); //1
//        List<Fruit> fruits = apples; //2
    }

    /**
     * 使用通配符？，表示可以接收任何元素类型的集合作为参数
     * 里使用了通配符？指定可以使用任何类型的集合作为参数。读取的元素使用了Object类型来表示，
     * 这是安全的，因为所有的类都是Object的子类。这里就又出现了另外一个问题，如下代码所示，
     * 如果试图往使用通配符？的集合中加入对象，就会在编译时出现错误。需要注意的是，
     * 这里不管加入什么类型的对象都会出错。这是因为通配符？表示该集合存储的元素类型未知，
     * 可以是任何类型。往集合中加入元素需要是一个未知元素类型的子类型，正因为该集合存储的元素类型未知，
     * 所以我们没法向该集合中添加任何元素。唯一的例外是null，因为null是所有类型的子类型，所以尽管元素类型不知道，但是null一定是它的子类型。
     * @param c
     */
    void printCollection(Collection<?> c) {
        for (Object e:c) {
            System.out.println(e);
        }
    }

    /**
     *
     * @param shapes
     */
    public void drawAll(List<Shape> shapes) {
        Canvas c =new Canvas();
        for (Shape s:shapes) {
            s.draw(c);
            }
    }

    /**
     *所有泛型类的实例都共享同一个运行时类，类型参数信息会在编译时被擦除。
     * 因此考虑如下代码，虽然ArrayList<String>和ArrayList<Integer>类型参数不同，
     * 但是他们都共享ArrayList类，所以结果会是true。
     */
    public static void shareTest(){
        List<String>l1 = new ArrayList<String>();
        List<Integer>l2 = new ArrayList<Integer>();
        System.out.println(l1.getClass());
        System.out.println(l1.getClass() == l2.getClass()); //True

    }

    class Apple{
        private String name;
    }
    class Fruit{
        private String name;
    }
}
