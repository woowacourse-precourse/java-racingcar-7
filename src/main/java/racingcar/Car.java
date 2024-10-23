package racingcar;

public class Car {
    private final CarName carName;

    private Car(String name){
        this.carName = CarName.createCarName(name);
    }
    public static Car createNamedCar(String name){
        return new Car(name);
    }

    public void moveForwardPosition(int i) {

    }

    public void maintainCurrentPosition() {

    }

    public int provideCurrentPosition() {
        return 0;
    }

    public String provideCarName() {
        return carName.getValue();
    }
}
