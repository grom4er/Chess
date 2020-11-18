import figure.Figure;
import figure.*;
import table.*;
import org.junit.Assert;
import org.junit.jupiter.api.Test;


public class TestBishop {
    @Test
    void MoveUpRight() {
        // move up right
        Table testTable = new Table();
        Bishop bishop = new Bishop(Figure.Colour.WHITE);
        testTable.putFigure(new Coordinates("a1"), bishop);
        Assert.assertEquals(testTable.move(new Coordinates("a1"), new Coordinates("d4")),true);
    }
    @Test
    void MoveUpLeft() {
        // move up left
        Table testTable = new Table();
        Bishop bishop = new Bishop(Figure.Colour.WHITE);
        testTable.putFigure(new Coordinates("e2"), bishop);
        Assert.assertEquals(testTable.move(new Coordinates("e2"), new Coordinates("a6")),true);
    }
    @Test
    void MoveDownRight() {
        // move down right
        Table testTable = new Table();
        Bishop bishop = new Bishop(Figure.Colour.WHITE);
        testTable.putFigure(new Coordinates("d2"), bishop);
        Assert.assertEquals(testTable.move(new Coordinates("d2"), new Coordinates("a5")),true);
    }
    @Test
    void MoveDownLeft() {
        // move down left
        Table testTable = new Table();
        Bishop bishop = new Bishop(Figure.Colour.WHITE);
        testTable.putFigure(new Coordinates("d2"), bishop);
        Assert.assertEquals(testTable.move(new Coordinates("d2"), new Coordinates("h6")),true);
    }
    @Test
    void MoveUpFalse() {
        // move wrong
        Table testTable = new Table();
        Bishop bishop = new Bishop(Figure.Colour.WHITE);
        testTable.putFigure(new Coordinates("e2"), bishop);
        Assert.assertEquals(testTable.move(new Coordinates("e2"), new Coordinates("e1")),false);
    }
    @Test
    void MoveAndAttack() {
        //attack enemy figure
        Table testTable = new Table();
        Bishop bishop = new Bishop(Figure.Colour.WHITE);
        testTable.putFigure(new Coordinates("e2"), bishop);
        Rook rookB = new Rook(Figure.Colour.BLACK);
        testTable.putFigure(new Coordinates("c4"), rookB);
        Assert.assertTrue(testTable.move(new Coordinates("e2"), new Coordinates("c4")));
    }

    @Test
    void notAttack() {
        //attack enemy figure
        Table testTable = new Table();
        Bishop bishop = new Bishop(Figure.Colour.WHITE);
        testTable.putFigure(new Coordinates("e2"), bishop);
        Rook rookB = new Rook(Figure.Colour.WHITE);
        testTable.putFigure(new Coordinates("c4"), rookB);
        Assert.assertFalse(testTable.move(new Coordinates("e2"), new Coordinates("c4")));
    }

    @Test
    void AttackButNotWayClean(){
        //attack same color figure
        Table testTable = new Table();
        Bishop bishop = new Bishop(Figure.Colour.WHITE);
        testTable.putFigure(new Coordinates("e2"), bishop);
        Rook rookB = new Rook(Figure.Colour.BLACK);
        testTable.putFigure(new Coordinates("c4"), rookB);
        testTable.putFigure(new Coordinates("d3"), new Pawn(Figure.Colour.WHITE));
        Assert.assertFalse(testTable.move(new Coordinates("a2"), new Coordinates("c4")));
    }

}
