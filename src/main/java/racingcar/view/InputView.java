package racingcar.view;

public class InputView {
    private static final String INPUT_RACINGCARS_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String INPUT_RACING_COUNT_MESSAGE = "시도할 횟수는 몇 회인가요?";

    public static void printInputRacingcarsMessage(){
        System.out.println(INPUT_RACINGCARS_MESSAGE);
    }

    public static void printInputRacingCountMessage(){
        System.out.println(INPUT_RACING_COUNT_MESSAGE);
    }
}
