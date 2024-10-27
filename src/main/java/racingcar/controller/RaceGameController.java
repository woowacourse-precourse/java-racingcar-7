package racingcar.controller;

import racingcar.domain.Car;
import racingcar.domain.InputValidator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class RaceGameController {

    /**
     * 컨트롤러 시작
     */
    public void start() {
        // 사용자 입력 받기
        List<String> carNames = InputValidator.isValidCarName(InputView.getCarName());
        int attemptNumber = InputValidator.isValidAttemptNumber(InputView.getAttemptNumber());

        // Car 객체 리스트로 변환
        List<Car> cars = convertCars(carNames);

        OutputView.printDescription();

        // 시도 횟수만큼 게임 실행
        for (int i = 0; i < attemptNumber; i++) {
            startOneGame(cars);
            printGameResult(cars);
        }

        // 최종 우승자 선정 및 출력
        int maxMoveCount = getMaxMoveCount(cars);
        List<String> winners = getWinner(cars, maxMoveCount);
        OutputView.printWinner(winners);
    }

    /**
     * 자동차 이름들을 Car 객체 리스트로 변환
     */
    public List<Car> convertCars(List<String> carNames) {
        List<Car> cars = new ArrayList<>();

        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
        return cars;
    }

    /**
     * 자동차별로 게임을 1회 실행
     */
    public void startOneGame(List<Car> cars) {
        for (Car car : cars) {
            car.startOneGame();
        }
    }

    /**
     * 게임 1회를 실행한 결과 출력
     */
    public void printGameResult(List<Car> cars) {
        OutputView.printGameResult(cars);
    }

    /**
     * 가장 큰 전진 횟수 반환
     */
    public int getMaxMoveCount(List<Car> cars) {
        int max = Integer.MIN_VALUE;

        for (Car car : cars) {
            if (car.getMoveCount() > max) {
                max = car.getMoveCount();
            }
        }
        return max;
    }

    /**
     * 최종 우승자를 선정
     */
    public List<String> getWinner(List<Car> cars, int maxMoveCount) {
        List<String> winners = new ArrayList<>();

        for (Car car : cars) {
            if (car.getMoveCount() == maxMoveCount) {
                winners.add(car.getCarName());
            }
        }
        return winners;
    }
}
