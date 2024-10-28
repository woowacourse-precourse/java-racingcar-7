package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.dto.InputDto;

import java.util.Arrays;
import java.util.List;

public class ConsoleInputView extends InputView {

    private static final String VALID_CAR_NAMES_REGEX = "[a-zA-Z0-9,]+(,[a-zA-Z0-9]+)";

    @Override
    protected InputDto.RequestInputDto customInput() {

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carsFromInputString = Console.readLine();

        System.out.println("시도할 횟수는 몇 회인가요?");
        int cntFromInputString = Integer.parseInt(Console.readLine());
        System.out.println();

        carInputValidate(carsFromInputString);
        List<String> cars = Arrays.asList(carsFromInputString.split(","));

        Console.close();
        return new InputDto.RequestInputDto(cars, cntFromInputString);
    }

    @Override
    protected void carInputValidate(final String carsFromInputString) {

        if (carsFromInputString.isBlank()) {
            throw new IllegalArgumentException("아무것도 입력되지 않았습니다.");
        } else if (carsFromInputString.contains(",,")) {
            throw new IllegalArgumentException("입력값에 쉼표(,)가 연속적으로 나왔습니다.");
        } else if (!carsFromInputString.matches(VALID_CAR_NAMES_REGEX)) {
            throw new IllegalArgumentException("잘못된 형식의 입력입니다.");
        } else {
            String[] carNames = carsFromInputString.split(",");
            for (String carName : carNames) {
                if (carName.length() > 5) {
                    throw new IllegalArgumentException("자동차 이름은 5자 이하로 입력해야합니다.");
                }
            }
        }
    }
}
