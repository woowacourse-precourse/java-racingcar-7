package racingcar.domain.car;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.domain.car.value.Distance;
import racingcar.domain.car.value.Name;

import static racingcar.global.Const.*;

public class Car {

    private Name name;
    private Distance distance;

    private Car(Name name, Distance distance) {
        this.name = name;
        this.distance = distance;
    }

    public static Car create(Name carName) {
        return new Car(carName, new Distance());
    }

    public void go() {
        int randomNumber = Randoms.pickNumberInRange(START_NUMBER, END_NUMBER);

        if (randomNumber >= CRITERIA) {
            this.distance = distance.forward();
        }
    }

    public Name getName() {
        return name;
    }

    public Distance getDistance() {
        return distance;
    }


}
