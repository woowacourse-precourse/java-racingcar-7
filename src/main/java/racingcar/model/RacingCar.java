package racingcar.model;

import static racingcar.util.ConstantRacingData.NAME_LENGTH_LIMIT;
import static racingcar.util.message.ExceptionMessage.NAME_LENGTH_NOT_VALID;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class RacingCar {

    private final List<Integer> moveRecords = new ArrayList<>();
    private final String name;
    private int distance;

    public RacingCar(String name) {
        validate(name);
        this.name = name;
    }

    public static void validate(String name) {
        if (name.isEmpty() || name.length() > NAME_LENGTH_LIMIT) {
            throw new IllegalArgumentException(NAME_LENGTH_NOT_VALID.get());
        }
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
