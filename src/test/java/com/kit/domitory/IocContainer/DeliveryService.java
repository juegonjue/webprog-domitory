package com.kit.domitory.IocContainer;

public class DeliveryService { //delivery service가 하나의 bean이 된다고 가정.

    private String name;
    private int age;
    private static  String address; //공유되는 필드

    public void deliveryStart(String address) {
        this.address = address;
    }
    public String getAddress() {
        return address;
    }
}
