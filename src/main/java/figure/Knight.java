package figure;

import table.Coordinates;
import table.Table;

public class Knight extends Figure {
    public final String name = "Knight";

    public Knight(Colour colorFigure) {
        super(colorFigure);
        super.name = this.name;
    }


    public boolean isMovePossible(Coordinates from, Coordinates to, Table table) {
        if (Math.abs(from.x - to.x) == 2 && Math.abs(from.y - to.y) == 1) return true;
        if (Math.abs(from.y - to.y) == 2 && Math.abs(from.x - to.x) == 1) return true;
        return false;
    }

    public boolean isWayClean(Coordinates from, Coordinates to, Table table) {
        return true;
    }


}
