package com.linging.pojo;

import java.io.Serializable;
import java.util.*;

public class DIAccount implements Serializable {

    private int id;
    private String name;
    private Date date;

    private String[] myStrs;
    private List<String> myList;
    private Set<String> mySet;
    private Map<String,String> myMap;
    private Properties myProps;

    public DIAccount(){}

    public DIAccount(int id, String name, Date date){
        this.id = id;
        this.name = name;
        this.date = date;
    }


    public void setMyStrs(String[] myStrs) {
        this.myStrs = myStrs;
    }

    public void setMyList(List<String> myList) {
        this.myList = myList;
    }

    public void setMySet(Set<String> mySet) {
        this.mySet = mySet;
    }

    public void setMyMap(Map<String, String> myMap) {
        this.myMap = myMap;
    }

    public void setMyProps(Properties myProps) {
        this.myProps = myProps;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "DIAccount{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", date=" + date +
                ", myStrs=" + Arrays.toString(myStrs) +
                ", myList=" + myList +
                ", mySet=" + mySet +
                ", myMap=" + myMap +
                ", myProps=" + myProps +
                '}';
    }
}
