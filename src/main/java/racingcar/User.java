package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class User {

    private final static String USER_INPUT_CAR_NAME = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private final static String USER_INPUT_GAME_REPEAT = "시도할 횟수는 몇 회인가요?";
    private final static String USER_INPUT_GAME_REPEAT_ERROR_MESSAGE = "1 이상의 정수만 입력이 가능합니다";

    public static List<String> inputCarNames() {
        System.out.println(USER_INPUT_CAR_NAME);

        String userCarNamesInput = Console.readLine();

        // 분리된 문자열 (,) 앞 뒤 공백만 제거하는 정규표현식 사용
        List<String> carNamesList = List.of(userCarNamesInput.split("\\s*,\\s*"));
        carNamesList = handleDuplicateCarNames(carNamesList);
        return new ArrayList<>(carNamesList);
    }

    public static int inputGameRepeats() {
        System.out.println(USER_INPUT_GAME_REPEAT);

        String userGameRepeatInput = Console.readLine().strip();
        validateInputGameRepeats(userGameRepeatInput);
        return Integer.parseInt(userGameRepeatInput);
    }

    private static List<String> handleDuplicateCarNames(List<String> carNamesList) {
        return carNamesList.stream().distinct().collect(Collectors.toList());
    }

    private static void validateInputGameRepeats(String userGameRepeatInput) {
        if (userGameRepeatInput.isBlank()) throw new IllegalArgumentException(USER_INPUT_GAME_REPEAT_ERROR_MESSAGE);
        if (userGameRepeatInput.equals("0")) throw new IllegalArgumentException(USER_INPUT_GAME_REPEAT_ERROR_MESSAGE);
        for (int i = 0; i < userGameRepeatInput.length(); i ++) {
            if (!Character.isDigit(userGameRepeatInput.charAt(i))) throw new IllegalArgumentException(USER_INPUT_GAME_REPEAT_ERROR_MESSAGE);
        }
    }

}
