package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.util.InputValidator;
import racingcar.util.GameConstants;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {
    public Cars readCars() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();

        InputValidator.validateCarNames(input);
        List<Car> cars = parseCarNames(input);
        InputValidator.validateCars(cars);

        return new Cars(cars);
    }

    public int readAttempts() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        return InputValidator.validateAttempts(Console.readLine());
    }

    private List<Car> parseCarNames(String input) {
        return Arrays.stream(input.split(GameConstants.DELIMITER))
                .map(String::trim)
                .map(this::createCar)
                .collect(Collectors.toList());
    }

    private Car createCar(String name) {
        InputValidator.validateName(name);
        return new Car(name);
    }
}