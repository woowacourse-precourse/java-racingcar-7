package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Winners {
    List<Car> winners = new ArrayList<>();

    public Winners(List<Car> winners) {
        this.winners = winners;
    }
}