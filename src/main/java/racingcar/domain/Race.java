package racingcar.domain;

import static racingcar.validation.InputValidator.*;

import java.util.ArrayList;
import java.util.List;

public class Race {
    private final List<Car> cars = new ArrayList<>();
    private int rounds;

    public void setCars(String input) {
        String[] carName = splitInput(input);

        for (String name : carName) {
            validateCarNames(name);

            cars.add(new Car(name.trim()));
        }
    }

    public void setRounds(int rounds) {
        this.rounds = rounds;
    }

    public int getRounds() {
        return rounds;
    }

    private String[] splitInput(String input) {
        return input.split(",");
    }

    // 모든 자동차를 이동하는 메서드
    public void moveCars() {
        for (Car car : cars) {
            car.move();
        }
    }

    // 실행 횟수 별 경주의 결과를 반환하는 메서드
    public String getRaceResult() {
        StringBuilder roundResult = new StringBuilder();

        for (Car car : cars) {
            roundResult.append(car.getDisplayPosition()).append('\n');
        }

        return roundResult.toString();
    }

    public List<String> getRaceWinner() {
        List<String> winners = new ArrayList<>();

        int max = getMaxPosition();
        for (Car car : cars) {
            if (car.getPosition() == max) {
                winners.add(car.getName());
            }
        }

        return winners;
    }

    public int getMaxPosition() {
        return cars.stream().mapToInt(Car::getPosition).max().orElse(0);
    }
}
