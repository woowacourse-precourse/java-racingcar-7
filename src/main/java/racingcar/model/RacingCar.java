package racingcar.model;

import static racingcar.util.ConstantRacingData.NAME_LENGTH_LIMIT;
import static racingcar.util.ConstantRacingData.ONE_MOVE;
import static racingcar.util.message.ExceptionMessage.NAME_LENGTH_NOT_VALID;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class RacingCar {

    private final List<String> distanceRecords = new ArrayList<>();
    private final String name;

    private int currentDistance;

    public RacingCar(String name) {
        validate(name);
        this.name = name;
    }

    private void validate(String name) {
        if (name.isEmpty() || name.length() > NAME_LENGTH_LIMIT) {
            throw new IllegalArgumentException(NAME_LENGTH_NOT_VALID.get());
        }
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
