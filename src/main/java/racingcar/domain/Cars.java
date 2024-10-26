package racingcar.domain;

import java.util.Arrays;
import java.util.List;
import racingcar.utils.RandNumGenerator;
import racingcar.view.OutputView;

public class Cars {
    private final List<Car> cars;

    public Cars(String carsNames) {
        String[] splitNames = carsNames.split(",");
        cars = Arrays.stream(splitNames)
                .map(name -> new Car(name.strip()))
                .toList();
    }

    public void roundProcess(RandNumGenerator randNumGenerator) {
        for (Car car : cars) {
            car.moveForward(randNumGenerator.isRandNumGreaterThanOrEqualToCriterion());
        }
    }

    public void roundStatus() {
        OutputView outputView = OutputView.getInstance();
        StringBuilder roundResult = new StringBuilder();
        for (Car car : cars) {
            roundResult.append(car.getCurrentStatus());
        }
        outputView.printRoundResult(roundResult.toString());
    }
}
