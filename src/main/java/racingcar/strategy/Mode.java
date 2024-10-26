package racingcar.strategy;

public interface Mode {
    void go();

    Integer getRandomNumber();

    Integer getMovementDistance();
}
