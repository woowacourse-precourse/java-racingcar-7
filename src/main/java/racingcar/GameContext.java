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

        List<Car> winners = getWinners();
        System.out.printf("최종 우승자 : " + winners.stream()
                .map(Car::getName)
                .collect(Collectors.joining(", ")));
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
        int randNum = moveDecisionSupplier.get();
        return randNum >= 4;
    }

    private List<Car> getWinners() {
        List<Car> winners = new ArrayList<>();
        int maxPosition = cars.stream().mapToInt(Car::getPosition).max().orElse(0);

        for (Car car : cars) {
            if (car.getPosition() == maxPosition) {
                winners.add(car);
            }
        }
        return winners;
    }
}
