package racingcar.controller;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import racingcar.model.Car;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameController {
    private final InputView inputView;
    private final OutputView outputView;

    public GameController(final InputView inputView, final OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        String carRegistrationRequest = inputView.readCarRegistrationRequest();
        List<String> carNames = Arrays.asList(carRegistrationRequest.split(","));
        List<Car> cars = carNames.stream().map(Car::new).toList();
        int roundCount = inputView.readRoundCount();

        System.out.println("\n실행 결과");
        for(int round = 0; round < roundCount; round++) {
            playRound(cars);
            System.out.println();
        }

        List<Car> winners = determineWinners(cars);
        outputView.printRacingResult(winners);
    }

    private void playRound(List<Car> cars) {
        for(Car car:cars) {
            int randomNumber = Randoms.pickNumberInRange(0, 9);
            if (randomNumber >= 4) {
                car.goForward();
            }
            outputView.printCarPosition(car);
        }
    }

    private List<Car> determineWinners(List<Car> cars) {
        int farthestPosition = cars.stream().mapToInt(Car::getPosition).max().orElse(0);
        return cars.stream().filter(car -> car.getPosition() == farthestPosition).toList();
    }
}
