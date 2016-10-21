package com.oliver.pattern.decorator;

/**
 *
 */
public class ConcreteDecorator extends Decorator{
    @Override
    public void componentOpt() {
        System.out.println("decorator opt");
    }

    public ConcreteDecorator(ComponentInterface component) {
        super(component);
    }
}
