import figure.*;
import table.*;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class KnightTest {
    @Test
    void MoveUp() {
        // move up
        Table testTable = new Table();
        Knight knight = new Knight(Figure.Colour.WHITE);
        testTable.putFigure(new Coordinates("a1"), knight);
        Assert.assertEquals(testTable.move(new Coordinates("a1"), new Coordinates("b3")), true);
    }

    @Test
    void MoveLeft() {
        // move
        Table testTable = new Table();
        Knight knight = new Knight(Figure.Colour.WHITE);
        testTable.putFigure(new Coordinates("e5"), knight);
        Assert.assertEquals(testTable.move(new Coordinates("e5"), new Coordinates("c6")), true);
    }

    @Test
    void MoveUpFalse() {
        // move wrong
        Table testTable = new Table();
        Knight knight = new Knight(Figure.Colour.WHITE);
        testTable.putFigure(new Coordinates("a6"), knight);
        Assert.assertEquals(testTable.move(new Coordinates("a6"), new Coordinates("c1")), false);
    }

    @Test
    void MoveAndAttack() {
        //attack enemy figure
        Table testTable = new Table();
        Knight knight = new Knight(Figure.Colour.WHITE);
        Rook rookB = new Rook(Figure.Colour.BLACK);
        testTable.putFigure(new Coordinates("a5"), knight);
        testTable.putFigure(new Coordinates("c6"), rookB);
        Assert.assertTrue(testTable.move(new Coordinates("a5"), new Coordinates("c6")));
    }

    @Test
    void NotMoove() {
        //attack same color figure
        Table testTable = new Table();
        Knight knight = new Knight(Figure.Colour.WHITE);
        Rook rookB = new Rook(Figure.Colour.WHITE);
        testTable.putFigure(new Coordinates("a5"), knight);
        testTable.putFigure(new Coordinates("c6"), rookB);
        Assert.assertFalse(testTable.move(new Coordinates("a5"), new Coordinates("c6")));
    }

    @Test
    void AttackButNotWayClean() {
        //attack same color figure
        Table testTable = new Table();
        Knight knight = new Knight(Figure.Colour.WHITE);
        Rook rookB = new Rook(Figure.Colour.BLACK);
        testTable.putFigure(new Coordinates("a5"), knight);
        testTable.putFigure(new Coordinates("c5"), rookB);
        Assert.assertTrue(testTable.move(new Coordinates("a5"), new Coordinates("c6")));
    }

}
