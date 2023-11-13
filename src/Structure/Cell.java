package Structure;

public class Cell {
    private Position position;
    private CellType type;
    private boolean isOccupied;
    private int elementId;
    private Color color;

    public Cell(Position position, CellType type, boolean isOccupied, int elementId, Color color) {
        this.position = new Position(position);
        this.type = type;
        this.isOccupied = isOccupied;
        this.elementId = elementId;
        this.color = color;
    }

    public Position getPosition() {
        return position;
    }

    public CellType getType() {
        return type;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public int getElementId() {
        return elementId;
    }

    public Color getColor() {
        return color;
    }

    public void setOccupied(boolean occupied) {
        isOccupied = occupied;
    }

    public void setElementId(int elementId) {
        this.elementId = elementId;
    }

    public void setColor(Color color) {
        this.color = color;
    }

}
