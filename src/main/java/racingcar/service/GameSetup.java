package racingcar.service;

import java.util.HashSet;
import java.util.Set;

public class GameSetup {

    public Set<String> splitCarName(String carNameList) {
        Set<String> carNames = new HashSet<>();
        String[] carNameArray = carNameList.split(",");

        for(String name: carNameArray){
            name = name.trim();

            if (!carNames.add(name)) {
                throw new IllegalArgumentException("자동차 이름은 중복될 수 없습니다.");
            }

            if (name.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하로 입력해 주세요.");
            }
        }

        return carNames;
    }

    public int parseAttemptCount(String input) {
        int attemptCount;

        try {
            attemptCount = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("게임 횟수는 양수를 입력해 주세요.");
        }
        if (attemptCount <= 0) {
            throw new IllegalArgumentException("게임 횟수는 양수를 입력해 주세요.");
        }

        return attemptCount;
    }
}
