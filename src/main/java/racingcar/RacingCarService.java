package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
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

    //두가지 일을 하는게 아닌가?
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

    public List<String> listRacingWinners(Map<String, String> racingResult, String maxMove) {
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

    public void validateCarNamesInput(String carNames) {
        List<String> listCarNames = splitCarNames(carNames);

        if (carNames.isEmpty()) {
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }
        if (!carNames.contains(",")) {
            throw new IllegalArgumentException("자동차 이름은 쉼표(,)를 기준으로 구분해야 합니다.");
        }

        if (isDuplicateCarName(listCarNames)) {
            throw new IllegalArgumentException("자동차 이름이 중복입니다.");
        }

        for (String carName : listCarNames) {
            if (carName.length() > 5) {
                throw new IllegalArgumentException("이름은 5자 이하만 가능합니다.");
            }
        }
    }

    public boolean isDuplicateCarName(List<String> listCarNames) {
        Set<String> checkCarName = new HashSet<>(listCarNames);

        if (listCarNames.size() != checkCarName.size()) {
            return true;
        }
        return false;
    }
}
