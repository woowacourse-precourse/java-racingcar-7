package racingcar.domain;

public record Car(
        String name,
        int distance
) {

    public Car updateDistance(Car car, boolean followingNumberRule) {
        if (followingNumberRule) {
            return new Car(car.name, car.distance + 1);
        }
        return car;
    }
}
