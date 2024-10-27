package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class RacingCarService {

    public List<String> splitCarNames(String carNames) {

        List<String> listCarNames = new ArrayList<>();
        StringTokenizer stringTokenizer = new StringTokenizer(carNames);

        while (stringTokenizer.hasMoreTokens()) {
            listCarNames.add(stringTokenizer.nextToken(","));
        }

        return listCarNames;
    }

    public Map<String, String> initializeCarPositions(List<String> carNames) {
        Map<String, String> mapCarNames = new LinkedHashMap<>();

        for (int i = 0; i < carNames.size(); i++) {
            mapCarNames.put(carNames.get(i), "");
        }
        return mapCarNames;
    }

    public Map<String, String> updateCarPositions(Map<String, String> mapRacingCars, List<String> carNames) {
        for (int i = 0; i < carNames.size(); i++) {
            String carName = carNames.get(i);
            String value = mapRacingCars.getOrDefault(carNames.get(i), "");
            value += "-";
            mapRacingCars.put(carName, value);
        }
        return mapRacingCars;
    }

    public List<String> getListCanMoveCarNames(List<String> carNames) {
        List<String> listMoveCarNames = new ArrayList<>();

        for (int i = 0; i < carNames.size(); i++) {
            String carName = carNames.get(i);
            if (canMove()) {
                listMoveCarNames.add(carName);
            }
        }
        return listMoveCarNames;
    }

    public boolean canMove() {
        return createRandomNumber() >= 4;
    }

    public List<String> getListRacingWinners(Map<String, String> racingResult, String maxMove) {
        List<String> listRacingWinners = new ArrayList<>();

        for (String key : racingResult.keySet()) {
            if (racingResult.get(key).equals(maxMove)) {
                listRacingWinners.add(key);
            }
        }
        return listRacingWinners;
    }

    public String findMaxMove(Map<String, String> racingResult) {
        return Collections.max(racingResult.values());
    }

    private int createRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }
}
