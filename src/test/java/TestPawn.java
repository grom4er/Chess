import figure.Figure;
import figure.*;
import table.*;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class TestPawn {


    @Test
    void attackInSameLane() {
        Table testTable = new Table();
        Pawn pawn = new Pawn(Figure.Colour.WHITE);
        Rook rook = new Rook(Figure.Colour.BLACK);
        testTable.putFigure(new Coordinates("a3"), rook);
        testTable.putFigure(new Coordinates("a2"), pawn);
        Assert.assertEquals(testTable.move(new Coordinates("a2"), new Coordinates("a3")),false);
    }


    @Test
    void forwadOneWhite() {
        // Сдвиг на 1 клетку
        Table testTable = new Table();
        Coordinates start = new Coordinates("e2");
        Coordinates to = new Coordinates("e3");
        testTable.putFigure(start, new Pawn(Figure.Colour.WHITE));
        Assert.assertEquals(testTable.move(start, to), true);
    }

    @Test
    void forwadTwoWhite() {
        //сдвиг на 2 клетки с начальной позиции
        Table testTable = new Table();
        Coordinates start = new Coordinates("e2");
        Coordinates to = new Coordinates("e4");
        testTable.putFigure(start, new Pawn(Figure.Colour.WHITE));
        Assert.assertEquals(testTable.move(start, to), true);
    }

    @Test
    void forwadTwoWhite2() {
        //сдвиг на 2 клетки с не начальной позиции
        Table testTable = new Table();
        Coordinates start = new Coordinates("e3");
        Coordinates to = new Coordinates("e5");
        testTable.putFigure(start, new Pawn(Figure.Colour.WHITE));
        Assert.assertEquals(testTable.move(start, to), false);
    }

    @Test
    void forwadOneBlack() {
        // Сдвиг на 1 клетку
        Table testTable = new Table();
        Coordinates start = new Coordinates("e7");
        Coordinates to = new Coordinates("e6");
        testTable.putFigure(start, new Pawn(Figure.Colour.BLACK));
        Assert.assertEquals(testTable.move(start, to), true);
    }

    @Test
    void forwadTwoBlack() {
        // Сдвиг на 2 с начальной позиции
        Table testTable = new Table();
        Coordinates start = new Coordinates("e7");
        Coordinates to = new Coordinates("e5");
        testTable.putFigure(start, new Pawn(Figure.Colour.BLACK));
        Assert.assertEquals(testTable.move(start, to), true);
    }

    @Test
    void forwadTwoBlack2() {
        //сдвиг на 2 клетки с не начальной позиции
        Table testTable = new Table();
        Coordinates start = new Coordinates("e6");
        Coordinates to = new Coordinates("e4");
        testTable.putFigure(start, new Pawn(Figure.Colour.BLACK));
        Assert.assertEquals(testTable.move(start, to), false);
    }

    @Test
    void attackFigure() {
        //атака противоположной фигуры
        Table testTable = new Table();
        Coordinates start = new Coordinates("e6");
        testTable.putFigure(start, new Pawn(Figure.Colour.BLACK));
        Coordinates start1 = new Coordinates("d5");
        testTable.putFigure(start1, new Pawn(Figure.Colour.WHITE));
        Assert.assertEquals(testTable.move(start1, start), true);
    }

    @Test
    void attackFigure1() {
        //атака одинаковой фигуры
        Table testTable = new Table();
        Coordinates start = new Coordinates("e6");
        testTable.putFigure(start, new Pawn(Figure.Colour.BLACK));
        Coordinates start1 = new Coordinates("b5");
        testTable.putFigure(start, new Pawn(Figure.Colour.BLACK));
        Assert.assertEquals(testTable.move(start1, start), false);
    }

    @Test
    void forward2ToFigure() {
        //попытка пройти через фигуры с начальной позиции
        Table testTable = new Table();
        Coordinates start = new Coordinates("e7");
        testTable.putFigure(start, new Pawn(Figure.Colour.BLACK));
        Coordinates start1 = new Coordinates("e6");
        testTable.putFigure(start, new Pawn(Figure.Colour.BLACK));
        Assert.assertEquals(testTable.move(start1, new Coordinates("e5")), false);
    }


}
