package racingcar.model;

public class Car {
    private String name;
    private Integer score;

    public Car(String name) {
        this.name = name;
        this.score = 0;
    }

    public String getName() {
        return name;
    }

    public Integer getScore() {
        return score;
    }
}
