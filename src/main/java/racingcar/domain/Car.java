package racingcar.domain;

public record Car(
        String name,
        int distance
) {

    public static Car makeOriginCar(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("이름의 길이는 5자 이하여야 합니다.");
        }
        return new Car(name, 0);
    }

    public Car updateDistance(Car car, boolean followingNumberRule) {
        if (followingNumberRule) {
            return new Car(car.name, car.distance + 1);
        }
        return car;
    }
}
