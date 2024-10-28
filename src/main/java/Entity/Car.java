package Entity;

public class Car implements Moveable, Transfortation{
    private String name;
    private int moveCount;
    public Car(String name) {
        this.name = name;
        this.moveCount = 0;
    }
    public void move(int number) {
        if (number > 3)
            moveCount++;
    }

    public String getName() {
        return this.name;
    }

    public String getPath() {
        StringBuilder path = new StringBuilder();
        for (int i = 0; i < moveCount; i++)
            path.append("-");

        return path.toString();
    }

    public int getMoveCount() {
        return this.moveCount;
    }
}
