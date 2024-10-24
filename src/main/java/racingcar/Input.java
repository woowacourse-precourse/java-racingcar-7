package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class Reader {

    private final List<String> carNames = new ArrayList<>();

    private static final String INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String RACING_COUNT_MESSAGE = "시도할 횟수는 몇 회인가요?";

    public static List<String> getInput(){
        getInputMessage();
        String input = Console.readLine();
        // carNames 검증한 후, split한 후list 에 담기
        List<String> names = new ArrayList<>();
        return names;
    }

    public static int getNumber() {
        getCountMessage();
        return Integer.parseInt(Console.readLine());
    }

    public static void close() {
        Console.close();
    }

    private static void getInputMessage() {
        System.out.println(INPUT_MESSAGE);
    }

    private static void getCountMessage() {
        System.out.println(RACING_COUNT_MESSAGE);
    }

    public void appendNames() {

    }
}
