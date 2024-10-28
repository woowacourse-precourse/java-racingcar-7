package racingcar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RaceManager {
    private InputView inputView = new InputView();
    private OutputView outputView = new OutputView();
    private String inputString;

    private List<Car> cars = new ArrayList<>();
    private int tryingNumber = 0;
    private int currentTryingNumber = 0;

    public void startRace() {
        outputView.notifyEnterNames();
        inputString = inputView.getCarsName();
        makeCarsList(extractName(inputString));

        outputView.notifyEnterTryingNumber();
        tryingNumber = inputView.getTryingNumber();

        outputView.notifyPrintResult();
    }

    private List<String> extractName(String inputString) {
        return Arrays.stream(inputString.split(","))
                .map(String::trim)
                .collect(Collectors.toList());
    }

    private void makeCarsList(List<String> names) {
        for (String name : names) {
            Car car = new Car(name);
            cars.add(car);
        }
    }
}
