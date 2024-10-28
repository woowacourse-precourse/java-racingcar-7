package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class MoveCar {
    public List<String> whichCarCanForward(List<String> carList) {
        int numberOfCar = carList.size();
        List<String> carCanFowardList = new ArrayList<>();

        for (int indexOfCar = 0; indexOfCar < numberOfCar; indexOfCar++) {
            boolean thisCarCanMove = canMoveCar();

            if (thisCarCanMove) {
                carCanFowardList.add(carList.get(indexOfCar));
            }
        }

        return carCanFowardList;
    }

    private boolean canMoveCar() {
        int randomNumber = makeRandomNumber();

        if (randomNumber >= 4) {
            return true;
        }

        return false;
    }

    private int makeRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }
}
