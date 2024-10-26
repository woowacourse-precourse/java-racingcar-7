package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.controller.RacingCarController;
import racingcar.domain.Car;
import racingcar.dto.request.RaceRequest;
import racingcar.dto.request.RacingCarRequest;
import racingcar.dto.response.RaceResponse;
import racingcar.dto.response.RacingCarResponse;
import racingcar.dto.request.RoundRequest;
import racingcar.dto.response.RoundResponse;
import racingcar.util.Container;

import java.util.List;

public class RacingCarView {

    private final RacingCarController racingCarController;

    public RacingCarView() {
        this.racingCarController = Container.getInstance(RacingCarController.class);
    }

    public List<Car> setCarNames() {
        String carNames = Console.readLine();
        RacingCarResponse response = racingCarController.setRacingCars(RacingCarRequest.from(carNames));

        return response.racingCars();
    }

    public int setRound() {
        String round = Console.readLine();
        RoundResponse response = racingCarController.setRound(RoundRequest.from(round));

        return response.round();
    }

    public List<String> startRace(List<Car> racingCars, int roundNum) {
        RaceResponse response = racingCarController.startRace(RaceRequest.of(racingCars, roundNum));

        return response.winners();
    }
}