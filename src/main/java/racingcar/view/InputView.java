package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import racingcar.dto.InputDTO;

public class InputView {

    public InputDTO display() {
        List<String> racerNames = inputRacerNames();
        int moveCount = inputMoveCount();
        return new InputDTO(racerNames, moveCount);
    }

    public List<String> inputRacerNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();

        if (input.startsWith(",") || input.endsWith(",")) {
            throw new IllegalArgumentException();
        }
        return Arrays.stream(input.split(",")).map(String::strip).toList();
    }

    public int inputMoveCount() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        try {
            return Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(e.getMessage(), e);
        }
    }
}
