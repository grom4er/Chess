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
        Assert.assertEquals(testTable.move(new Coordinates("a1"), new Coordinates("a2")),true);
    }
    @Test
    void MoveDown() {
        // move down
        Table testTable = new Table();
        King king = new King(Figure.Colour.BLACK);
        testTable.putFigure(new Coordinates("a5"), king);
        Assert.assertEquals(testTable.move(new Coordinates("a5"), new Coordinates("a4")),true);
    }
    @Test
    void MoveDiagonale() {
        // move down
        Table testTable = new Table();
        King king = new King(Figure.Colour.BLACK);
        testTable.putFigure(new Coordinates("a2"), king);
        Assert.assertEquals(testTable.move(new Coordinates("a2"), new Coordinates("b3")),true);
    }
    @Test
    void MoveUpFalse() {
        // move wrong
        Table testTable = new Table();
        King king = new King(Figure.Colour.BLACK);
        testTable.putFigure(new Coordinates("a5"), king);
        Assert.assertEquals(testTable.move(new Coordinates("a5"), new Coordinates("c1")),false);
    }
    @Test
    void MoveAndAttack() {
        //attack enemy figure
        Table testTable = new Table();
        King king = new King(Figure.Colour.WHITE);Rook rookB = new Rook(Figure.Colour.BLACK);
        testTable.putFigure(new Coordinates("a5"), king);
        testTable.putFigure(new Coordinates("a6"), rookB);
        Assert.assertTrue(testTable.move(new Coordinates("a5"), new Coordinates("a6")));
    }
    @Test
    void NotMoove(){
        //attack same color figure
        Table testTable = new Table();
        Rook rookW = new Rook(Figure.Colour.WHITE);
        Rook rookB = new Rook(Figure.Colour.WHITE);
        testTable.putFigure(new Coordinates("a5"), rookW);
        testTable.putFigure(new Coordinates("a6"), rookB);
        Assert.assertFalse(testTable.move(new Coordinates("a5"), new Coordinates("a6")));
    }


}
