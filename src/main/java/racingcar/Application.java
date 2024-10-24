package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.Map;

public class Application {
    private static final char DELIMITER = ',';
    private static final int NAME_LENGTH_LIMIT = 5;
    private static final int MOVING_FORWARD = 4;

    private static Map<String, Integer> currentSituation = null;
    private static int playCount = 0;
    public static void main(String[] args) {
        setArguments();
    }

    /**
     * 사용자가 입력한 문자열을 통해 프로그램을 수행하는 데 필요한 변수들을 설정한다.
     *
     * @throws IllegalArgumentException 입력한 문자열이 올바른 값이 아닌 경우 해당 예외를 발생시킵니다.
     */
    private static void setArguments() throws IllegalArgumentException {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String InputCarNames = Console.readLine();

        System.out.println("시도할 횟수는 몇 회인가요?");
        playCount = Integer.parseInt(Console.readLine());
    }
}
