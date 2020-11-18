package figure;

import table.Coordinates;
import table.Table;

public class Queen extends Figure {
    public final String name = "Queen";

    public Queen(Colour colorFigure) {
        super(colorFigure);
        super.name = this.name;
    }

    @Override
    public boolean isMovePossible(Coordinates from, Coordinates to, Table table) {
        //clone Bishop
        if (Math.abs(to.x - from.x) == Math.abs(to.y - from.y)) return true;
        //clone Rook
        int coordinateX = from.x - to.x;
        int coordinateY = from.y - to.y;
        if (isXorY(coordinateX, coordinateY)) return true;
        if (isXorY(coordinateY, coordinateX)) return true;
        return false;
    }

    @Override
    public boolean isWayClean(Coordinates from, Coordinates to, Table table) {
        //clone Bishop
        int sideX = from.x < to.x ? 1 : -1;
        int sideY = from.y < to.y ? 1 : -1;
        for (int i = from.x + sideX, j = from.y + sideY; i != to.x; i += sideX, j += sideY) {
            if (!table.isCellEmpty(table.getAndSetCoordinates(i, j))) return false;
        }
        //clone Rook

        if (isXorY(sideY, sideX)) {
            int side = from.x < to.x ? 1 : -1;
            for (int i = from.x + side; i != to.x; i += side) {
                if (!table.isCellEmpty(table.getAndSetCoordinates(i, from.y))) return false;
            }
            return true;

        }
        if (isXorY(sideX, sideY)) {
            int side = from.y < to.y ? 1 : -1;
            for (int i = from.y + side; i != to.y; i += side) {
                if (!table.isCellEmpty(table.getAndSetCoordinates(from.x, i))) return false;
            }


        }
        return true;

    }

    private boolean isXorY(int from, int to) {
        return from == 0 && to != 0;
    }


}
