package racingcar.controller;

import racingcar.domain.Car;
import racingcar.domain.Race;
import racingcar.dto.CarDto;
import racingcar.dto.InputDto;
import racingcar.viewHandler.ApiHandler;
import racingcar.viewHandler.ViewHandler;
import racingcar.viewHandler.api.Api;

import java.util.List;
import java.util.stream.IntStream;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class GameController {
    private final ViewHandler viewHandler;
    private final ApiHandler apiHandler;

    public GameController() {
        viewHandler = ViewHandler.of();
        apiHandler = ApiHandler.of();
    }

    public void playGame() {
        Api<InputDto> inputDto = viewHandler.inputHandler();
        Integer totalRound = inputDto.getData().getTotalRound();
        Race race = createRace(inputDto.getData());

        game(race, totalRound);

        List<CarDto> winnerCars = transformCarsDto(race.getWinnerCars());
        viewHandler.outputHandler(apiHandler.transformResultDto(winnerCars));
    }

    private Race createRace(InputDto inputDto) {
        List<String> carnames = inputDto.getCarnames();
        return Race.of(carnames);
    }

    private void game(Race race, Integer round) {
        IntStream.range(0, round).forEach(oneRound -> {
            oneRoundGame(race);
            List<CarDto> carDtos = transformCarsDto(race.getCars());
            viewHandler.outputHandler(apiHandler.transformRoundDto(carDtos, oneRound));
        });
    }

    private void oneRoundGame(Race race) {
        race.getCars().forEach(oneCar -> {
            oneCar.moveCar(pickNumberInRange(0, 9));
        });
    }

    private List<CarDto> transformCarsDto(List<Car> cars) {
        return cars.stream().map(CarDto::new).toList();
    }
}
