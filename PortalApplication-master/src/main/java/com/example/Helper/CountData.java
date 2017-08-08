package com.example.Helper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kamran on 8/1/2017.
 */
public class CountData {

    private String countcustomers;
    private String countproducts;
    private String countorders;


    List<String> allcountdata ;

    public CountData(){

    }

    public  CountData(String countcustomers, String countproducts) {
        this.countcustomers = countcustomers;
        this.countproducts = countproducts;
  //      this.countorders = countorders;
    }

    public String Countcustomers() {
        return countcustomers;
    }

    public void setCountcustomers(String customers) {
        this.countcustomers = countcustomers;
    }

    public String Countproducts() {
        return countproducts;
    }

    public void setCountproducts(String products) {
        this.countproducts = countproducts;
    }

    public String Countorders() {
        return countorders;
    }

    public void setCountorders(String orders) {
        this.countorders = countorders;
    }

    public List<String> getAllcountdata() {
        return allcountdata;
    }

    public void setAllcountdata(List<String> allcountdata) {
        this.allcountdata = allcountdata;
    }
}
