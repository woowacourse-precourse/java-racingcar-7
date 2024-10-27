package racingcar.domain;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.validator.GameValidator;


public class RacingGame {
    private List<Car> cars;

    public void start() {

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼포(,) 기준으로 구분)");
        String inputCars = Console.readLine();

        System.out.println("시도할 횟수는 몇 회인가요?");
        int inputRounds = Integer.parseInt(Console.readLine());

        GameValidator.validateName(inputCars);
        GameValidator.validateMoveCount(inputRounds);

        cars = splitCars(inputCars);
    }

    private List<Car> splitCars(String input) {
        String[] carNames = input.split(",");
        return Arrays.stream(carNames)
                .peek(GameValidator::validateCarName)
                .map(Car::new)
                .collect(Collectors.toList());
    }
}
