package racingcar.Domain;

import static racingcar.Util.Constants.Constant.DISTANCE_OF_WINNER;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import racingcar.DTO.RaceResultDTO;

public class RaceResultEvaluator {
    private final List<String> winnerList = new ArrayList<>();
    private HashMap<String, Integer> carList;

    public void evaluateFinalWinners(RaceResultDTO raceResultDTO) {
        this.carList = raceResultDTO.getCarList();
        Integer maxDistance = DISTANCE_OF_WINNER.getValue();

        for (Integer distance : carList.values()) {
            if (distance > maxDistance) {
                maxDistance = distance;
            }
        }

        for (String carName : carList.keySet()) {
            if (carList.get(carName).equals(maxDistance)) {
                winnerList.add(carName);
            }
        }
    }

    public List<String> getWinners() {
        return new ArrayList<>(winnerList);
    }
}
