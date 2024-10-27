package racingcar.model;

public class Car {
    private String name;
    private Integer move;

    public Car(String name) {
        this.name = name;
        this.move = 0;
    }

    public String getName() {
        return name;
    }

    public Integer getMove() {
        return move;
    }

    public void addMove() {
        this.move +=1;
    }
}
