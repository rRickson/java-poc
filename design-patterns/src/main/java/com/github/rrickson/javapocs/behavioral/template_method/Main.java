package com.github.rrickson.javapocs.behavioral.template_method;

public class Main
{
    public static void main(String[] args){
        UserTemplate userType = new InternacionalUser();
        userType.buildUser();

        System.out.println("-------------------------");

        userType=new NationalUser();
        userType.buildUser();
    }

}
