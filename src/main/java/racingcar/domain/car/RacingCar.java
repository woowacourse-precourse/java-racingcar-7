package racingcar.domain.car;

public class RacingCar {

    private String name;
    private int forwardCount;

    public RacingCar(String name) {
        this.name = name;
        this.forwardCount = 0;
    }

    public String getName() {
        return name;
    }

    public int getForwardCount() {
        return forwardCount;
    }
}
