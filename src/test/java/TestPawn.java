import Figure.Figure;
import Figure.*;
import Table.*;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class TestPawn {

    @Test
    void test() {
        Table testTable = new Table();
        Pawn pawn = new Pawn(Figure.Colour.WHITE);
        Rook rook = new Rook(Figure.Colour.WHITE);
        testTable.putFigure(new Coordinates("a1"), rook);
        testTable.putFigure(new Coordinates("a5"), pawn);
        Assert.assertEquals(rook.isWayClean(new Coordinates("a1"), new Coordinates("a6"), testTable),true);
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


    void createCharapter() {
        char start = 'A';
        System.out.println();
        for (int i = 0; i < 8; i++) {
            System.out.print(" ".repeat(12) + start++);
        }
    }

    void show(Table table) {
        createCharapter();
        for (int i = 7; i >= 0; i--) {
            System.out.print("\n" + (i + 1) + " ");
            for (int j = 0; j < 8; j++) {
                if (table.figures[i][j] == null) {
                    System.out.print("Empty ");
                    continue;
                }
                System.out.print(table.figures[i][j].toString());
            }

        }
        createCharapter();
    }


    public static void main(String[] args) {
        TestPawn test = new TestPawn();


    }
}
