package racingcar.car;

public class RacingCar {

    private String carName;
    private Long distance;

    public void forwardCar(Long move) {
        distance += move;
    }
}
