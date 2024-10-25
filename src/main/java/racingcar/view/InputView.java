package racingcar.view;

import java.util.Arrays;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {

    public static String INPUT_CARNAME_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    public static String INPUT_GAME_TOKENS_MESSAGE = "시도할 횟수는 몇 회인가요?";

    public List<String> inputCarnames() {
        System.out.println(INPUT_CARNAME_MESSAGE);
        String inputLines = readLine();
        return Arrays.asList(inputLines.split(","));
    }

    public int inputGameTokens() {
        System.out.println(INPUT_GAME_TOKENS_MESSAGE);
        return Integer.parseInt(readLine());
    }
}
