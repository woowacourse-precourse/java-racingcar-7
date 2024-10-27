package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Cars extends Validator {
    private Map<String, Integer> roundStatus;
    private static final int START_CAR_POSITION = 0;

    public void createRoundStatus(String carNames) {
        List<String> carNamesList = refineString(carNames);
        Map<String, Integer> roundStatus = new LinkedHashMap<>();

        for (String carName : carNamesList) {
            validateName(carName);
            roundStatus.put(carName, START_CAR_POSITION);
        }
        setRoundStatus(roundStatus);
    }

    public void updateRoundStatus(Cars cars) {
        Map<String, Integer> roundStatus = cars.getRoundStatus();

        for (Entry<String, Integer> entry : roundStatus.entrySet()) {
            String carName = entry.getKey();
            int carPosition = entry.getValue();

            carPosition = updatePosition(carPosition);
            roundStatus.put(carName, carPosition);
        }
        setRoundStatus(roundStatus);
    }

    public int updatePosition(int currentPosition) {
        int position = Randoms.pickNumberInRange(0, 9);

        if (validatePosition(position)) {
            currentPosition++;
        }
        return currentPosition;
    }

    private void setRoundStatus(Map<String, Integer> roundStatus) {
        this.roundStatus = roundStatus;
    }

    public Map<String, Integer> getRoundStatus() {
        return roundStatus;
    }
}