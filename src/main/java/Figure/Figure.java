package Figure;

import Table.*;

public abstract class Figure {
    public String name;
    public final  Colour colour;

    public enum Colour {
        WHITE,
        BLACK;
    }

    public Figure(Colour colorFigure) {
        colour = colorFigure;
    }

    public boolean isMovePossible(Coordinates from, Coordinates to, Table table){
        //add code
        return true;
    }
    public  boolean isWayClean(Coordinates from, Coordinates to, Table table) {
        return false;
    }

    @Override
    public String toString() {
        return "[" + name + " " + colour + "]";

    }
}
