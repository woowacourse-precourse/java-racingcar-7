package racingcar.view;

import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.util.InputUtil;

import java.util.List;

public class InputView {

    public Cars getCarNamesFromUser() {
        List<String> inputCarNames = InputUtil.readStringList();
        List<Car> carList = getCarListFrom(inputCarNames);

        return Cars.of(carList);
    }

    private List<Car> getCarListFrom(List<String> inputCarNames) {
        return inputCarNames.stream()
                .map(Car::of)
                .toList();
    }

    public int getTryNumberFromUser() {
        return InputUtil.readInt();
    }

}
