package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private List<Integer> distances = new ArrayList<>();

    public void startGame(Cars cars) {
        for(int i = 0; i < cars.size(); i++){
            distances.add(cars.findCarByNumber(i).move());
        }
    }

    public List<Integer> getDistances() {
        return distances;
    }
}
