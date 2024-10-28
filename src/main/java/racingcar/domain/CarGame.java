package racingcar.domain;
import camp.nextstep.edu.missionutils.Randoms;
import racingcar.view.OutputView;

import java.util.List;
import java.util.stream.Collectors;

public class CarGame {
    private final List<Car> car;
    private final int attempts;

    public CarGame(List<String> carNames, int attempts) {
        this.car = carNames.stream()
                .map(Car::new)
                .collect(Collectors.toList());
        this.attempts = attempts;
    }

    public void playRounds() {
        for (int i = 0; i < attempts; i++) {
            playOneRound();
            OutputView.printRoundResult(car);
        }
    }

    private void playOneRound() {
        for (Car c : car) {
            int randomNumber = Randoms.pickNumberInRange(0, 9);
            c.move(randomNumber);
        }
    }

    public List<String> getWinners() {
        int maxPosition = car.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);

        return car.stream()
                .filter(c -> c.getPosition() == maxPosition)
                .map(Car::getName)
                .collect(Collectors.toList());
    }
}
