package com.example.tnb_20.pilotarebota;

import android.widget.ImageView;

public class Bola {

    private int x;
    private int y;
    private float velocitatX;
    private float velocitatY;
    private ImageView img;
    private int height;
    private int width;
    private int statusBar;

    public Bola(int x, int y, float velocitatX, float velocitatY, ImageView img, int height, int width, int statusBar) {
        this.x = x;
        this.y = y;
        this.velocitatX = velocitatX;
        this.velocitatY = velocitatX;
        this.img = img;
        this.height = height;
        this.width = width;
        this.statusBar = statusBar;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public float getVelocitatX() {
        return velocitatX;
    }

    public void setVelocitatX(float velocitatX) {
        this.velocitatX = velocitatX;
    }

    public float getVelocitatY() {
        return velocitatY;
    }

    public void setVelocitatY(float velocitatY) {
        this.velocitatY = velocitatY;
    }

    public ImageView getImg() {
        return img;
    }

    public void setImg(ImageView img) {
        this.img = img;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getStatusBar() {
        return statusBar;
    }

    public void setStatusBar(int statusBar) {
        this.statusBar = statusBar;
    }

    public void move(){
        if(img.getX() < 0){
            velocitatX = velocitatX*-1;
        }

        if((img.getX() + img.getWidth()) > width){
            velocitatX = velocitatX*-1;
        }

        if(img.getY() < 0){
            velocitatY = velocitatY*-1;
        }

        if((img.getY() + img.getHeight() + statusBar) > height){
            velocitatY = velocitatY*-1;
        }

        float novaPosicioX = img.getX() + velocitatX;
        float novaPosicioY = img.getY() + velocitatY;

        img.setY(novaPosicioY);
        img.setX(novaPosicioX);
    }
}
