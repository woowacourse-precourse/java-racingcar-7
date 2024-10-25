package racingcar.domain;

public class RacingCar {
    private String name;
    private Integer position = 0;

    public RacingCar(String name) {
        this.name=name;
    }

    public void moveForward() {
        position++;
    }

    public String getName() {
        return name;
    }

    public Integer getPosition() {
        return position;
    }
}
