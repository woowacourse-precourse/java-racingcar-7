package racingcar.race.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.regex.Pattern;
import racingcar.global.constants.RaceConstants;
import racingcar.race.dto.RaceRequest;

public class RaceService {
    public int enterRaceNumber() {
        RaceRequest raceRequest = new RaceRequest();
        String round = raceRequest.enterRaceNumbetInteger();
        roundIntegerValidation(round);
        return Integer.parseInt(round);
    }

    private void roundIntegerValidation(String roundNumber) {
        if (!Pattern.matches(RaceConstants.RACE_ROUND_INT_VALIDATION, roundNumber)) {
            throw new IllegalArgumentException(RaceConstants.RACE_ROUND_ERROR_MESSAGE);
        }
    }

    public void currentRoundProgress(Map<String, String> cars) {
        for (String car : cars.keySet()) {
            int number = Randoms.pickNumberInRange(0, 9);
            if (number >= 4) {
                cars.put(car, cars.get(car) + "-");
            }
            System.out.println(car + " : " + cars.get(car));
        }
        System.out.println();
    }

    public List<String> finalRoundWinnerCheck(Map<String, String> cars) {
        // 가장 큰 값을 찾기 위한 변수 초기화
        int maxValue = 0;
        List<String> maxKeys = new ArrayList<>();

        // 반복문을 통해 가장 큰 값과 해당 키들 찾기
        for (String car : cars.keySet()) {
            int value = cars.get(car).length();
            if (value > maxValue) {
                maxValue = value;
                maxKeys.clear(); // 새로운 최대값이 발견되면 리스트 초기화
                maxKeys.add(car);
            } else if (value == maxValue) {
                maxKeys.add(car);
            }
        }

        // 결과 출력
        System.out.println("가장 큰 값: " + maxValue);
        System.out.println("가장 큰 값을 가지는 키들:");
        for (String key : maxKeys) {
            System.out.println("- " + key);
        }
        return maxKeys;
    }
}
