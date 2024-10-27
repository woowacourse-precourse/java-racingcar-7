package racingcar.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.model.Car;
import racingcar.domain.model.RacingManager;
import racingcar.dto.request.RacingRequestDTO;
import racingcar.dto.response.CarRoundStateDTO;
import racingcar.dto.response.RacingResponseDTO;
import racingcar.dto.response.RoundResultDTO;

public class RacingServiceImpl implements RacingService {

    @Override
    public RacingResponseDTO race(RacingRequestDTO racingRequestDTO) {
        RacingManager racingManager = initializeParticipants(racingRequestDTO.carNames());
        int moveCount = racingRequestDTO.moveCount();

        List<RoundResultDTO> roundResultDTOs = performRaceMoves(racingManager, moveCount);

        List<String> winnerNames = determineWinners(racingManager);

        return RacingResponseDTO.of(roundResultDTOs, winnerNames);
    }

    private RacingManager initializeParticipants(List<String> carNames) {
        return RacingManager.createWithCars(carNames);
    }

    private List<RoundResultDTO> performRaceMoves(RacingManager racingManager, int moveCount) {
        List<RoundResultDTO> roundResults = new ArrayList<>();
        for (int i = 0; i < moveCount; i++) {
            roundResults.add(executeMove(racingManager));
        }
        return roundResults;
    }

    private RoundResultDTO executeMove(RacingManager racingManager) {
        racingManager.moveCars();
        List<Car> movedCars = racingManager.getCars();
        return createRoundResult(movedCars);
    }

    private RoundResultDTO createRoundResult(List<Car> cars) {
        List<CarRoundStateDTO> carStates = cars.stream()
                .map(CarRoundStateDTO::from)
                .collect(Collectors.toList());
        return RoundResultDTO.of(carStates);
    }

    private List<String> determineWinners(RacingManager racingManager) {
        return racingManager.findWinnerNames();
    }
}
