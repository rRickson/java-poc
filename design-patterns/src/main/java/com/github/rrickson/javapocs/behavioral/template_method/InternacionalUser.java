package com.github.rrickson.javapocs.behavioral.template_method;

public class InternacionalUser extends UserTemplate{
    @Override
    public void createCountryRegister() {
        System.out.println("Create Country Register using SSN");
    }

    @Override
    public void createAddress() {
        System.out.println("Create Address using ZIP for EUA");
    }
}
