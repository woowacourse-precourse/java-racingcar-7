package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Winners {
    private final List<Car> winnerList;

    public Winners(List<Car> winnerList) {
        this.winnerList = new ArrayList<>(winnerList);
    }

    public String getWinnersList() {
        if (winnerList.size() == 1) {
            return winnerList.getFirst().getName();
        }
        return winnerList.stream()
                .map(Car::getName)
                .collect(Collectors.joining(", "));
    }
}
