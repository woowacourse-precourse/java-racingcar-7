package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GameModel {
    private Map<String, Integer> carMap;
    public void setCarMap(String[] carNames) {
        trimCarNames(carNames);
        List<String> validCarNames = Arrays.stream(carNames)
                .filter(name -> !name.isEmpty())
                .toList();
        validateCarNames(validCarNames);
        initializeCarMap(validCarNames);
    }

    public void moveCars() {
        for (String key : carMap.keySet()) {
            if (Randoms.pickNumberInRange(0, 9) >= 4) {
                carMap.put(key, carMap.get(key) + 1);
            }
        }
    }

    public Map<String, Integer> getCarMap() {
        return carMap;
    }

    private static void validateCarNames(List<String> carNames) {
        Pattern pattern = Pattern.compile("[!@#$%^&*(),.?\":{}|<>]");
        for (String carName : carNames) {
            if (carName.length() > 5) throw new IllegalArgumentException("자동차 이름은 5자 이하여야 합니다.");
            Matcher matcher = pattern.matcher(carName);
            if (matcher.find()) {
                throw new IllegalArgumentException("특수문자는 사용 불가능 합니다.");
            }
        }
        if (carNames.size() < 2) throw new IllegalArgumentException("자동차는 2대 이상이어야 합니다.");
    }

    private void initializeCarMap(List<String> carNames) {
        carMap = new LinkedHashMap<>();
        for (String carName : carNames) {
            carMap.put(carName, 0);
        }
    }

    private void trimCarNames(String[] carNames) {
        for (int i = 0; i < carNames.length; i++) {
            carNames[i] = carNames[i].strip();
        }
    }

    public int getRound(String gameRound) {
        validateRound(gameRound);
        return Integer.parseInt(gameRound);
    }

    private void validateRound(String gameRound) {
        try {
            long numRound = Long.parseLong(gameRound);
            if (numRound < 1) throw new IllegalArgumentException("게임 횟수는 최소 한번입니다.");
            if (numRound > Integer.MAX_VALUE) {
                throw new IllegalArgumentException("정수 최대 범위를 초과했습니다.");
            }
            System.out.println();
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("정수 이외의 값은 입력이 불가능합니다.");
        }
    }

    public List<String> getWinner(Map<String, Integer> carMap) {
        List<String> winnerList = new ArrayList<>();
        int top = 0;
        for (String carName : carMap.keySet()) {
            if (carMap.get(carName) > top) {
                top = carMap.get(carName);
            }
        }
        for (String carName : carMap.keySet()) {
            if (carMap.get(carName) == top) {
                winnerList.add(carName);
            }
        }
        return winnerList;
    }
}
