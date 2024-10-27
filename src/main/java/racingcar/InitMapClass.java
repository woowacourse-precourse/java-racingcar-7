package racingcar;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class InitMapClass {
    private static final String DELIMITER = ",";
    private static final int NAME_LENGTH_LIMIT = 5;

    /**
     * 사용자가 입력한 이름 문자열을 구분자인 쉼표(,)를 기준으로 이름을 구분합니다.
     *
     * @param inputString 사용자가 입력한 이름 문자열입니다.
     * @return 구분한 이름들에 대한 List입니다.
     */
    List<String> splitCarNameString(String inputString) {
        return Arrays.stream(inputString.split(DELIMITER))
                .map(String::strip)
                .collect(Collectors.toList());
    }

    /**
     * 이름 List에 있는 원소들을 stateMap의 Key로 저장합니다.
     * 이름이 공백이거나 일정 길이를 초과한 경우, 중복된 경우 예외를 발생시킵니다.
     *
     * @param nameList 이름이 저장된 List입니다.
     * @throws IllegalArgumentException 잘못된 입력이 주어진 경우 에러를 발생시킵니다.
     */
    Map<String, Integer> setStateMap(List<String> nameList) throws IllegalArgumentException {
        Map<String, Integer> stateMap = new HashMap<>();

        for (String name : nameList) {
            String playerName = name.strip();
            if (playerName.isBlank() || playerName.length() > NAME_LENGTH_LIMIT) {
                throw new IllegalArgumentException();
            } else if (stateMap.containsKey(playerName)) {
                throw new IllegalArgumentException();
            } else {
                stateMap.put(playerName, 0);
            }
        }

        return stateMap;
    }
}
