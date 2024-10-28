package racingcar.service;

import static racingcar.handler.OutputHandler.executeResultOutput;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import racingcar.exception.CarNameValidator;

public class RacingGameService {

    private final List<Integer> carMovesCount = new ArrayList<>();
    private final List<Integer> maxIndexes = new ArrayList<>();
    private final List<String> winners = new ArrayList<>();
    private String result = "";

    public String startRace(List<String> carNames, int tryCount) {

        // 각 자동차 이름에 대한 예외사항 검증 메서드
        for (String carName : carNames) {
            validateCarName(carName, carNames);
        }

        //차의 이동거리 초기화
        initSetCarMovesCount(carNames);

        executeResultOutput();

        // 시도 횟수만큼 반복
        for (int i = 0; i < tryCount; i++) {
            carMovesCount(carNames);
        }

        return gameResult(carNames);

    }

    private void initSetCarMovesCount(List<String> carNames) {
        for (int i = 0; i < carNames.size(); i++) {
            carMovesCount.add(0);  // 이동 횟수를 0으로 초기화
        }
    }

    private void carMovesCount(List<String> carNames) {
        for (int j = 0; j < carNames.size(); j++) {
            if (Randoms.pickNumberInRange(0, 9) >= 4) {
                carMovesCount.set(j, carMovesCount.get(j) + 1);  // 이동 횟수 증가
            }
            System.out.println(carNames.get(j) + " : " + "-".repeat(carMovesCount.get(j)));
        }
        System.out.println();
    }

    private String gameResult(List<String> carNames) {
        int maxValue = Collections.max(carMovesCount);

        for (int i = 0; i < carMovesCount.size(); i++) {
            if (carMovesCount.get(i) == maxValue) {
                maxIndexes.add(i);
            }
        }

        for (int index : maxIndexes) {
            winners.add(carNames.get(index));
        }

        if (winners.size() == 1) {
            result = winners.get(0);
        } else {
            result = String.join(", ", winners);
        }

        return result;

    }


    // carName 검증 메서드
    private void validateCarName(String carName, List<String> carNames) {
        if (carName.length() > 5) {
            CarNameValidator.nameTooLong();
        }

        if (carName.trim().isEmpty()) {
            CarNameValidator.blankName();
        }

        if (!carName.matches("[a-zA-Z]+")) {
            CarNameValidator.invalidCharacters();
        }

        if (Collections.frequency(carNames, carName) > 1) {
            CarNameValidator.duplicateName();
        }
    }
}
