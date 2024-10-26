package racingcar;

public class CreateCar {
    public CreateCar() { }

    public Car create(String name) {
        Car tempCar = new Car(name);
        return tempCar;
    }
}
