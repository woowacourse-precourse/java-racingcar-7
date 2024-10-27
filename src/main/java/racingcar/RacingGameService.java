package racingcar;


import camp.nextstep.edu.missionutils.Console;

import java.util.List;
import java.util.stream.Collectors;

public class RacingGameService {
    private static final String CAR_NAMES_PROMPT = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String ATTEMPT_COUNT_PROMPT = "시도할 횟수는 몇 회인가요?";

    public List<Car> createCars() {
        System.out.println(CAR_NAMES_PROMPT);
        String input = Console.readLine();
        List<String> carNames = RacingGameInputValidator.parseCarNames(input);

        return carNames.stream()
                .map(Car::new)
                .collect(Collectors.toList());
    }

    public int getAttemptCount() {
        System.out.println(ATTEMPT_COUNT_PROMPT);
        String input = Console.readLine();
        return AttemptValidator.validateAttempt(input);
    }
}
