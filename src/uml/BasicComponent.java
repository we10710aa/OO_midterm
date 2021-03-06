package uml;

import java.awt.*;

public class BasicComponent implements Drawable {
    public int minX;
    public int minY;
    public int width;
    public int height;
    public BasicComponent(){}
    public BasicComponent(int x,int y,int width, int height){
        this.minX = x;
        this.minY=y;
        this.width= width;
        this.height = height;
    }

    @Override
    public void draw(Graphics2D graphics2D) {
        return;
        // =(
    }

    public BasicRect getBound(){
        return new BasicRect(minX,minY,width,height);
    }

    public Point getCenter(){
        return new Point(minX+width/2,minY+height/2);
    }

    public boolean contains(Point p){
        int x = p.x;
        int y = p.y;
        return (x > minX)&&(y>minY)&&(x<minX+width)&&(y<minY+height);
    }

    public boolean withIn(BasicRect rect){
        return (minX>rect.minX)&&
                (minX+width<(rect.minX+rect.width))&&
                (minY>rect.minY)&&
                (minY+height<(rect.minY+rect.height));
    }

    public void moveTo(Point p){
        this.minX = p.x;
        this.minY = p.y;
    }
}
