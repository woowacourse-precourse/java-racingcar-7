package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Racingcar {
    private List<Car> carList = new ArrayList<>();

    public void splitInputValue(String input_value) {
        String[] carNames = input_value.split(",");
        for (String carName : carNames) {
            ErrorValidator.carName(carName);
            createCars(carName);
        }
    }

    public void createCars(String carName) {
        Car car = new Car(carName);
        carList.add(car);
    }

    public void start() {
        System.out.println(Contants.NOTICE_CAR_NAMES);
        String input_value = Console.readLine();
        splitInputValue(input_value);
    }
}
