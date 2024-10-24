package racingcar;


import camp.nextstep.edu.missionutils.Randoms;

import java.util.Random;

public class Car {
    CarList carList = new CarList();

    public void addCar(String carNames) {
        for(String carName : carNames.split(",")) {
            carList.add(carName);
        }
    }

    public void SelectMoveOrStop() {
        int CarMove=0;
        if (CarMove == Randoms.pickNumberInRange(4,9)) {
            Move();
        }
    }
    public void Move() {
        this.position++;
    }

}
