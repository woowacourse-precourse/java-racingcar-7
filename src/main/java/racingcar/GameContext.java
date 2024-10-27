package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class GameContext {
    private final List<Car> cars;
    private final int numTries;
    private final Supplier<Integer> moveDecisionSupplier;

    public GameContext(List<Car> cars, int numTries) {
        this.cars = cars;
        this.numTries = numTries;
        this.moveDecisionSupplier = () -> Randoms.pickNumberInRange(0, 9);
    }

    public GameContext(List<Car> cars, int numTries, Supplier<Integer> moveDecisionSupplier) {
        this.cars = cars;
        this.numTries = numTries;
        this.moveDecisionSupplier = moveDecisionSupplier;
    }

    public void playGame() {
        System.out.println("실행 결과");
        for (int i = 0; i < numTries; i++) {
            playRound();
        }
        displayWinners();
    }

    private void playRound() {
        for (Car car : cars) {
            attemptMove(car);
            System.out.println(car.getName() + " : " + "-".repeat(car.getPosition()));
        }
        System.out.println();
    }

    private void attemptMove(Car car) {
        if (shouldMove()) {
            car.move();
        }
    }

    private boolean shouldMove() {
        return moveDecisionSupplier.get() >= 4;
    }

    private void displayWinners() {
        List<Car> winners = getWinners();
        String winnerNames = winners.stream()
                .map(Car::getName)
                .collect(Collectors.joining(", "));
        System.out.println("최종 우승자 : " + winnerNames);
    }

    private List<Car> getWinners() {
        int maxPosition = cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);

        List<Car> winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.getPosition() == maxPosition) {
                winners.add(car);
            }
        }
        return winners;
    }
}
