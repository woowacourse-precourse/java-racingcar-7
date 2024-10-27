package racingcar.io;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import racingcar.AppConfig;
import racingcar.domain.car.Car;
import racingcar.io.validation.Validator;

public class InputReader {

    private final AppConfig appConfig = AppConfig.getInstance();
    private final Validator carNameValidator = appConfig.carNameValidator();
    private final Validator countValidator = appConfig.countValidator();

    public List<Car> readCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분) : ");
        String rawInput = Console.readLine();

        return convertToCarList(rawInput);
    }

    private List<Car> convertToCarList(String carNames) {
        List<String> carNameList = List.of(carNames.split(","));
        carNameList.forEach(carNameValidator::validate);

        return carNameList.stream()
            .map(Car::new)
            .toList();
    }

    public int readCount() {
        System.out.println("시도할 횟수는 몇 회인가요? : ");
        String rawInput = Console.readLine();

        return convertToInt(rawInput);
    }

    private int convertToInt(String repetitions) {
        countValidator.validate(repetitions);
        return Integer.parseInt(repetitions);
    }
}
