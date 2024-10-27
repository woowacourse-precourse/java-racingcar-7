package racingcar.controller;

import racingcar.domain.Car;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RacingController {

    private final InputView inputView;
    private final OutputView outputView;

    public RacingController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void run() {
        List<Car> carList = makeCarList(inputView.names());
        int repeat = stringToInt(inputView.repeat());
        raceStart(carList, repeat);
        outputView.winners(carList);
    }

    List<Car> makeCarList(String names) {
        ArrayList<String> nameList = new ArrayList<>(Arrays.asList(names.split(",")));
        ArrayList<Car> carList = new ArrayList<>();

        for (String name : nameList) {
            checkNameCondition(name);
            carList.add(new Car(name));
        }

        return carList;
    }

    public void raceStart(List<Car> carList, int repeat) {
        outputView.resultText();
        while (repeat-- != 0) {
            raceOneCircle(carList);
            outputView.resultPerOneCircle(carList);
        }
    }

    void raceOneCircle(List<Car> carList) {
        for (Car car : carList) {
            car.race();
        }
    }

    int stringToInt(String string) {
        checkNumberCondition(string);
        return Integer.parseInt(string);
    }

    void checkNameCondition(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("이름은 5자 이하만 가능합니다.");
        }
    }

    void checkNumberCondition(String number) {
        String regex = "^(0|[1-9]\\d*)$";
        if (!number.matches(regex)) {
            throw new IllegalArgumentException("0또는 양수를 입력해주세요.");
        }
    }

}
