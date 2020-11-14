package Figure;

import Table.Coordinates;
import Table.Table;


public class Bishop extends Figure {
    public final String name = "Bishop";

    public Bishop(Colour colorFigure) {
        super(colorFigure);
        super.name = this.name;
    }


    @Override
    public boolean isMovePossible(Coordinates from, Coordinates to, Table table) {
        return Math.abs(to.x - from.x) - Math.abs(to.y - from.y) == 0;
    }

    @Override
    public boolean isWayClean(Coordinates from, Coordinates to, Table table) {
        int sideX = from.x < to.x ? 1 : -1;
        int sideY = from.y < to.y ? 1 : -1;
        for (int i = from.x + sideX, j = from.y + sideY; i != to.x; i += sideX, j += sideY) {
            if (!table.isCellEmpty(table.getAndSetCoordinates(i, j))) return false;
        }
        return true;
    }


}

/*
abs to.x - from.x  -   abs to.y-from.y  == 0
верх вправо х+1   у + 1
вверх влево х+1   у - 1
вниз вправо х-1   у + 1
вниз влево  х-1   у - 1





 */

