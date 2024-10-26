package racingcar;

import java.util.Arrays;
import java.util.List;
import org.junit.platform.commons.util.StringUtils;

public class IOUtils {
    public static List<String> splitInput(String input) {
        if (StringUtils.isBlank(input) || input.charAt(input.length() - 1) == ',') {
            throw new IllegalArgumentException("입력된 이름 중 빈 문자가 존재합니다.");
        }
        var splitInput = input.split(",");
        validateSplitInput(splitInput);
        return Arrays.stream(splitInput).toList();
    }

    /**
     * @param splitInput 배열 중간에 빈 문자가 있는지 확인
     */
    private static void validateSplitInput(String[] splitInput) {
        if (Arrays.stream(splitInput).anyMatch(String::isBlank)) {
            throw new IllegalArgumentException("입력된 이름 중 빈 문자가 존재합니다.");
        }
    }

    public static String resultOutput(List<String> biggestDistanceRacingCarName) {
        var racingCarName = biggestDistanceRacingCarName.stream().toList();
        return String.join(", ", racingCarName);
    }
}