package figure;

import table.*;

public abstract class Figure {
    public String name;
    public final Colour colour;

    public Colour getColour() {
        return colour;
    }

    public enum Colour {
        WHITE,
        BLACK;
    }

    public Figure(Colour colorFigure) {
        colour = colorFigure;
    }

    public abstract boolean isMovePossible(Coordinates from, Coordinates to, Table table);

    public abstract boolean isWayClean(Coordinates from, Coordinates to, Table table);



    @Override
    public String toString() {
        return "[" + name + " " + colour + "]";

    }
}
