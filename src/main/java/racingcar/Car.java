package racingcar;

public class Car {
    private final String CarName;
    private int CarPosition;

    // 자동차 이름 5자 이하만 입력
    public Car(String CarName) {
        if (CarName.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
        }
        this.CarName = CarName;
    }

    public String GetCarName() {
        return CarName;
    }

    public int GetCarPosition() {
        return CarPosition;
    }

    public void CarMove() {
        CarPosition++;
    }

    public boolean MoveCondition(int randomNum) {
        return randomNum >= 4;
    }
}
