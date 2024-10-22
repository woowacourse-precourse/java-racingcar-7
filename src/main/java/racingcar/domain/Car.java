package racingcar.domain;

public record Car(
    String name,
    int distance
) {

    public Car updateDistance(Car car, int randomNumber) {
        if (randomNumber >= 4) {
            return new Car(car.name, car.distance + 1);
        }
        return car;
    }
}
