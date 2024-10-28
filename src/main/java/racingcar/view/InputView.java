package racingcar.view;

import racingcar.domain.Car;
import racingcar.util.InputValidator;
import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class InputView {
    public List<Car> inputCars() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        return Arrays.stream(input.split(","))
                .map(String::trim)
                .peek(InputValidator::validateName)  // 이름 유효성 검사 추가
                .map(Car::new)
                .toList();
    }

    public int inputAttempts() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        String input = Console.readLine();
        InputValidator.validateAttempts(input);  // 시도 횟수 유효성 검사 추가
        return Integer.parseInt(input);
    }
}