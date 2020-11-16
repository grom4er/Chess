package Figure;

import Table.Coordinates;
import Table.Table;

public class King extends Figure {
    public final String name = "King";

    public King(Colour colorFigure) {
        super(colorFigure);
        super.name = this.name;
    }

    @Override
    public boolean isMovePossible(Coordinates from, Coordinates to, Table table) {
        if (Math.abs(from.x - to.x) > 1 || Math.abs(from.y - to.y) > 1) return false;
        return true;
    }

    @Override
    public boolean isWayClean(Coordinates from, Coordinates to, Table table) {
        return true;
    }


}
/*



 */