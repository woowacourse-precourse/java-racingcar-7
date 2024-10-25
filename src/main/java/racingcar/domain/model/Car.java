package racingcar.domain.model;

import racingcar.domain.application.RaceService;
import racingcar.domain.model.value.Distance;
import racingcar.domain.model.value.Name;

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

    public void go(RaceService raceService) {
        if (raceService.canGo()) {
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
