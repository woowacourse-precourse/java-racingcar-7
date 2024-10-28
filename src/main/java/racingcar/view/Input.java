package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.car.validation.CarNameValidator;
import racingcar.race.validation.AttemptCountValidator;

// 사용자로부터 입력을 받는 클래스
public class Input {

    private static final String CAR_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String ATTEMPT_COUNT_MESSAGE = "시도할 횟수는 몇 회인가요?";
    private static final String CAR_NAME_DELIMITER = ",";

    private final CarNameValidator carNameValidator;
    private final AttemptCountValidator attemptCountValidator;


    public Input(CarNameValidator carNameValidator, AttemptCountValidator attemptCountValidator) {
        this.carNameValidator = carNameValidator;
        this.attemptCountValidator = attemptCountValidator;
    }


    // 자동차 이름 입력 메서드
    public List<String> getCarNames() {
        System.out.println(CAR_NAME_MESSAGE);
        String input = Console.readLine();

        List<String> carNames = Arrays.stream(input.split(CAR_NAME_DELIMITER)).map(String::trim)
                .collect(Collectors.toList());

        carNameValidator.validateCarNames(carNames);

        return carNames;
    }


    // 시도 횟수 입력 메서드
    public String getAttemptCount() {
        System.out.println(ATTEMPT_COUNT_MESSAGE);
        String attempCount = Console.readLine();

        attemptCountValidator.validateAttemptCount(attempCount);

        return attempCount;
    }
}
