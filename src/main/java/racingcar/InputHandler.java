package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

public class InputHandler {
    InputExceptionHandler inputExeptionHandler;

    public InputHandler() {
        inputExeptionHandler = new InputExceptionHandler();
    }
    public List<Car> getCarName() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String inputCarName = Console.readLine();
        inputExeptionHandler.validCarName(inputCarName);
        return Arrays.stream(inputCarName.split(","))
                .map(String::trim)
                .map(Car::new)
                .toList();
    }

    public int getAttemptNumber() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        String inputNumber = Console.readLine();
        inputExeptionHandler.validAttemptNumber(inputNumber);
        return Integer.parseInt(inputNumber);
    }

}
