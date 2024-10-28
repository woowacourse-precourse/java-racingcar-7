package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class InputView {
    private static final String INPUT_NAME_MESSAGE =
            "경주할 자동차 이름을 입력 하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String NOT_NUMBER_MESSAGE = "플레이 횟수는 숫자를 입력해야 합니다";

    public static int playCount() {
        String playCount = Console.readLine();
        validatePlayCount(playCount);
        return Integer.parseInt(playCount);
    }

    private static void validatePlayCount(String playCount) {
        try {
            Integer.parseInt(playCount);
        }catch (NumberFormatException e){
            throw new IllegalArgumentException(NOT_NUMBER_MESSAGE);
        }
    }

    public static List<String> playerNames() {
        printInputNameMessage();
        return stringToList(Console.readLine());
    }

    private static List<String> stringToList(String names){
        return Arrays.stream(names.split(","))
                .map(String::trim)
                .toList();
    }

    private static void printInputNameMessage(){
        System.out.println(INPUT_NAME_MESSAGE);
    }
}
