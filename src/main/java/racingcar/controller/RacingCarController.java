package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import racingcar.model.Car;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarController {

    static HashSet<Car> cars = new HashSet<>();
    static List<String> winnerNames = new ArrayList<>();

    private final OutputView outputView;
    private final InputView inputView;

    public RacingCarController() {
        this.outputView = new OutputView();
        this.inputView = new InputView();
    }

    public void startRacing() {
        outputView.printInputCarNameGuideMessage();
        final String carNames = Console.readLine();

        outputView.printInputRacingTryCount();
        final int tryCountNumber = inputView.readRacingTryCount();

        for (final String carName : carNames.split(",")) {
            if (carName.length() >= 5){
                throw new IllegalArgumentException("잘못된 입력입니다.");
            }

            Car car = new Car(carName, 0);
            if (cars.contains(car)) {
                throw new IllegalArgumentException("중복된 자동차 이름을 입력했습니다.");
            }

            cars.add(car);
        }

        runTotalRoundRacing(tryCountNumber);
        findRacingWinner();
    }

    private void runTotalRoundRacing(final int tryCountNumber) {
        for (int i = 0; i < tryCountNumber; i++) {
            runOneRoundRacing();
        }
        System.out.println("");
    }

    private void runOneRoundRacing() {
        for (Car car : cars) {
            final int randomInt = Randoms.pickNumberInRange(0, 9);
            final String moveDistance = "-".repeat(randomInt);
            if (randomInt >= 4) {
                car.addDistance(randomInt);
            }
            outputView.printCarNameAndMoveDistance(car.getCarName(), moveDistance);
        }
    }

    private void findRacingWinner() {
        int winnerDistance = 0;

        for (Car car : cars) {
            if (car.getDistance() > winnerDistance) {
                winnerDistance = car.getDistance();
                winnerNames.clear();
                winnerNames.add(car.getCarName());
            } else if (car.getDistance() == winnerDistance) {
                winnerNames.add(car.getCarName());
            }
        }

        String delimitedWinners = String.join(", ", winnerNames);
        outputView.printFinalWinners(delimitedWinners);
    }
}
