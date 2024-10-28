package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.car.validation.CarNameValidator;

//출력문 상수화하기!
//주석 필요없는 건 지우기!

// 사용자 입력을 담당하는 클래스
public class Input {

    private static final String CAR_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String ATTEMPT_COUNT_MESSAGE = "시도할 횟수는 몇 회인가요?";
    private static final String CAR_NAME_DELIMITER = ",";

    private final CarNameValidator carNameValidator;

    public Input(CarNameValidator carNameValidator) {
        this.carNameValidator = carNameValidator;
    }

    public List<String> getCarNames() {
        System.out.println(CAR_NAME_MESSAGE);
        String input = Console.readLine();

        // 입력받은 이름들을 리스트로 변환
        return Arrays.stream(input.split(CAR_NAME_DELIMITER))
                .map(String::trim)
                .collect(Collectors.toList());
    }

    public String getAttemptCount() {
        System.out.println(ATTEMPT_COUNT_MESSAGE);
        return Console.readLine();
    }
}
