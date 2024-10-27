package racingcar.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import racingcar.model.Car;
import racingcar.view.InputView;

public class RacingController {

    final InputView inputView = new InputView();
    List<Car> cars = new ArrayList<>();

    public RacingController() {
    }

    public void run() {
        setCars(inputView.getCarNamesInput());
    }

    public void setCars(String input) {
        List<String> carNames = getDuplicationCheckedCarNamesFrom(input);
        for (String carName : carNames) {
            this.cars.add(new Car(getValidated(carName)));
        }
    }

    public List<String> getDuplicationCheckedCarNamesFrom(String input) {
        List<String> names = Arrays.stream(input.split(",")).map(String::trim).toList();

        if (names.size() != names.stream().distinct().count()) {
            throw new IllegalArgumentException("중복된 자동차 이름을 입력할 수 없습니다. ");
        }

        return names;
    }

    public String getValidated(String name) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException("자동차 이름은 공백이 될 수 없습니다. ");
        }
        if (name.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다. ");
        }
        return name;
    }
}
