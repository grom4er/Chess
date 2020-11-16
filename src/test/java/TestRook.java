import Figure.Figure;
import Figure.*;
import Table.*;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class TestRook {
    @Test
    void MoveUp() {
        // move up
        Table testTable = new Table();
        Rook rook = new Rook(Figure.Colour.WHITE);
        testTable.putFigure(new Coordinates("a1"), rook);
        Assert.assertEquals(testTable.move(new Coordinates("a1"), new Coordinates("a6")),true);
    }
    @Test
    void MoveDown() {
        // move down
        Table testTable = new Table();
        Rook rook = new Rook(Figure.Colour.WHITE);
        testTable.putFigure(new Coordinates("a5"), rook);
        Assert.assertEquals(testTable.move(new Coordinates("a5"), new Coordinates("a1")),true);
    }
    @Test
    void MoveUpFalse() {
        // move wrong
        Table testTable = new Table();
        Rook rook = new Rook(Figure.Colour.WHITE);
        testTable.putFigure(new Coordinates("a5"), rook);
        Assert.assertEquals(testTable.move(new Coordinates("a5"), new Coordinates("c1")),false);
    }
    @Test
    void MoveAndAttack() {
        //attack enemy figure
        Table testTable = new Table();
        Rook rookW = new Rook(Figure.Colour.WHITE);
        Rook rookB = new Rook(Figure.Colour.BLACK);
        testTable.putFigure(new Coordinates("a5"), rookW);
        testTable.putFigure(new Coordinates("a7"), rookB);
        Assert.assertTrue(testTable.move(new Coordinates("a5"), new Coordinates("a7")));
    }
    @Test
    void NotMoove(){
        //attack same color figure
        Table testTable = new Table();
        Rook rookW = new Rook(Figure.Colour.WHITE);
        Rook rookB = new Rook(Figure.Colour.WHITE);
        testTable.putFigure(new Coordinates("a5"), rookW);
        testTable.putFigure(new Coordinates("a7"), rookB);
        Assert.assertFalse(testTable.move(new Coordinates("a5"), new Coordinates("a7")));
    }
    @Test
    void AttackButNotWayClean(){
        //attack same color figure
        Table testTable = new Table();
        Rook rookW = new Rook(Figure.Colour.WHITE);
        Rook rookB = new Rook(Figure.Colour.BLACK);
        testTable.putFigure(new Coordinates("a6"), new Pawn(Figure.Colour.WHITE));
        testTable.putFigure(new Coordinates("a5"), rookW);
        testTable.putFigure(new Coordinates("a7"), rookB);
        Assert.assertFalse(testTable.move(new Coordinates("a5"), new Coordinates("a7")));
    }



}
