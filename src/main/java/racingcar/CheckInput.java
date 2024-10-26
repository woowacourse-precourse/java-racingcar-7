package racingcar;

import java.util.HashSet;
import java.util.Set;

public class CheckInput {
    private static final int MAX_NAME_LENGTH = 5;
    private static final String DELIMITER = ",";
    private static final String NUMBER_REGEX = "\\d+";
    private static final String ERROR_NAME_LENGTH = "자동차의 이름은 다섯 글자를 넘을 수 없습니다.";
    private static final String ERROR_NAME_ALREADY_EXIST = "중복된 이름이 존재합니다.";
    private static final String ERROR_INVALID_COUNT = "올바른 숫자를 입력해 주세요.";



    public String[] splitNames(String carNameString) {


        String[] cars = carNameString.split(DELIMITER);
        Set<String> nameSet = new HashSet<>();
        for (String car : cars) {
            String trimmedCarName = car.trim();
            if (trimmedCarName.length() > MAX_NAME_LENGTH) {
                throw new IllegalArgumentException(ERROR_NAME_LENGTH);
            }
            if (nameSet.contains(trimmedCarName)) {
                throw new IllegalArgumentException(ERROR_NAME_ALREADY_EXIST);
            }
            nameSet.add(trimmedCarName);
        }

        return nameSet.toArray(new String[0]);
    }

    public int isValidCount(String raceCountString) {
        if (raceCountString == null || raceCountString.isEmpty() || !raceCountString.matches(NUMBER_REGEX)) {
            throw new IllegalArgumentException(ERROR_INVALID_COUNT);
        }
        return Integer.parseInt(raceCountString);
    }
}
