package racingcar.service;

import static racingcar.model.OutputFormat.NAME_SPLIT_DELIMITER;

import racingcar.model.Cars;
import racingcar.model.RacingRoundResultRecorder;
import racingcar.model.dto.RacingRequestDTO;
import racingcar.model.dto.RacingResponseDTO;

public class RacingService {
    private final RacingRound racingRound;

    public RacingService(RacingRound racingRound) {
        this.racingRound = racingRound;
    }

    public RacingResponseDTO race(RacingRequestDTO racingRequestDTO) {
        Cars cars = createCars(racingRequestDTO.getInputNames());
        RacingRoundResultRecorder racingRoundResultRecorder = playAllRound(
                Integer.parseInt(racingRequestDTO.getRoundCount()),
                cars);
        return RacingResponseDTO.create(racingRoundResultRecorder.getRecorderToString());
    }

    private RacingRoundResultRecorder playAllRound(int roundCount, Cars cars) {
        RacingRoundResultRecorder racingRoundResultRecorder = RacingRoundResultRecorder.create();
        for (int i = 1; i <= roundCount; i++) {
            racingRound.recordEachRound(cars, racingRoundResultRecorder);
        }
        racingRoundResultRecorder.recordTopRanker(cars.findTopRankers());
        return racingRoundResultRecorder;
    }

    private Cars createCars(String inputNames) {
        return Cars.create(inputNames.split(NAME_SPLIT_DELIMITER.getFormat()));
    }
}
