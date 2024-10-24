package racingcar.controller;

import racingcar.domain.Car;
import racingcar.view.CarRaceView;

import java.util.ArrayList;
import java.util.List;

public class CarRaceController {
    private final CarRaceView view;
    private final List<Car> cars = new ArrayList<>();

    public CarRaceController(CarRaceView view) {
        this.view = view;
    }

    public void startRace() {
        String carNamesInput = view.getCarNames(); // 사용자 입력을 받음
        String[] carNames = carNamesInput.split(","); // 쉼표로 분리

        for (String name : carNames) {
            String trimmedName = name.trim(); // 공백 제거

            // 공백이 포함된 자동차 이름이 있는 경우
            if (trimmedName.isEmpty()) {
                throw new IllegalArgumentException("공백 없이 입력해주세요."); // 예외 발생
            }

            // 자동차 이름의 유효성 검사
            if (trimmedName.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다."); // 예외 발생
            }

            cars.add(new Car(trimmedName)); // 유효한 이름으로 자동차 초기화
        }

        int tryCount = view.getTryCount(); // 시도할 횟수 입력받기
        conductRace(tryCount); // 경주 진행
        announceWinners(); // 우승자 발표
    }

    private void conductRace(int tryCount) {
        for (int i = 0; i < tryCount; i++) {
            for (Car car : cars) {
                car.move(); // 자동차 이동
            }
            view.printRaceResult(cars); // 각 차수 결과 출력
        }
    }

    private void announceWinners() {
        List<String> winners = findWinners(); // 우승자 찾기
        view.printWinners(winners); // 우승자 출력
    }

    private List<String> findWinners() {
        int maxPosition = cars.stream().mapToInt(Car::getPosition).max().orElse(0); // 최대 위치 찾기
        List<String> winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.getPosition() == maxPosition) {
                winners.add(car.getName()); // 우승자 추가
            }
        }
        return winners; // 우승자 목록 반환
    }
}
