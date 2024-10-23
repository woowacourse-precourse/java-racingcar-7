package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class RacingGameService {


    public void startRace(List<String> carNames, int tryCount) {

        // 각 자동차 이름에 대한 예외사항 검증 메서드
        for(String carName : carNames){
            System.out.println(carName);
            validateCarName(carName);
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
