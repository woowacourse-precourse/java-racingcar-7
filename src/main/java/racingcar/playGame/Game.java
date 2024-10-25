package racingcar.playGame;

import racingcar.domain.Car;
import racingcar.domain.Race;
import racingcar.dto.CarDto;
import racingcar.dto.RoundDto;
import racingcar.dto.api.Api;
import racingcar.dto.api.ApiMessage;
import racingcar.view.Input;
import racingcar.view.Output;

import java.util.List;
import java.util.stream.IntStream;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class Game {
    private final Input input;
    private final Output output;

    protected Game() {
        input = Input.of();
        output = Output.of();
    }

    public static Game of() {
        return new Game();
    }

    public void playGame() {
        List<String> carnames = input.getCarnames();
        Race race = Race.of(carnames);
        Integer totalRound = input.getTotalRound();
        game(race, totalRound);
        output.viewResult(transformResultDto(race));
    }

    private void game(Race race, Integer round) {
        IntStream.range(0, round).forEach(oneRound -> {
            oneRoundGame(race);
            output.viewOneRound(transformRoundDto(race.getCars(), oneRound));
        });
    }

    private void oneRoundGame(Race race) {
        race.getCars().forEach(oneCar -> {
            oneCar.moveCar(pickNumberInRange(0, 9));
        });
    }

    private Api<RoundDto> transformRoundDto(List<Car> cars, Integer round) {
        List<CarDto> carDtos = cars.stream().map(CarDto::new).toList();
        RoundDto roundDto = new RoundDto(carDtos, round);
        return new Api<>(ApiMessage.성공, roundDto);
    }

    private Api<String> transformResultDto(Race race) {
        StringBuilder result = new StringBuilder();
        List<Car> winnerCars = race.getWinnerCars();

        winnerCars.forEach(winCar -> {
            result.append(winCar.getCarname()).append(", ");
        });

        if (!result.isEmpty()) {
            result.setLength(result.length() - 2);
        }

        return new Api<>(ApiMessage.성공, result.toString());
    }
}
