package com.oliver.pattern.entity;

/**
 * 抽象图表类
 */
public abstract  class AbstractChart {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public abstract void display();
}
