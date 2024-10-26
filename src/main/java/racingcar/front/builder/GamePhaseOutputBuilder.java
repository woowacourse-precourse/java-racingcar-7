package racingcar.front.builder;

import java.util.List;
import java.util.stream.IntStream;
import racingcar.global.dto.CarRaceResponseDTO;
import racingcar.global.dto.CarRaceResult;

public class GamePhaseOutputBuilder {
    private static final String PHASE_DELIMITER = " : ";
    private static final String PHASE_MARK = "-";
    private static final String NEW_LINE = "\n";

    public static String build(CarRaceResponseDTO carRaceResponseDTO) {
        StringBuilder outputBuilder = new StringBuilder();

        Integer gamePlayCount = carRaceResponseDTO.gamePlayCount();
        List<CarRaceResult> carRaceResults = carRaceResponseDTO.carRaceResults();

        IntStream.range(0, gamePlayCount).forEach(i -> {
            carRaceResults.forEach(carResult -> {
                String phaseMarks = PHASE_MARK.repeat(carResult.racePhase().get(i));
                outputBuilder.append(carResult.carName()).append(PHASE_DELIMITER).append(phaseMarks).append(NEW_LINE);
            });
            outputBuilder.append(NEW_LINE);
        });

        return outputBuilder.toString();
    }
}
