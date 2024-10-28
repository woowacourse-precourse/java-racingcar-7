package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import racingcar.car.Car;
import racingcar.validation.CarNameValidator;

public class Application {
    public static void main(String[] args) {

        System.out.print("자동차 이름을 입력하세요 (이름은 쉼표로 구분): ");
        String input = Console.readLine();
        Console.close();

        List<String> carNames = new ArrayList<>(Arrays.asList(input.split(",")));
        List<Car> cars = new ArrayList<>();

        CarNameValidator validator = new CarNameValidator();
        validator.validateCarNames(carNames);

        for (String name : carNames) {
            Car car = new Car(name);
            cars.add(car);
        }

//        System.out.print("시도할 횟수를 입력하세요: ");
//        int attempts = Integer.parseInt(Console.readLine());


    }
}
