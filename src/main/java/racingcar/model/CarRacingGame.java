package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CarRacingGame {
    private List<Car> cars = new ArrayList<>();

    // 자동차 이름을 파싱하여 반환
    public List<String> parseCarNames(String input) {
        return Arrays.stream(input.split(","))
                .map(String::trim)
                .collect(Collectors.toList());
    }

    // 자동차 목록 초기화
    public void initializeCars(List<String> carNames) {
        cars = carNames.stream()
                .map(Car::new)
                .collect(Collectors.toList());
    }

    // 자동차 경주 진행
    public List<String> startRace(int attemptCount) {
        List<String> raceResults = new ArrayList<>();
        for (int i = 0; i < attemptCount; i++) {
            StringBuilder roundResult = new StringBuilder();
            for (Car car : cars) {
                car.move(isMovable());
                roundResult.append(car.getStatus()).append("\n");
            }
            raceResults.add(roundResult.toString());
        }
        return raceResults;
    }

    // 자동차가 전진할 조건을 판단
    private boolean isMovable() {
        int randomNumber = Randoms.pickNumberInRange(0, 9);
        return randomNumber >= 4;
    }

}
