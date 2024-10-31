package racingcar.back.service;

import java.util.List;
import racingcar.global.dto.CarRaceResponseDTO;

public interface CarRaceGameRunnerService {
    CarRaceResponseDTO runGame(List<String> gameNames, Integer gamePlayCount);
}
