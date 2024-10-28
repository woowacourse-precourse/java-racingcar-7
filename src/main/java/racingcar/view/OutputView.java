package racingcar.view;

public class OutputView {

    private static final String INPUT_CAR_NAMES_PROMPT_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String INPUT_ATTEMPTS_PROMPT_MESSAGE = "시도할 횟수는 몇 회인가요?";
    private static final String PROMPT_RUN_RESULT_TITLE = "실행 결과";

    public void displayInputCarNamesPrompt() {
        showPrompt(INPUT_CAR_NAMES_PROMPT_MESSAGE);
    }

    public void displayAttemptsPrompt() {
        showPrompt(INPUT_ATTEMPTS_PROMPT_MESSAGE);
    }

    private void showPrompt(String message) {
        System.out.println(message);
    }


    public void displayRoundResultHeader() {
        System.out.println();
        System.out.println(PROMPT_RUN_RESULT_TITLE);
    }

}
