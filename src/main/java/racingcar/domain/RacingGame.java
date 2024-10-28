package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private List<Integer> distances = new ArrayList<>();

    public void startGame(Car[] cars) {
        for(int i = 0; i < cars.length; i++){
            distances.add(cars[i].move());
        }
    }

    public List<Integer> getDistances() {
        return distances;
    }
}
