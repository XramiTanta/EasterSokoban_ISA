package Structure;

public class Element {
    private static int counter=0;
    protected int id;
    protected Position position;
    protected Color color;

    public Element(Position position, Color color) {
        counter ++ ;
        this.id = counter;
        this.position = position;
        this.color = color;
    }

    public Element(Element element){
        this.counter = element.counter;
        this.id = element.id;
        this.position = element.position;
        this.color = element.color;
    }

    public int getId() {
        return id;
    }
    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Element{" +
                "id =" + id +
                ", position=" + position +
                ", color=" + color +
                '}';
    }


}
