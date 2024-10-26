package racingcar.domain;

import java.util.List;

public class Race {

    private final List<Car> raceCars;

    private Race(List<Car> raceCars) {
        this.raceCars = raceCars;
    }

    public List<Car> getRaceCars() {
        return raceCars;
    }

}
