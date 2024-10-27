package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.HashSet;

public class Car {
    public final String carName;
    public  int position;

    public Car(String carName) {
        validateNaming(carName);
        this.carName = carName;
        position = 0;
    }

    public void incrementPosition() {
        position+=1;
    }

    public void moveFoward() {
        int randomValue = Randoms.pickNumberInRange(0,9);

        if(randomValue >= 4) {
            incrementPosition();
        }
    }
    private void validateNaming(String carName) {
        if(carName.isEmpty() || carName.length() >5) {
            throw new IllegalArgumentException();
        }
    }
}
