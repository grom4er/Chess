package table;

public class Coordinates {
    public int x, y;

    public Coordinates(String data) {
        y = data.charAt(0) - 97;
        x = data.charAt(1) - 49;
    }

    public Coordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }


}
