package com.kami.study.aplabeight.beans;

import javax.ejb.LocalBean;
import javax.ejb.Startup;
import javax.ejb.Stateful;

@Startup
@Stateful(name = "CalcBean")
@LocalBean
public class CalcBean {

    private String memory;

    public double subtract(double x, double y) {
        return x-y;
    }

    public double multiply(double x, double y) {
        return x*y;
    }

    public double divide(double x, double y) {
        return x/y;
    }

    public double add(double x, double y) {
        return x+y;
    }

    public double reset() {
        return 0.0;
    }

    public String delete(String nowValue) {
        return nowValue.substring(0, nowValue.length()-1);
    }

    public String getMemory() {
        return memory;
    }

    public void setMemory(String memory) {
        this.memory = memory;
    }
}
