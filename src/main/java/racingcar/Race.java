package racingcar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Race {
    private Input inputView = new Input();
    private Output outputView = new Output();
    private String inputString;

    List<Car> cars = new ArrayList<>();
    private int tryingNumber = 0;
    private int currentTryingNumber = 0;

    private int comparisonNumber = 4;
    private int limitNameLength = 5;

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

    public void finishRace() {
        outputView.printWinner(findWinner());
    }

    private void makeCarsMove() {
        for (Car car : cars) {
            if (car.setAndReturnRandomNumber() >= comparisonNumber) {
                car.incCurrentPos();
            }
        }
    }

    List<String> extractName(String inputString) {
        return Arrays.stream(inputString.split(","))
                .map(String::trim)
                .peek(name -> { // 각 이름의 길이를 검사
                    if (name.length() > limitNameLength) {
                        throw new IllegalArgumentException("이름은 5자 이하여야 합니다: " + name);
                    }
                })
                .collect(Collectors.toList());
    }

    void makeCarsList(List<String> names) {
        for (String name : names) {
            Car car = new Car(name);
            cars.add(car);
        }
    }

    // 우승자 찾아내기
    public List<String> findWinner() {
        List<String> winnerCarsNames = new ArrayList<>();

        Collections.sort(cars);
        winnerCarsNames.add(cars.getFirst().getName());
        int winnerPos = cars.getFirst().getCurrentPos();

        for (int i = 1; i < cars.size(); i++) {
            if (cars.get(i).getCurrentPos() != winnerPos) {
                break;
            }
            winnerCarsNames.add(cars.get(i).getName());
        }
        return winnerCarsNames;
    }
}