package racingcar.handler;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.Car;
import racingcar.factory.CarFactory;

import java.util.List;

public class InputHandlerImpl implements InputHandler {
    public List<Car> carList() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNames = Console.readLine();
        return CarFactory.create(carNames);
    }

    public int tryCount() {
        String input = requestInput();
        return parseInteger(input);
    }

    private String requestInput() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        return Console.readLine();
    }

    private int parseInteger(String input) {
        validateInput(input);
        return Integer.parseInt(input);
    }

    private void validateInput(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException("입력값은 null 또는 빈 문자열일 수 없습니다.");
        }
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("유효한 정수가 아닙니다.");
        }
    }
}