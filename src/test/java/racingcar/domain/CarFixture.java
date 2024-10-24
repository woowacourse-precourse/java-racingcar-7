package racingcar.domain;

public class CarFixture {

    public static Car createCar() {
        CarName naem = new CarName("car1");
        return new Car(naem, 0);
    }
}
