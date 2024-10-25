package racingcar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class RacingCarService {

    public List<String> splitCarNames(String carNames) {
        //공백이 넘어온 경우? 구분자가 없는 경우?
        List<String> listCarNames = new ArrayList<>();
        StringTokenizer stringTokenizer = new StringTokenizer(carNames);

        while (stringTokenizer.hasMoreTokens()) {
            listCarNames.add(stringTokenizer.nextToken(","));
        }

        return listCarNames;
    }

    public Map<String, String> mapCarNames(List<String> carNames) {
        Map<String, String> mapCarNames = new HashMap<>();

        for (int i = 0; i < carNames.size(); i++) {
            mapCarNames.put(carNames.get(i), "");
        }
        return mapCarNames;
    }

    public Map<String, String> moveCar(Map<String, String> mapRacingCars, List<String> carNames) {
        for (int i = 0; i < carNames.size(); i++) {
            String carName = carNames.get(i);
            String value = mapRacingCars.getOrDefault(carNames.get(i), "");
            value += "-";
            mapRacingCars.put(carName, value);
        }
        return mapRacingCars;
    }

    public List<String> listMoveCarNames(List<String> carNames) {
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

    private int createRandomNumber() {
        return (int) (Math.random() * 10);
    }
}
