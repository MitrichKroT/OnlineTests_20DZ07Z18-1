package com.acquisio.basic.java.question08;


public class User {
    public static double taxes =15.0;

    private String name;
    private Double amount;
    private String shoppingCartTitle;
    private int nbItems;

    public User( String vName, Double vAmount, String vShoppingCartTitle, int vNbItems){
        this.name=vName;
        this.amount=vAmount;
        this.shoppingCartTitle=vShoppingCartTitle;
        this.nbItems=vNbItems;
    }
    public User( String[] values){
        this.name=values[0];
        this.amount=Double.parseDouble(values[1]);
        this.shoppingCartTitle=values[2];
        this.nbItems=Integer.parseInt(values[3]);
    }
    public double getAmount(){
        return this.amount;
    }
    public double getTaxesAmount(){
        return this.amount*taxes/100;
    }
    public String getShoppingCartTitle(){
        return this.shoppingCartTitle;
    }
    public double getTotal(){
        return (this.amount+getTaxesAmount());
    }
    public String printInfo(){
        return this.name+" "+this.amount+" "+this.nbItems;
    }
    public String getName(){
        return this.name;
    }
}
