package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {
    private static final String CAR_NAME_QUESTION = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String TRY_COUNT_QUESTION = "시도할 횟수는 몇 회인가요?";
    private static final String DELIMITER_COMMA = ",";

    public List<String> inputCarsName() {
        System.out.println(CAR_NAME_QUESTION);
        String carsName = Console.readLine();
        return splitCarsName(carsName);
    }

    private List<String> splitCarsName(String inputNames) {
        return Arrays.stream(inputNames.split(DELIMITER_COMMA))
                .collect(Collectors.toList());
    }

    public String inputTryCount() {
        System.out.println(TRY_COUNT_QUESTION);
        return Console.readLine();
    }
}
