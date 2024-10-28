package racingcar.view;
import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private final static String INPUT_CAR_SENTENCE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private final static String INPUT_TRY_COUNT_SENTENCE = "시도할 횟수는 몇 회인가요?";
    public String getInput() {
        System.out.println(INPUT_CAR_SENTENCE);
        return Console.readLine();
    }

    public String getTryCount() {
        System.out.println(INPUT_TRY_COUNT_SENTENCE);
        return Console.readLine();
    }
}
