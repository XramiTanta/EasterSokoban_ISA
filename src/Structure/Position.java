package Structure;

import javafx.geometry.Pos;

public class Position {
    private int x;
    private int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Position(Position position){
        this.setX(position.getX());
        this.setY(position.getY());
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

//    public void setPosition(Position Position){
//        this.setX();
//    }

//    public void moveUp() {
//        y--;
//    }
//
//    public void moveDown() {
//        y++;
//    }
//
//    public void moveLeft() {
//        x--;
//    }
//
//    public void moveRight() {
//        x++;
//    }

//    public double distanceTo(Position other) {
//        int dx = other.x - x;
//        int dy = other.y - y;
//        return Math.sqrt(dx * dx + dy * dy);
//    }

//    @Override
//    public boolean equals(Object obj) {
//        if (this == obj) {
//            return true;
//        }
//        if (obj == null || getClass() != obj.getClass()) {
//            return false;
//        }
//        Position other = (Position) obj;
//        return x == other.x && y == other.y;
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(x, y);
//    }
//
    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}