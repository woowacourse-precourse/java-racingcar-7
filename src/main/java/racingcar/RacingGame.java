package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {

    private final List<Car> cars = new ArrayList<>();

    // 자동차 초기화
    public void initializeCars(String[] carNames) {
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
    }

    // 레이싱 게임 실행
    public void racingCar(int attempts) {
        OutputView.displayStartMessage();
        performRace(attempts);
        displayWinners();
    }

    // 레이스 시도 횟수만큼 반복
    private void performRace(int attempts) {
        for (int i = 0; i < attempts; i++) {
            attemptAllCarsMove();
            displayProgress();
        }
    }

    // 모든 자동차의 전진 시도
    private void attemptAllCarsMove() {
        cars.forEach(this::moveCarIfConditionMet);
    }

    // 조건에 따라 자동차 전진
    private void moveCarIfConditionMet(Car car) {
        if (isMoveConditionMet()) {
            car.move();
        }
    }

    // 전진 조건 확인
    private boolean isMoveConditionMet() {
        return Randoms.pickNumberInRange(0, 9) >= 4;
    }

    // 전진 결과 출력
    private void displayProgress() {
        cars.forEach(car -> OutputView.displayProgress(car.getName(), car.getPosition()));
        System.out.println();
    }

    // 우승자 결정 및 출력
    private void displayWinners() {
        List<String> winners = findWinners();
        OutputView.displayWinners(winners);
    }

    // 우승자 찾기
    private List<String> findWinners() {
        int maxPosition = findMaxPosition();
        return getCarsAtPosition(maxPosition);
    }

    // 최고 위치 찾기
    private int findMaxPosition() {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);
    }

    // 최고 위치에 있는 자동차 이름 반환
    private List<String> getCarsAtPosition(int position) {
        return cars.stream()
                .filter(car -> car.getPosition() == position)
                .map(Car::getName)
                .toList();
    }

    // 게임 시작 메서드
    public static void startGame(String[] carNames, int attempts) {
        RacingGame racingGame = new RacingGame();
        racingGame.initializeCars(carNames);
        racingGame.racingCar(attempts);
    }
}
