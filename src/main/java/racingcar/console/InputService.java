package racingcar.console;

import racingcar.value.Player;
import racingcar.value.RacingCar;
import racingcar.value.RacingCarList;
import racingcar.value.TotalLaps;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static camp.nextstep.edu.missionutils.Console.readLine;

final class InputService {
    private static final String SPLIT_REGEX = ",";

    private final InputValidator inputValidator;
    private final Convertor convertor;

    private InputService(InputValidator inputValidator, Convertor convertor) {
        this.inputValidator = inputValidator;
        this.convertor = convertor;
    }

    public static InputService init() {
        return new InputService(InputValidator.init(), Convertor.init());
    }

    public RacingCarList readRacingCarList() {
        return Stream.of(readLine())
            .peek(inputValidator::validLastString)
            .map(input -> input.split(SPLIT_REGEX))
            .peek(inputValidator::validPlayerList)
            .flatMap(Arrays::stream)
            .map(Player::from)
            .map(RacingCar::initAndFrom)
            .collect(Collectors.collectingAndThen(Collectors.toList(), RacingCarList::new));
    }

    public TotalLaps readTotalLaps() {
        return Stream.of(readLine())
            .map(convertor::parseLong)
            .peek(inputValidator::validTotalLapCount)
            .map(TotalLaps::new)
            .findFirst()
            .orElseThrow(IllegalArgumentException::new);
    }
}