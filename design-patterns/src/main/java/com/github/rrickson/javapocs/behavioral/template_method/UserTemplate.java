package com.github.rrickson.javapocs.behavioral.template_method;

public abstract class UserTemplate {

    public final void buildUser(){
        createUsername();
        createPassword();
        createCountryRegister();
        createAddress();
        System.out.println("User Created");
    }

    private void createUsername(){
        System.out.println("Creating Username");
    }

    private void createPassword(){
        System.out.println("Creating Password");
    }
    public abstract void createCountryRegister();
    public abstract void createAddress();
}
