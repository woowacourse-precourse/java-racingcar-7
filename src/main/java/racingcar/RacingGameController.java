package racingcar;

import java.util.ArrayList;
import java.util.List;

public class RacingGameController {
    private final InputView inputView = new InputView();
    private final ResultView resultView = new ResultView();

    public void run() {
        String carNamesInput = inputView.getCarNames();
        String tryCountInput = inputView.getTryCount();

        String[] carNames = parseCarNames(carNamesInput);
        int tryCount = parseTryCount(tryCountInput);

        List<Car> carList = createCars(carNames);

        resultView.printStartMessage();
        playRounds(tryCount,carList);
        declareWinner(carList);
    }

    private String[] parseCarNames(String input) {
        String[] cars = input.replaceAll(" ", "").split(",");
        validateCarNames(cars);
        return cars;
    }

    private void validateCarNames(String[] cars) {
        for (String car : cars) {
            if (car.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하여야 합니다.");
            }
        }
    }

    private int parseTryCount(String input) {
        try {
            return Integer.parseInt(input.replaceAll(" ", ""));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도 횟수는 숫자여야 합니다.");
        }
    }

    private List<Car> createCars(String[] carNames) {
        List<Car> carList = new ArrayList<>();
        for (String name : carNames) {
            carList.add(new Car(name));
        }
        return carList;
    }

    private void playRounds(int tryCount, List<Car> carList) {
        for (int i = 0; i < tryCount; i++) {
            playSingleRound(carList);
            System.out.println();
        }
    }

    private void playSingleRound(List<Car> carList) {
        for (Car car : carList) {
            car.move();
            resultView.printCarPosition(car);
        }
    }

    private void declareWinner(List<Car> carList) {
        int maxPosition = findMaxPosition(carList);
        List<String> winners = findWinners(carList, maxPosition);
        resultView.printWinners(winners);
    }

    private int findMaxPosition(List<Car> carList) {
        int max = 0;
        for (Car car : carList) {
            if (car.getPosition() > max) {
                max = car.getPosition();
            }
        }
        return max;
    }

    private List<String> findWinners(List<Car> carList, int maxPosition) {
        List<String> winners = new ArrayList<>();
        for (Car car : carList) {
            if (car.getPosition() == maxPosition) {
                winners.add(car.getName());
            }
        }
        return winners;
    }
}
