package racingcar.domain.model;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.domain.model.value.Distance;
import racingcar.domain.model.value.Name;

import static racingcar.Const.*;

public class Car {

    private Name name;
    private Distance distance;

    private Car(Name name, Distance distance) {
        this.name = name;
        this.distance = distance;
    }

    public static Car create(String carName) {
        return new Car(new Name(carName), new Distance());
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
