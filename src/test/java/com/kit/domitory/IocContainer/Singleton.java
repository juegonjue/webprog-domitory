package com.kit.domitory.IocContainer;

public class Singleton {
    private static Singleton instance;

    private Singleton() {}

    public static Singleton getInstance() {
        if (null==instance) {
            return instance = new Singleton();
        }
        return instance;
    }
}
