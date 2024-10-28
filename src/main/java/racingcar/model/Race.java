package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class Race {
    private final OutputView outputView;
    private final List<Car> cars;
    private final int tryCount;

    public Race(OutputView outputView, List<Car> cars, int tryCount) {
        this.outputView = outputView;
        this.cars = cars;
        this.tryCount = tryCount;
    }

    public void startRace() {
        for (int i = 0; i < tryCount; i++) {
            moveCars();
            outputView.printStepResult(cars);
        }
        List<String> firstPlaceCarsList = getfirstPlaceCarsNameList();
        outputView.printFinalFirstPlaceCars(firstPlaceCarsList);
    }

    private void moveCars() {
        for (Car car : cars) {
            car.move(Randoms.pickNumberInRange(0, 9));
        }
    }

    private List<String> getfirstPlaceCarsNameList() {
        List<String> firstPlaceCarsNameList = new ArrayList<>();
        int firstPlaceCarPosition = Integer.MIN_VALUE;

        for (Car car : cars) {
            if (car.getPosition() > firstPlaceCarPosition) {
                firstPlaceCarsNameList.clear();
                firstPlaceCarsNameList.add(car.getName());
                firstPlaceCarPosition = car.getPosition();
            } else if (car.getPosition() == firstPlaceCarPosition) {
                firstPlaceCarsNameList.add(car.getName());
            }
        }

        return firstPlaceCarsNameList;
    }
}
