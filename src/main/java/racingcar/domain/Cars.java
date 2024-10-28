package racingcar.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Cars {
    private final int MIN_VALUE_PROGRESS = 0;

    private List<Car> cars;

    public Cars(List<String> carNames) {
        validate(carNames);
        this.cars = new ArrayList<>(carNames.size());
        for (int i = 0; i < carNames.size(); i++) {
            this.cars.add(new Car(carNames.get(i)));
        }
    }

    public Cars(List<String> carNames, List<Integer> progresses) {
        validate(carNames);
        this.cars = new ArrayList<>(carNames.size());
        for (int i = 0; i < carNames.size(); i++) {
            this.cars.add(new Car(carNames.get(i), progresses.get(i)));
        }
    }

    private void validate(List<String> carNames) {
        HashSet<String> duplicateCheck = new HashSet<>();
        for (int i = 0; i < carNames.size(); i++) {
            duplicateCheck.add(carNames.get(i));
        }
        if (duplicateCheck.size() != carNames.size()) {
            throw new IllegalArgumentException("중복된 자동차 이름은 등록이 불가능합니다.");
        }
        if (carNames.size() < 2) {
            throw new IllegalArgumentException("2대 이상의 자동차가 경주에 필요합니다.");
        }
    }

    public void doRace() {
        for (int i = 0; i < cars.size(); i++) {
            Car racer = cars.get(i);
            racer.randomGo();
        }
    }

    public List<String> decideWinner() {
        int winnersProgress = this.findWinnersProgress();
        List<String> winners = new ArrayList<>();
        for (int i = 0; i < this.size(); i++) {
            if (this.getCar(i).progress() == winnersProgress) {
                winners.add(this.getCar(i).name());
            }
        }
        return winners;
    }

    private int findWinnersProgress() {
        int winnersProgress = MIN_VALUE_PROGRESS;
        for (int i = 0; i < this.size(); i++) {
            if (this.getCar(i).progress() > winnersProgress) {
                winnersProgress = this.getCar(i).progress();
            }
        }
        return winnersProgress;
    }

    public int size() {
        return cars.size();
    }

    public Car getCar(int index) {
        return cars.get(index);
    }
}
