package racingcar;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Car car = Car.createNamedCar("kim");
        car.moveForwardPosition(1);
        car.maintainCurrentPosition();
        int currentPosition = car.provideCurrentPosition();
        String carName = car.provideCarName();
    }
}
