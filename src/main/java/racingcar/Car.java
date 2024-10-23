package racingcar;

public class Car {

    private Car(String name){
        if(name.length()>10){
            throw new IllegalArgumentException("자동차 이름은 최대 10자까지 가능합니다.");
        }
        if(name.length()<1){
            throw new IllegalArgumentException("자동차 이름은 최소 1자부터 가능합니다.");
        }
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
        return null;
    }
}
