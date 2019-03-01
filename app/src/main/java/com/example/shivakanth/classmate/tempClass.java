package com.example.shivakanth.classmate;

public class tempClass {
    private String code, name, prof;

    public tempClass()
    {

    }

    public tempClass(String name, String code, String prof) {
        this.name = name;
        this.code = code;
        this.prof = prof;
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

    public String getProf() {
        return prof;
    }

    public void setProf(String prof) {
        this.prof = prof;
    }
}
