package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Race {
    private final List<Car> cars = new ArrayList<>();
    private int rounds = 0;

    public void setCars(String input) {
        String[] carName = splitInput(input);

        for (String name : carName) {
            if (name.trim().length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하로 작성해주세요.");
            }
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
        List<Car> sortedCars = new ArrayList<>(cars);
        sortedCars.sort((o1, o2) -> {
            return Integer.compare(o2.getPosition(), o1.getPosition());
        });

        return sortedCars.getFirst().getPosition();
    }
}
