package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Race {

    private final List<Car> Cars;
    private final int tryCount;

    public Race(List<Car> Cars, int tryCount) {
        this.Cars = new ArrayList<>();
        this.tryCount = tryCount;
    }


}
