package racingcar.service;

import racingcar.model.Cars;
import racingcar.model.RacingRoundResultRecorder;
import racingcar.model.dto.RacingRequestDTO;
import racingcar.model.dto.RacingResponseDTO;

public class RacingService {
    private final static String NAME_SPLIT_DELIMITER = ",";
    private final RacingRound racingRound;

    public RacingService(RacingRound racingRound) {
        this.racingRound = racingRound;
    }

    public RacingResponseDTO race(RacingRequestDTO racingRequestDTO) {
        Cars cars = createCars(racingRequestDTO.getInputNames());
        RacingRoundResultRecorder racingRoundResultRecorder = recordRacing(getRoundCount(racingRequestDTO), cars);
        return RacingResponseDTO.create(racingRoundResultRecorder.getRecorderToString());
    }

    private int getRoundCount(RacingRequestDTO racingRequestDTO) {
        return Integer.parseInt(racingRequestDTO.getRoundCount());
    }

    private RacingRoundResultRecorder recordRacing(int roundCount, Cars cars) {
        RacingRoundResultRecorder racingRoundResultRecorder = recordEachRound(roundCount, cars);
        racingRoundResultRecorder.recordTopRanker(cars.findTopRankers());
        return racingRoundResultRecorder;
    }

    private RacingRoundResultRecorder recordEachRound(int roundCount, Cars cars) {
        RacingRoundResultRecorder racingRoundResultRecorder = RacingRoundResultRecorder.create();
        for (int i = 1; i <= roundCount; i++) {
            racingRound.recordRound(cars, racingRoundResultRecorder);
        }
        return racingRoundResultRecorder;
    }

    private Cars createCars(String inputNames) {
        return Cars.create(inputNames.split(NAME_SPLIT_DELIMITER));
    }
}
