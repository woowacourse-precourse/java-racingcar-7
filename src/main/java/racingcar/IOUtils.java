package racingcar;

import java.util.Arrays;
import java.util.List;

public class IOUtils {
    public static List<String> splitInput(String input) {
        var splitInput = input.split(",");
        validateInput(input, splitInput);
        return Arrays.stream(splitInput).toList();
    }

    /**
     * @param input      마지막에 ,이 되어있는지 확인
     * @param splitInput 배열 중간에 빈 문자가 있는지 확인
     */
    private static void validateInput(String input, String[] splitInput) {
        if (input.charAt(input.length() - 1) == ',' || Arrays.stream(splitInput).anyMatch(String::isBlank)) {
            throw new IllegalArgumentException("입력된 이름 중 빈 문자가 존재합니다.");
        }
    }

    public static String resultOutput(List<RacingCar> biggestDistanceRacingCar) {
        var racingCarName = biggestDistanceRacingCar.stream().map(RacingCar::name).toList();
        return String.join(", ", racingCarName);
    }
}