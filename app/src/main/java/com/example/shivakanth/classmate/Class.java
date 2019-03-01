package com.example.shivakanth.classmate;

public class Class {
    private String name, code, stime, etime, prof;

    public Class()
    {

    }

    public Class(String name, String code, String prof, String stime, String etime) {
        this.name = name;
        this.code = code;
        this.prof = prof;
        this.stime = stime;
        this.etime = etime;
    }

    public Class(tempClass tempClass, String a[])
    {
        this.name = tempClass.getName();
        this.code = tempClass.getCode();
        this.prof = tempClass.getProf();
        this.stime = a[0];
        this.etime = a[1];
    }

    public void changeDets(tempClass tempClass)
    {
        this.name = tempClass.getName();
        this.code = tempClass.getCode();
        this.prof = tempClass.getProf();
    }
    public void setTime(String s, String e)
    {
        this.stime = s;
        this.etime = e;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getStime() {
        return stime;
    }

    public void setStime(String stime) {
        this.stime = stime;
    }

    public String getEtime() {
        return etime;
    }

    public void setEtime(String etime) {
        this.etime = etime;
    }

    public String getProf() {
        return prof;
    }

    public void setProf(String prof) {
        this.prof = prof;
    }
}

