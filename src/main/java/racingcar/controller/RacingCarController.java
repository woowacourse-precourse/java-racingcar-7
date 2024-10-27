package racingcar.controller;

import racingcar.model.Car;
import racingcar.model.CarMover;
import racingcar.model.WinnerDeterminer;
import racingcar.view.CarNameInputValidator;
import racingcar.view.MoveCountInputValidator;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class RacingCarController {
    private final CarNameInputValidator carNameInputValidator;
    private final MoveCountInputValidator moveCountInputValidator;
    private final List<Car> cars;
    private final CarMover carMover;

    public RacingCarController(CarNameInputValidator carNameInputValidator,
                               MoveCountInputValidator moveCountInputValidator,
                               CarMover carMover) {
        this.carNameInputValidator = carNameInputValidator;
        this.moveCountInputValidator = moveCountInputValidator;
        this.cars = new ArrayList<>();
        this.carMover = carMover;
    }

    public void startRace() {
        List<String> carNames = carNameInputValidator.getCarNames();
        createCars(carNames);

        int moveCount = moveCountInputValidator.getMoveCount();

        System.out.println();

        for (int i = 0; i < moveCount; i++) {
            int[] moveCounts = generateRandomMoveCounts();
            moveCars(moveCounts);
            printResults();
        }

        printWinners();
    }

    public void createCars(List<String> carNames) {
        for (String name : carNames) {
            cars.add(new Car(name));
        }
    }

    public void moveCars(int[] moveCounts) {
        for (int i = 0; i < cars.size(); i++) {
            if (moveCounts[i] >= 4) {
                carMover.move(cars.get(i), moveCounts[i]);
            }
        }
    }

    public void printResults() {
        for (Car car : cars) {
            StringBuilder sb = new StringBuilder();
            sb.append(car.getName()).append(" : ");
            for (int i = 0; i < car.getPosition(); i++) {
                sb.append("-");
            }
            System.out.println(sb.toString());
        }
        System.out.println();
    }

    public void printWinners() {
        WinnerDeterminer winnerDeterminer = new WinnerDeterminer(cars);
        List<String> winners = winnerDeterminer.determineWinners();
        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }

    private int[] generateRandomMoveCounts() {
        int[] moveCounts = new int[cars.size()];
        for (int i = 0; i < cars.size(); i++) {
            moveCounts[i] = Randoms.pickNumberInRange(0, 9);
        }
        return moveCounts;
    }

    public List<Car> getCars() {
        return cars;
    }
}
