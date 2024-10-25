package racingcar;

import java.util.Arrays;
import java.util.List;

public class IOPreprocessor {
    private static List<String> parsingInput(String input) {
        String[] splitInput = input.split(",");
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

    private static void setRacingCarTrace(List<String> parsingInput, RacingCarTrace racingCarTrace) {
        parsingInput.stream().map(RacingCar::new).forEach(racingCarTrace::put);
    }

    public static void inputPreprocessing(String input, RacingCarTrace racingCarTrace) {
        var parsingInput = parsingInput(input);
        setRacingCarTrace(parsingInput, racingCarTrace);
    }

    public static String tracePreprocessing(RacingCarTrace racingCarTrace) {
        var sb = new StringBuilder();
        for (int i = 0; i < racingCarTrace.size(); i++) {
            var racingCar = racingCarTrace.getRacingCar(i);
            sb.append(racingCar.name()).append(" : ");
            for (int j = 0; j < racingCarTrace.getDistance(racingCar); j++) {
                sb.append("-");
            }
            sb.append("\n");
        }
        sb.append("\n");
        return sb.toString();
    }

    public static String resultPreprocessing(List<RacingCar> biggestDistanceRacingCar) {
        var racingCarName = biggestDistanceRacingCar.stream().map(RacingCar::name).toList();
        return String.join(", ", racingCarName);
    }
}