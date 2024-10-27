package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Car {

    private static final int RANDOM_EXPECTED = 4;

    private String name;
    private List<Integer> distance;

    public Car(final String name) {
        this.name = name;
        this.distance = new ArrayList<>();
        this.distance.add(0);
    }

    public void goOrStop() {
        int randomNumber = Randoms.pickNumberInRange(0, 9);

        if (randomNumber >= RANDOM_EXPECTED) {
            distance.add(distance.getLast() + 1);
        } else {
            distance.add(distance.getLast());
        }
    }

    public String getName() {
        return this.name;
    }

    public int getDistance(final int turnTime) {
        return this.distance.get(turnTime);
    }
    
    public int getFinalDistance() {
        return this.distance.getLast();
    }

}
