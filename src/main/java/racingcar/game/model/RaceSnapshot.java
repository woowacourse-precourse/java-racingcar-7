package racingcar.game.model;

public record RaceSnapshot(
        String carName,
        int moveCount
) {
    public RaceSnapshot(Car car) {
        this(car.getName(), car.getMoveCount());
    }
}