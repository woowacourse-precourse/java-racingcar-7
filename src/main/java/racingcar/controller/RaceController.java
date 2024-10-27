package racingcar.controller;

import java.util.List;

import racingcar.domain.Car;
import racingcar.domain.Race;

public class RaceController {
    // 문자열로 입력된 시도 횟수를 int로 변경
    private int convertTrial(String inputTrial) {
        return Integer.parseInt(inputTrial);
    }

    // 레이스 생성
    public Race getRace(List<Car> cars, String trial) {
        return new Race(cars, convertTrial(trial));
    }
}
