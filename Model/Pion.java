package Model;

import java.awt.*;
import java.util.Objects;

public class Pion {

    private int x;
    private int y;
    private Color isOn;
    private final Color DEFAULT_COLOR;
    private final int isBlack;
    private final String NAME_IMAGE;

    public Pion() {
        this(0,0,Color.RED,2);
    }

    public Pion(int x, int y, Color defaltColor,int isBlack) {
        this.x = x;
        this.y = y;
        this.isOn = defaltColor;
        this.isBlack = isBlack;
        this.DEFAULT_COLOR = defaltColor;
        NAME_IMAGE = String.valueOf(isBlack) +
                Model.getIndexColorDefine(DEFAULT_COLOR);
    }

    public boolean sameCoordonnee(Dimension dimension){
        //System.out.println(this.x + " " + this.y +"\n" + dimension.getWidth() + " " + dimension.getHeight());
        return (int)dimension.height == this.y && (int)dimension.width == this.x;
    }

    public Color getDefaltColor() {
        return DEFAULT_COLOR;
    }

    public Color getIsOn() {
        return isOn;
    }

    public void setIsOn(Color isOn) {
        this.isOn = isOn;
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

    public void setXY(int x, int y){
        setX(x);setY(y);
    }

    public String getNAME_IMAGE() {
        return NAME_IMAGE;
    }

    @Override
    public String toString() {
        return "Pion{" +
                "x=" + x +
                ", y=" + y +
                ", isOn=" + isOn +
                ", DEFAULT_COLOR=" + DEFAULT_COLOR +
                '}';
    }
}