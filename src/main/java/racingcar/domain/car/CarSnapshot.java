package racingcar.domain.car;

public record CarSnapshot(String name, int position) {

    public static CarSnapshot capture(Car car) {
        return new CarSnapshot(car.getName(), car.getPosition());
    }
}
