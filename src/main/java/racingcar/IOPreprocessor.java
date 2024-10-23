package racingcar;

import java.util.Arrays;
import java.util.List;

public class IOPreprocessor {
    private static List<String> parsingInput(String input) {
        return Arrays.stream(input.split(",")).toList();
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
        return sb.toString();
    }

    public static String resultPreprocessing(List<RacingCar> biggestDistanceRacingCar) {
        var racingCarName = biggestDistanceRacingCar.stream().map(RacingCar::name).toList();
        return String.join(",", racingCarName);
    }
}