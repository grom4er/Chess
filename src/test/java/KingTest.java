import Figure.*;

import Table.*;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class KingTest {
    @Test
    void MoveUp() {
        // move up
        Table testTable = new Table();
        King king = new King(Figure.Colour.BLACK);
        testTable.putFigure(new Coordinates("a1"), king);
        Assert.assertEquals(testTable.move(new Coordinates("a1"), new Coordinates("a2")), true);
    }

    @Test
    void MoveDown() {
        // move down
        Table testTable = new Table();
        King king = new King(Figure.Colour.BLACK);
        testTable.putFigure(new Coordinates("a5"), king);
        Assert.assertEquals(testTable.move(new Coordinates("a5"), new Coordinates("a4")), true);
    }

    @Test
    void MoveDiagonale() {
        // move down
        Table testTable = new Table();
        King king = new King(Figure.Colour.BLACK);
        testTable.putFigure(new Coordinates("a2"), king);
        Assert.assertEquals(testTable.move(new Coordinates("a2"), new Coordinates("b3")), true);
    }

    @Test
    void MoveUpFalse() {
        // move wrong
        Table testTable = new Table();
        King king = new King(Figure.Colour.BLACK);
        testTable.putFigure(new Coordinates("a5"), king);
        Assert.assertEquals(testTable.move(new Coordinates("a5"), new Coordinates("c1")), false);
    }

    @Test
    void MoveAndAttack() {
        //attack enemy figure
        Table testTable = new Table();
        King king = new King(Figure.Colour.WHITE);
        Rook rookB = new Rook(Figure.Colour.BLACK);
        testTable.putFigure(new Coordinates("a5"), king);
        testTable.putFigure(new Coordinates("a6"), rookB);
        Assert.assertTrue(testTable.move(new Coordinates("a5"), new Coordinates("a6")));
    }

    @Test
    void NotMoove() {
        //attack same color figure
        Table testTable = new Table();
        King rookW = new King(Figure.Colour.WHITE);
        Rook rookB = new Rook(Figure.Colour.WHITE);
        testTable.putFigure(new Coordinates("a5"), rookW);
        testTable.putFigure(new Coordinates("a6"), rookB);
        Assert.assertFalse(testTable.move(new Coordinates("a5"), new Coordinates("a6")));
    }

    @Test
    void kingCheck() {
        // фигура не защитила короля (был мат в прошлом ходу)
        Table testTable = new Table();
        King king = new King(Figure.Colour.WHITE);
        Rook rookB = new Rook(Figure.Colour.WHITE);
        Bishop bishop = new Bishop(Figure.Colour.BLACK);
        testTable.putFigure(new Coordinates("a5"), king);
        testTable.putFigure(new Coordinates("a6"), rookB);
        testTable.putFigure(new Coordinates("d8"), bishop);
        Assert.assertFalse(testTable.move(new Coordinates("a6"), new Coordinates("c6")));

    }

    @Test
    void kingCheck2() {
        // фигура ушла с защиты короля.
        Table testTable = new Table();
        King king = new King(Figure.Colour.WHITE);
        Rook rookB = new Rook(Figure.Colour.WHITE);
        Bishop bishop = new Bishop(Figure.Colour.BLACK);
        testTable.putFigure(new Coordinates("a5"), king);
        testTable.putFigure(new Coordinates("b6"), rookB);
        testTable.putFigure(new Coordinates("d8"), bishop);
        Assert.assertFalse(testTable.move(new Coordinates("b6"), new Coordinates("b8")));

    }

    @Test
    void kingCheck3() {
        // фигура cтала в защиту короля (был шах до этого)
        Table testTable = new Table();
        King king = new King(Figure.Colour.WHITE);
        Rook rookB = new Rook(Figure.Colour.WHITE);
        Bishop bishop = new Bishop(Figure.Colour.BLACK);
        testTable.putFigure(new Coordinates("a5"), king);
        testTable.putFigure(new Coordinates("a6"), rookB);
        testTable.putFigure(new Coordinates("d8"), bishop);
        Assert.assertTrue(testTable.move(new Coordinates("a6"), new Coordinates("b6")));

    }


}
