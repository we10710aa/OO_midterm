package uml;

import java.awt.*;

public class UmlCompositionLine extends UmlConnectionLine {
    private BasicDiamond diamond;

    public UmlCompositionLine(UmlComponent source,UmlComponent target){
        super(source,target);
    }

    @Override
    public void draw(Graphics2D graphics2D) {
        Point p1,p2;
        if (source.isRightTo(target)){
            p1 = source.getConnectionPort(LEFT_PORT).getCenter();
            p2 = target.getConnectionPort(RIGHT_PORT).getCenter();
            this.diamond = new BasicDiamond(p2.x,p2.y,10,BasicDiamond.LEFT);
            p2.x+=10;
        }
        else if(source.isLeftTo(target)){
            p1 = source.getConnectionPort(RIGHT_PORT).getCenter();
            p2 = target.getConnectionPort(LEFT_PORT).getCenter();
            this.diamond = new BasicDiamond(p2.x,p2.y,10,BasicDiamond.RIGHT);
            p2.x-=10;
        }
        else if(source.isOnTopOf(target)){
            p1 = source.getConnectionPort(LOWER_PORT).getCenter();
            p2= target.getConnectionPort(UPPER_PORT).getCenter();
            this.diamond = new BasicDiamond(p2.x,p2.y,10,BasicDiamond.DOWN);
            p2.y-=10;

        }
        else {
            p1 = source.getConnectionPort(UPPER_PORT).getCenter();
            p2 = target.getConnectionPort(LOWER_PORT).getCenter();
            this.diamond = new BasicDiamond(p2.x,p2.y,10,BasicDiamond.UP);
            p2.y+=10;

        }
        line.moveTo(p1,p2);
        line.draw(graphics2D);
        diamond.draw(graphics2D);
    }
}
