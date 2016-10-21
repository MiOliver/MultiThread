package com.oliver.pattern;

import com.oliver.pattern.decorator.ComponentInterface;
import com.oliver.pattern.adapter.Adaptee;
import com.oliver.pattern.adapter.ObjectAdapter;
import com.oliver.pattern.decorator.ConcreteComponent;
import com.oliver.pattern.decorator.ConcreteDecorator;

/**
 * Created by ning on 6/28/16.
 */
public class PatternTest {

    public static void main(String[] args){
//        AbstractChart chart=SimpleFactory.getChart("line");
//        chart.display();
//
//        /**test classAdapter */
//        ClassAdapter classAdapter=new ClassAdapter();
//        classAdapter.operate01();
//        System.out.println("*********************");
//
        Adaptee adaptee=new Adaptee();
        ObjectAdapter objectAdapter=new ObjectAdapter(adaptee);
        objectAdapter.operate01();
//
//        /**test */
//        ObseverSubject subject=new ObseverSubject();
//        Obsever obsever0=new Obsever("a");
//        Obsever obsever1=new Obsever("b");
//        Obsever obsever2=new Obsever("c");
//        subject.attach(obsever0);
//        subject.attach(obsever1);
//        subject.attach(obsever2);
//
//        subject.change();

        ComponentInterface concreteComponent=new ConcreteComponent();
        concreteComponent.componentOpt();

        ComponentInterface decotator=new ConcreteDecorator(concreteComponent);

        decotator.componentOpt();

    }
}
