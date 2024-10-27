package racingcar;

public class Car {
    private String name;
    private boolean move;
    private int position;

    public Car(String name, boolean move, int position) {
        this.name = name;
        this.move = move;
        this.position = position;
    }

    public void setMove(boolean move){
        this.move = move;
    }

    public boolean getMove() {
        return move;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position += position;
    }
}
