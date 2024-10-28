package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Game {

    private List<Car> cars;

    public Game() {
        OutputHandler.printInstructionForCarNames();
        List<String> carNames = InputHandler.getCarNames();

        OutputHandler.printInstructionForTimes();
        int times = InputHandler.getTimes();

        cars = new ArrayList<>();

        for(String carName : carNames) {
            cars.add(new Car(carName));
        }

        OutputHandler.printInformResult();

        for(int i = 0; i < times; i++) {
            executeGame();
            OutputHandler.printOneBlankLine();
        }

        List<Car> winnerCars = findWinnerCars();
        List<String> winnerCarNames = getWinnerCarNames(winnerCars);
        OutputHandler.printWinner(String.join(", ", winnerCarNames));

    }

    private static List<String> getWinnerCarNames(List<Car> winnerCars) {
        return winnerCars.stream()
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    private void executeGame() {
        for(int i = 0; i < cars.toArray().length; i++) {
            Car currentCar = cars.get(i);
            int randomNumber = Randoms.pickNumberInRange(0, 9);
            checkIfRandomNumberIsOver4(randomNumber, currentCar);
            OutputHandler.printExecuteResult(currentCar.toString());
        }
    }

    private static void checkIfRandomNumberIsOver4(int randomNumber, Car car) {
        if (randomNumber >= 4) {
            car.increaseCount();
        }
    }

    private List<Car> findWinnerCars() {
        List<Car> winnerCars = new ArrayList<>();
        int maxCount = Integer.MIN_VALUE;

        for (Car car : cars) {
            if (car.getCount() > maxCount) {
                maxCount = car.getCount();
                winnerCars.clear();
                winnerCars.add(car);
            } else if (car.getCount() == maxCount) {
                winnerCars.add(car);
            }
        }

        return winnerCars;
    }
}
