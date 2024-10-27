package racingcar.view;

import java.util.List;
import java.util.stream.Collectors;

public class Output {

    private static final String NAME_INPUT_PROMPT = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String COUNT_INPUT_PROMPT = "시도할 횟수는 몇 회인가요?";
    private static final String RESULT_PROMPT = "\n실행 결과";
    private static final String WINNER_PROMPT = "최종 우승자 : ";
    private static final String WINNER_DELIMITER = ", ";

    public void printNameInputPrompt() {
        System.out.println(NAME_INPUT_PROMPT);
    }

    public void printCountInputPrompt() {
        System.out.println(COUNT_INPUT_PROMPT);
    }

    public void printResultPrompt() {
        System.out.println(RESULT_PROMPT);
    }

    public void printWinnerPrompt(List<String> winners) {
        System.out.println(WINNER_PROMPT
                + winners.stream().collect(Collectors.joining(WINNER_DELIMITER)));
    }
}
