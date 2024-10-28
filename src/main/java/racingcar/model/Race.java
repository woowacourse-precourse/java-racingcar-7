package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.view.OutputView;

import java.util.Collections;
import java.util.List;

public class Race {

    private final List<Car> carList;

    public Race(List<Car> carList) {
        this.carList = carList;
    }

    public void startRace(int tryCount) {
        System.out.println("실행 결과");
        for (int i = 0; i < tryCount; i++) {
            moveCar();
            OutputView.printResult(carList);
        }
    }

    public void moveCar() {
        for (Car car : carList) {
            car.move(Randoms.pickNumberInRange(0, 10));
        }
    }

    public List<Car> getWinners() {
        int max = findMaxPosition();
        return carList.stream()
                .filter(car -> car.getPosition() == max)
                .toList();
    }

    public int findMaxPosition() {
        List<Integer> positions = carList.stream()
                .map(Car::getPosition)
                .toList();
        return Collections.max(positions);
    }
}