package racingcar.dto;

public class RacingCar {
    private String name;
    private int move;

    public RacingCar() {}

    public RacingCar(String name, int move) {
        this.name = name;
        this.move = move;
    }

    public void incrementMove() {
        move++;
    }

    public String getName() {
        return name;
    }

    public int getMove() {
        return move;
    }

    @Override
    public String toString() {
        return "name : " + name + " move : " + move;
    }
}
