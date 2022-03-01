package jpabook.jpashop.domain;


import lombok.Getter;

import javax.persistence.Embeddable;

@Embeddable
@Getter
public class Address {

    private String city ;

    private String zipcode;

    private String street;

    protected Address(){

    }

    public Address(String city,String zipcode , String street){
        this.city = city;
        this.street = street;
        this.zipcode = zipcode;
    }
}
