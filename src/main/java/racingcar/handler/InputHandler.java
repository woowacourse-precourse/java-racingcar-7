package racingcar.handler;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.validator.CarNameValidator;

public class InputHandler {

    public List<String> getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(2개 이상 입력 필수, 이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();

        List<String> carNames = Arrays.stream(input.split(","))
                .map(String::trim)
                .collect(Collectors.toList());

        CarNameValidator carNameValidator = new CarNameValidator();
        carNameValidator.validate(carNames);

        return carNames;
    }

}
