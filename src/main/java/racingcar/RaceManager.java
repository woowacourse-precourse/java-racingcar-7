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

    private int comparisonNumber = 4;

    public void startRace() {
        outputView.notifyEnterNames();
        inputString = inputView.getCarsName();
        makeCarsList(extractName(inputString));

        outputView.notifyEnterTryingNumber();
        tryingNumber = inputView.getTryingNumber();

        outputView.notifyPrintResult();
    }

    public void runRace() {
        while (currentTryingNumber < tryingNumber) {
            makeCarsMove();
            outputView.printResult(cars);
            System.out.print("\n");
            currentTryingNumber++;
        }
    }

    private void makeCarsMove() {
        for (Car car : cars) {
            if (car.setAndReturnRandomNumber() >= comparisonNumber) {
                car.incCurrentPos();
            }
        }
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
