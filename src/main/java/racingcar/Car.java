package racingcar;

public class Car {
    private String name;
    private boolean move;

    public Car(String name, boolean move) {
        this.name = name;
        this.move = move;
    }

    public void setMove(boolean move){
        this.move = move;
    }

    public boolean getMove() {
        return move;
    }
}
