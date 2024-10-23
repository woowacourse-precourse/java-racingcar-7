package racingcar.util;

import java.security.Key;
import java.util.HashMap;

public class RacingCarNameValidator {

    /**
     * Input : String
     * Check List
     * 1. The Name Should be Shorter than 6 (1~5)
     * 2. It Should be Not null Name Like
     *      Ex_) "Alex,James," -> End is null / ",Alex,James" -> Front is null
     * 3. It Should Not Duplicate(+)
     */

    public static void checkRacingCarNameListIsAvailable(String racingCarNames) {
        String[] racingCarList = racingCarNames.split(",");
        int numOfRacingCar = racingCarList.length;

        // test each exception case
        validateNameLength(racingCarList);
        validateDelimiter(racingCarNames, numOfRacingCar);
        validateDuplicateNames(racingCarList);
    }

    // Case 1. Check It has 1~5 length of name
    static void validateNameLength(String[] racingCarList) {
        for (String name : racingCarList) {
            if (name.isEmpty() || name.length() > 5) {
                throw new IllegalArgumentException(" ERR : 입력값이 옳지 않습니다. 이름은 1~5자이어야 합니다.");
            }
        }
    }

    // Case 2. Check It has null String at End
    static void validateDelimiter(String racingCarNames, int numOfRacingCar) {
        int numOfDelimiter = racingCarNames.length() - racingCarNames.replace(",", "").length();
        if (numOfRacingCar - numOfDelimiter != 1) {
            throw new IllegalArgumentException(" ERR : 입력값이 옳지 않습니다. 구분자 문제.");
        }
    }

    // Case 3. Check It has Duplicate Name
    static void validateDuplicateNames(String[] racingCarList) {
        HashMap<String, Integer> nameHashMap = new HashMap<>();
        for (String name : racingCarList) {
            if (nameHashMap.containsKey(name)) {
                throw new IllegalArgumentException(" ERR : 중복된 이름이 있습니다.");
            }
            nameHashMap.put(name, 1);
        }
    }
}