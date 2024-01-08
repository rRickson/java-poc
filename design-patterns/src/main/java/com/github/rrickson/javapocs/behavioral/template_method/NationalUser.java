package com.github.rrickson.javapocs.behavioral.template_method;

public class NationalUser extends UserTemplate{
    @Override
    public void createCountryRegister() {
        System.out.println("Create Country Register using CPF");
    }

    @Override
    public void createAddress() {
        System.out.println("Create Address using CEP for Brazil");
    }
}
