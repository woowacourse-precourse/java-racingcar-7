package racingcar.service;

import java.util.List;
import java.util.stream.IntStream;
import racingcar.domain.model.Car;
import racingcar.domain.model.RacingManager;
import racingcar.dto.request.RacingRequestDTO;
import racingcar.dto.response.CarRoundStateDTO;
import racingcar.dto.response.RacingResponseDTO;
import racingcar.dto.response.RoundResultDTO;

public class RacingServiceImpl implements RacingService {

    @Override
    public RacingResponseDTO race(RacingRequestDTO racingRequestDTO) {
        RacingManager racingManager = RacingManager.createWithCars(racingRequestDTO.carNames());
        int moveCount = racingRequestDTO.moveCount();

        List<RoundResultDTO> roundResultDTOs = IntStream.range(0, moveCount)
                .mapToObj(i -> {
                    racingManager.moveCars();
                    return createRoundResult(racingManager.getCars());
                }).toList();

        List<String> winnerNames = racingManager.findWinnerNames();
        return RacingResponseDTO.of(roundResultDTOs, winnerNames);
    }

    private RoundResultDTO createRoundResult(List<Car> cars) {
        List<CarRoundStateDTO> carStates = cars.stream()
                .map(CarRoundStateDTO::from)
                .toList();
        return RoundResultDTO.of(carStates);
    }
}
