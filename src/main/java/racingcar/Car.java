package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private int position = 0;
    private final CarList carList = new CarList();
    private TryNumber tryNumber; // TryNumber 필드 추가

    public void addCar(String carNames) {
        for (String carName : carNames.split(",")) {
            carList.add(carName);
        }
    }

    public void selectMoveOrStop() {
        if (Randoms.pickNumberInRange(0, 9) >= 4) {
            move();
        }
    }

    public void move() {
        this.position++;
    }

    public int getPosition() {
        return position;
    }

    // setTryNumber 메서드 추가
    public void setTryNumber(String tryNumberValue) {
        this.tryNumber = new TryNumber();
        this.tryNumber.setTryNumber(tryNumberValue);
    }
}
