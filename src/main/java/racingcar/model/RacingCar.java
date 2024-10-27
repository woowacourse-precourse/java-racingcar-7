package racingcar.model;

import static racingcar.util.Constants.ONE_MOVE;
import static racingcar.util.Validator.validateNameLength;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class RacingCar {

    private final List<String> distanceRecords = new ArrayList<>();
    private final String name;

    private Integer currentDistance;

    public RacingCar(String name) {
        this.name = validateNameLength(name);
        this.currentDistance = 0;
    }

    public void moveOrStop() {
        int randomNumber = Randoms.pickNumberInRange(0,9);
        if (randomNumber >= 4) {
            currentDistance++;
        }
        distanceRecords.add(String.format("%s : %s", name, ONE_MOVE.repeat(currentDistance)));
    }

    public String getName() {
        return name;
    }

    public Integer getDistance() {
        return currentDistance;
    }

    public String getDistance(Integer currentTrial) {
        int index = currentTrial-1;
        return distanceRecords.get(index);
    }
}
