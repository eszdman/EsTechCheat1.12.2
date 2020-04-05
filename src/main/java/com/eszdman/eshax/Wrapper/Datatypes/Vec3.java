package com.eszdman.eshax.Wrapper.Datatypes;

public class Vec3 {
    public double x;
    public double y;
    public double z;
    public Vec3(double x0, double y0, double z0){
        x = x0;
        y = y0;
        z = z0;
    }
    public double length(){
        return Math.sqrt(x*x + y*y + z*z);
    }
    public void mul(double c){
        x*=c;
        y*=c;
        z*=c;
    }
    public void normalize(){
        mul(1/(length()+0.00001));
    }
}
