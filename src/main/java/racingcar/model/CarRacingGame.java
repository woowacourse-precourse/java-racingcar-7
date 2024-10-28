package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CarRacingGame {
    private List<Car> cars = new ArrayList<>();

    // 자동차 이름을 파싱하여 반환
    public static List<String> parseCarNames(String input) {
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

    // 한 라운드를 실행하여 모든 자동차의 이동을 업데이트
    public void advanceRound() {
        for (Car car : cars) {
            car.move(isMovable());
        }
    }

    // 현재 라운드 결과 반환
    public List<String> getCurrentRoundResults() {
        return cars.stream()
                .map(Car::getStatus)
                .collect(Collectors.toList());
    }

    // 최종 우승자 목록 반환
    public List<String> getWinners() {
        int maxPosition = cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);  // 경주가 진행되지 않은 경우 대비

        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    // 자동차가 전진할 조건을 판단
    private boolean isMovable() {
        int randomNumber = Randoms.pickNumberInRange(0, 9);
        return randomNumber >= 4;
    }

}
