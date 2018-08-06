package com.company;

import java.util.Scanner;

public class MyElem {
    private String info;
    private Integer id;

    public MyElem(){}

    public MyElem(Integer id, String inf){
        this.info=inf;
        this.id=id;
    }

    public  int getId(){
        return id;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info)
    {
        this.info=info;
    }
    public void setId(int id)
    {
        this.id=id;
    }

    public void printElem(){
        System.out.println(toString());
    }

    public static MyElem inputElem(Scanner s){
        System.out.println("Ведите id ");
        Integer i = s.nextInt();
        s.nextLine();
        System.out.println("Ведите info ");
        String str = s.nextLine();
        return new MyElem(i,str);
    }

    @Override
    public String toString(){
        String sId =  Integer.toString(id);
        return info+" "+sId;
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        MyElem el = (MyElem)o;
        return id.equals(el.getId()) && info.equals(el.getInfo());
    }
}
