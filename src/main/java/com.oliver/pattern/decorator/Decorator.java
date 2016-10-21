package com.oliver.pattern.decorator;

/**
 * 装饰者类
 */
public class Decorator implements ComponentInterface {
    private ComponentInterface component;
    @Override
    public void componentOpt() {
        component.componentOpt();
    }

    public Decorator(ComponentInterface component) {
        this.component = component;
    }

    public ComponentInterface getComponent() {
        return component;
    }

    public void setComponent(ComponentInterface component) {
        this.component = component;
    }
}
