package racingcar;

public class CarName {
    private final String carName;

    public CarName(String carName) {
        isNameLongerThanFive(carName);
        this.carName = carName;
    }

    public Car createCar(){
        return new Car(this.carName);
    }

    private static void isNameLongerThanFive(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException(name + "이름이 5자리가 넘습니다");
        }
    }
}
