package racingcar.controller;

import java.util.ArrayList;
import java.util.List;
import racingcar.dto.RacingRequestDto;
import racingcar.dto.RacingResponseDto;
import racingcar.model.car.Car;
import racingcar.model.car.RandomMovingCar;
import racingcar.model.racing.Racing;
import racingcar.model.result.RoundResult;
import racingcar.util.CarNameParser;
import racingcar.util.CarNameValidator;
import racingcar.util.RaceRoundValidator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingController {
    private final InputView inputView;
    private final OutputView outputView;

    public RacingController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }


    public void run() {
        RacingRequestDto racingRequest = inputView.getRacingRequest();
        Racing racing = initRacing(racingRequest);

        List<RoundResult> roundResults = runRacing(racing);
        List<String> winners = racing.getWinners()
                .stream()
                .map(Car::getName)
                .toList();

        outputView.printRacingResponse(new RacingResponseDto(roundResults, winners));
    }

    private Racing initRacing(RacingRequestDto racingRequest) {
        List<String> carNames = getValidatedCarNames(racingRequest.rawCarNames());
        List<Car> cars = carNames.stream()
                .map(RandomMovingCar::new)
                .map(car -> (Car) car)
                .toList();
        int raceRound = getValidatedRaceRound(racingRequest.rawRoundsToRace());
        return Racing.from(cars, raceRound);
    }

    private List<RoundResult> runRacing(Racing racing) {
        List<RoundResult> roundResults = new ArrayList<>();
        while (racing.hasNextRound()) {
            racing.executeRound();
            roundResults.add(RoundResult.from(racing.getParticipants().getParticipants()));
        }
        return roundResults;
    }

    private List<String> getValidatedCarNames(String rawCarNames) {
        List<String> carNames = CarNameParser.parseCarName(rawCarNames);
        CarNameValidator.validateCarNames(carNames);
        return carNames;
    }

    private int getValidatedRaceRound(String rawRaceRound) {
        RaceRoundValidator.validateRaceRound(rawRaceRound);
        return Integer.parseInt(rawRaceRound);
    }
}
