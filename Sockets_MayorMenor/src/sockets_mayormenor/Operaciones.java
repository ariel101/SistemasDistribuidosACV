/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sockets_mayormenor;

/**
 *
 * @author LENOVO
 */
public class Operaciones {
    
    private int a;
    private int b;
    private int c;

    public Operaciones(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public int getC() {
        return c;
    }

    public void setC(int c) {
        this.c = c;
    }
    
    
    public int mayor(){
        
        if (this.a > this.b && this.a > this.c) {
            return this.a;
        } else if (this.b > this.a && this.b > this.c) {
            return this.b;
        } else {
            return this.c;
        }
        
        
        
    }
    
    public int menor(){
        
        if (this.a < this.b && this.a < this.c) {
            return this.a;
        } else if (this.b < this.a && this.b < this.c) {
            return this.b;
        } else {
            return this.c;
        }
        
    }
    
}
