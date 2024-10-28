package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Race {
    private final int MIN_VALUE = 0;
    private final int MAX_VALUE = 9;
    private int tryCount;
    private List<Car> cars = new ArrayList<>();

    public void setCars(String names) {

        String[] carNames = names.split(",");

        for (String carName : carNames) {
            if (carName.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5글자 이하여야 합니다.");
            }

            cars.add(new Car(carName));
        }
    }

    private int generateRandomNum() {
        return Randoms.pickNumberInRange(MIN_VALUE, MAX_VALUE);
    }
}
