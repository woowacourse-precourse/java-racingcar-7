package racingcar.model;

import static racingcar.util.Validator.validateNameLength;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class RacingCar {

    private final List<Integer> moveRecords = new ArrayList<>();
    private final String name;
    private int distance;

    public RacingCar(String name) {
        validateNameLength(name);
        this.name = name;
    }

    public void moveOrStop() {
        int randomNumber = Randoms.pickNumberInRange(0,9);
        if (randomNumber >= 4) {
            distance++;
        }
        moveRecords.add(distance);
    }

    public String getName() {
        return name;
    }

    public Integer getDistance(Integer currentTrialCount) {
        int index = currentTrialCount-1;
        return moveRecords.get(index);
    }
}
