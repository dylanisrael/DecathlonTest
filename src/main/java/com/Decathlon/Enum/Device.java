package com.Decathlon.Enum;

import org.openqa.selenium.Dimension;

public enum Device {
    /***
     *
     */
    DESKTOP(-1,-1, true),
    IOS(200,600, false);
    /****
     *
     */
    private final int width;
    private final int height;
    private final boolean real;
    /***
     *
     * @param width
     * @param height
     * @param isReal
     */
    Device(int width, int height,boolean isReal){
        this.width = width;
        this.height= height;
        this.real  = isReal;
    }

    public int getWidth() { return width; }

    public int getHeight() { return height; }

    public boolean isReal( ){ return real; }
    /***
     *
     * @return
     */
    public Dimension getDimension(){ return new Dimension(width,height); }

}
