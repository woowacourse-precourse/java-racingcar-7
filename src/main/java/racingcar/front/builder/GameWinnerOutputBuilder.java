package racingcar.front.builder;

import java.util.List;
import racingcar.global.dto.CarRaceResponseDTO;
import racingcar.global.dto.CarRaceResult;

public class GameWinnerOutputBuilder {
    private static final String SEPARATOR = ", ";

    public static String build(CarRaceResponseDTO carRaceResponseDTO) {
        List<CarRaceResult> carRaceResults = carRaceResponseDTO.carRaceResults();
        List<String> winnerCarNames = carRaceResults.stream().filter(CarRaceResult::isWinner)
                .map(CarRaceResult::carName).toList();

        return String.join(SEPARATOR, winnerCarNames);
    }
}
