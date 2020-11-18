import figure.Figure;
import figure.*;
import table.*;
import org.junit.Assert;
import org.junit.jupiter.api.Test;


public class TestKnight {
    @Test
    void move() {
        Table testTable = new Table();
        Knight knight = new Knight(Figure.Colour.WHITE);
        testTable.putFigure(new Coordinates("b1"), knight);
        Assert.assertEquals(testTable.move(new Coordinates("b1"), new Coordinates("a3")),true);
    }

}
