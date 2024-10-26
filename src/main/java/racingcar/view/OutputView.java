package racingcar.view;

public class OutputView {

    private static final String ASK_INPUT_TRY_COUNT = "시도할 횟수는 몇 회인가요?";
    private static final String ROUND_RESULT = "실행 결과";
    private static final String GAME_RESULT = "최종 우승자 : ";

    public void printAskInput(InputType type) {
        if (type == InputType.CAR_NAME) {
            String ASK_INPUT_CAR_NAME = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
            printMessage(ASK_INPUT_CAR_NAME);
        } else if (type == InputType.TRY_COUNT) {
            printMessage(ASK_INPUT_TRY_COUNT);
        }
    }

    public void responseRoundResult(StringBuilder sb) {
        System.out.println(ROUND_RESULT + "\n" + sb.toString());
    }

    public void responseGameResult(String winner) {
        System.out.println(GAME_RESULT + winner);
    }

    private void printMessage(String message) {
        System.out.println(message);
    }

    public enum InputType {
        CAR_NAME, TRY_COUNT
    }
}