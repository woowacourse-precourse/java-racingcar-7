package racingcar;

public class Car {

    private Car(){

    }
    public static Car createNamedCar(String name){
        return new Car();
    }

    public void moveForwardPosition(int i) {

    }

    public void maintainCurrentPosition() {

    }

    public int provideCurrentPosition() {
        return 0;
    }

    public String provideCarName() {
        return null;
    }
}
