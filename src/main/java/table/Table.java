package table;

import figure.*;

import java.util.ArrayList;
import java.util.List;


public class Table {
    public Figure[][] figures = new Figure[8][8];

    public Coordinates getAndSetCoordinates(int x, int y) {
        return new Coordinates(x, y);
    }


    public Table() {

    }

    public void fillTable() {
        //create BLACK figures
        int i = 0;
        int j = 0;
        putFigure(getAndSetCoordinates(i, j++), new Rook(Figure.Colour.BLACK));
        putFigure(getAndSetCoordinates(i, j++), new Knight(Figure.Colour.BLACK));
        putFigure(getAndSetCoordinates(i, j++), new Bishop(Figure.Colour.BLACK));
        putFigure(getAndSetCoordinates(i, j++), new Queen(Figure.Colour.BLACK));
        putFigure(getAndSetCoordinates(i, j++), new King(Figure.Colour.BLACK));
        putFigure(getAndSetCoordinates(i, j++), new Bishop(Figure.Colour.BLACK));
        putFigure(getAndSetCoordinates(i, j++), new Knight(Figure.Colour.BLACK));
        putFigure(getAndSetCoordinates(i, j++), new Rook(Figure.Colour.BLACK));
        i = 7;
        j = 0;
        for (int c = 0; c < 8; c++) {
            putFigure(getAndSetCoordinates(1, j++), new Pawn(Figure.Colour.BLACK));
        }
        //create WHITE figures
        j = 0;
        putFigure(getAndSetCoordinates(i, j++), new Rook(Figure.Colour.WHITE));
        putFigure(getAndSetCoordinates(i, j++), new Knight(Figure.Colour.WHITE));
        putFigure(getAndSetCoordinates(i, j++), new Bishop(Figure.Colour.WHITE));
        putFigure(getAndSetCoordinates(i, j++), new Queen(Figure.Colour.WHITE));
        putFigure(getAndSetCoordinates(i, j++), new King(Figure.Colour.WHITE));
        putFigure(getAndSetCoordinates(i, j++), new Bishop(Figure.Colour.WHITE));
        putFigure(getAndSetCoordinates(i, j++), new Knight(Figure.Colour.WHITE));
        putFigure(getAndSetCoordinates(i, j++), new Rook(Figure.Colour.WHITE));
        j = 0;
        for (int c = 0; c < 8; c++) {
            putFigure(getAndSetCoordinates(6, j++), new Pawn(Figure.Colour.WHITE));
        }

    }

    public void putFigure(Coordinates coordinates, Figure figure) {
        figures[coordinates.getX()][coordinates.getY()] = figure;
    }

    public Figure getFigure(Coordinates coordinates) {
        return figures[coordinates.getX()][coordinates.getY()];
    }

    public boolean isCellEmpty(Coordinates coordinates) {
        return getFigure(coordinates) == null;
    }

    public boolean isSameColour(Figure figure, Coordinates coordinates) {
        if (getFigure(coordinates) == null) return false;
        return figure.colour == getFigure(coordinates).colour;
    }


    public boolean move(Coordinates from, Coordinates to) {
        Figure fromFigure = getFigure(from);
        Figure toFigure = getFigure(to);
        if (!moveCheck(from, to, fromFigure)) return false;
        putFigure(to, fromFigure);
        clean(from);

        if (kingIsAttack(fromFigure.colour)) {
            putFigure(from, fromFigure);
            putFigure(to, toFigure);
            return false;
        }


        return true;
    }

    private boolean moveCheck(Coordinates from, Coordinates to, Figure fromFigure) {
        if (isCellEmpty(from)) return false;
        if (!fromFigure.isMovePossible(from, to, this)) return false;
        if (!isCellEmpty(to) && isSameColour(fromFigure, to)) return false;
        if (!fromFigure.isWayClean(from, to, this)) return false;
        return true;
    }

    private void clean(Coordinates coordinates) {
        figures[coordinates.getX()][coordinates.getY()] = null;
    }

    private <T extends Figure> List<Coordinates> getListOfCoordinateFigures(Class<T> type, Figure.Colour colour) {
        List<Coordinates> list = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                Figure tempFigure = getFigure(getAndSetCoordinates(i, j));
                if (type.isInstance(tempFigure) && tempFigure.colour == colour)
                    list.add(getAndSetCoordinates(i, j));
            }
        }
        return list;
    }

    private boolean kingIsAttack(Figure.Colour colour) {
        List<Coordinates> kingsArtur = getListOfCoordinateFigures(King.class, colour);
        List<Coordinates> enemies = getListOfCoordinateFigures(Figure.class, colour == Figure.Colour.WHITE ? Figure.Colour.BLACK : Figure.Colour.WHITE);
        for (Coordinates enemy : enemies) {
            for (Coordinates king : kingsArtur) {
                Figure fromFigure = getFigure(enemy);
                if (fromFigure.isMovePossible(enemy, king, this)
                        && fromFigure.isWayClean(enemy, king, this)) return true;
            }
        }
        return false;
    }


}

