package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.handler.OutputHandler;

import java.util.ArrayList;
import java.util.List;

import static racingcar.handler.OutputHandler.gameResult;

public class RacingGameService {

    private final List<Integer> carMovesCount = new ArrayList<>();

    public void startRace(List<String> carNames, int tryCount) {

        // 각 자동차 이름에 대한 예외사항 검증 메서드
        for(String carName : carNames){
            validateCarName(carName);
        }

        //차의 이동거리 초기화
        initSetCarMovesCount(carNames);

        gameResult();

        // 시도 횟수만큼 반복
        for (int i = 0; i < tryCount; i++) {
            carMovesCount(carNames);
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

    private void initSetCarMovesCount(List<String> carNames) {
        for (int i = 0; i < carNames.size(); i++) {
            carMovesCount.add(0);  // 이동 횟수를 0으로 초기화
        }
    }




    // carName 검증 메서드
    private void validateCarName(String carName) {
        if (carName.length() > 5) {
            throw new IllegalArgumentException("이름은 5자 이하만 가능합니다.");
        }

        if (carName.trim().isEmpty()) {
            throw new IllegalArgumentException("이름은 공백이 될 수 없습니다.");
        }

        if (!carName.matches("[a-zA-Z]+")) {
            throw new IllegalArgumentException("이름은 영어 문자만 가능합니다.");
        }
    }
}
