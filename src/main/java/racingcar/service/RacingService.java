package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.model.Car;
import racingcar.view.OutputView;

import java.util.List;

public class RacingService {
    private final CarService carService;

    public RacingService(CarService carService){
        this.carService = carService;
    }

    public void raceStart(int attemptCount) {
        validateAttemptCount(attemptCount);

        OutputView.printBeginRace();

        for (int i = 0; i < attemptCount; i++) {
            tryAdvanceAndShow();
            OutputView.printNewLine();
        }
    }

    private void tryAdvanceAndShow() {
        List<Car> carList = carService.getCarList();

        for (Car car : carList) {
            advanceByRandom(car);
            showRaceStatus(car);
        }
    }

    private void showRaceStatus(Car car) {
        OutputView.printRaceStatus(car.getName(), car.getAdvanceCount());
    }

    private void validateAttemptCount(int attemptCount) {
        if (attemptCount > 20) {
            throw new IllegalArgumentException("이동 횟수가 20을 넘습니다.");
        }
    }

    private void advanceByRandom(Car car) {
        if (Randoms.pickNumberInRange(0, 9) >= 4) {
            car.advance();
        }
    }
}
