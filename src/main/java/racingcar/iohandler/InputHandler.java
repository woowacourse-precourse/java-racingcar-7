package racingcar.iohandler;

import camp.nextstep.edu.missionutils.Console;
import racingcar.Car;

import java.util.ArrayList;
import java.util.List;

import static racingcar.Car.createCar;

public class InputHandler {

    public List<Car> getCarNamesFromUser() {
        String input = Console.readLine();
        String[] names = input.split(",");
        List<Car> cars = new ArrayList<>();
        for (String name : names) {
            Car car = createCar(name);
            cars.add(car);
        }
        return cars;
    }

    public int getMoveCountFromUser() {
        String input = Console.readLine();
        boolean isNumeric = input.chars().allMatch(Character::isDigit);
        if (!isNumeric) {
            throw new IllegalArgumentException("숫자만 입력 해 주세요.");
        }
        return Integer.parseInt(input);
    }
}
