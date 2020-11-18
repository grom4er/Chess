package figure;

import table.Coordinates;
import table.Table;


public class Rook extends Figure {
    final String name = "Rook";

    public Rook(Colour colorFigure) {
        super(colorFigure);
        super.name = this.name;
    }

    @Override
    public boolean isMovePossible(Coordinates from, Coordinates to, Table table) {
        int coordinateX = from.x - to.x;
        int coordinateY = from.y - to.y;
        if (isXorY(coordinateX, coordinateY)) return true;
        if (isXorY(coordinateY, coordinateX)) return true;
        return false;
    }

    @Override
    public boolean isWayClean(Coordinates from, Coordinates to, Table table) {
        int coordinateX = from.x - to.x;
        int coordinateY = from.y - to.y;


        if (isXorY(coordinateY, coordinateX)) {
            int side = from.x < to.x ? 1 : -1;
            for (int i = from.x + side; i != to.x; i += side) {
                if (!table.isCellEmpty(table.getAndSetCoordinates(i, from.y))) return false;
            }
            return true;

        }
        if (isXorY(coordinateX, coordinateY)) {
            int side = from.y < to.y ? 1 : -1;
            for (int i = from.y + side; i != to.y; i += side) {
                if (!table.isCellEmpty(table.getAndSetCoordinates(from.x, i))) return false;
            }
            return true;


        }
        return true;
    }

    private boolean isXorY(int from, int to) {
        return from == 0 && to != 0;
    }
}
