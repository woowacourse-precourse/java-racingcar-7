package racingcar.service;

import java.util.Arrays;
import java.util.List;
import racingcar.common.CarParser;
import racingcar.common.InputSplitter;
import racingcar.domain.Car;
import racingcar.domain.RacingGame;
import racingcar.dto.RacingCarRequestDto;
import racingcar.dto.RacingCarResponseDto;

public class RacingCarService {

    public RacingCarResponseDto start(final RacingCarRequestDto requestDto) {
        String carNames = requestDto.carNames();
        Integer round = requestDto.round();

        String[] splitCarNames = InputSplitter.split(carNames);
        List<Car> cars = Arrays.stream(splitCarNames)
                .map(Car::new)
                .toList();

        RacingGame racingGame = new RacingGame(cars, round);
        racingGame.play();

        List<Car> winners = racingGame.getWinners();
        String winnerName = CarParser.convertCarsToNames(winners);

        return new RacingCarResponseDto(winnerName);
    }
}
