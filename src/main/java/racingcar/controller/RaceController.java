package racingcar.controller;

import java.util.List;

import racingcar.domain.Car;
import racingcar.domain.Race;
import racingcar.util.ErrorMessage;

public class RaceController {
    // 문자열로 입력된 시도 횟수를 int로 변경
    // 변환 과정에서 시도 횟수가 정수가 아닐 경우 예외 처리
    private int convertTrial(String inputTrial) {
        try {
            return Integer.parseInt(inputTrial);
        } catch (Exception e) {
            throw new IllegalArgumentException(ErrorMessage.TRIAL_IS_NOT_NUMBER.getMessage());
        }
    }

    // 레이스 생성
    public Race getRace(List<Car> cars, String trial) {
        return new Race(cars, convertTrial(trial));
    }
}
