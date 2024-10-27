package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private final List<String> carList;
    private final List<Integer> carPositions;

    public Game(List<String> carList) {
        this.carList = carList;
        this.carPositions = new ArrayList<>();
        for (int i = 0; i < carList.size(); i++) {
            carPositions.add(0);
        }
    }

}
