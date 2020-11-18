package figure;

import table.*;

public class Pawn extends Figure {
    public final String name = "Pawn";

    public Pawn(Colour colorFigure) {
        super(colorFigure);
        super.name = this.name;
    }

    @Override
    public boolean isMovePossible(Coordinates from, Coordinates to, Table table) {
        int colour = table.getFigure(from).colour == Colour.WHITE ? 1 : -1;
        int coordinateX = colour * (to.getX() - from.getX());
        int coordinateY = Math.abs(to.getY() - from.getY());
        switch (coordinateX) {
            case 2:
                if (coordinateY == 0 && (from.x == 1 && colour == 1 || from.x == 6 && colour == -1)) return true;
                break;
            case 1:
                if ((coordinateY == 0 && table.isCellEmpty(to)) || (coordinateY == 1 && !table.isSameColour(table.getFigure(from), to)))
                    return true;
                break;

            default:
                return false;

        }
        return false;
    }

    @Override
    public boolean isWayClean(Coordinates from, Coordinates to, Table table) {
        int colour = table.getFigure(from).colour == Colour.WHITE ? 1 : -1;
        int coordinateX = colour * (to.getX() - from.getX());
        if (coordinateX == 2 && !table.isCellEmpty(table.getAndSetCoordinates(from.getX() + colour, from.getY())))
            return false;
        return true;
    }
}
