package racingcar.viewHandler;

import racingcar.dto.CarDto;
import racingcar.dto.InputDto;
import racingcar.dto.RoundDto;
import racingcar.viewHandler.api.Api;
import racingcar.viewHandler.api.message.ServerMessage;
import racingcar.viewHandler.api.Validator;

import java.util.List;

public class ApiHandler {
    private final String COMMA = ",";

    private final Validator validator;

    protected ApiHandler() {
        validator = new Validator();
    }

    public static ApiHandler of() {
        return new ApiHandler();
    }

    public Api<InputDto> transformInputDto(List<String> carnames, Integer totalRound) {
        InputDto inputDto = new InputDto(carnames, totalRound);
        return new Api<>(ServerMessage.서버_성공, inputDto);
    }

    public List<String> splitCarnames(String inputData) {
        List<String> carnames = List.of(inputData.split(COMMA));
        validator.validateMinCarCount(carnames);
        validator.validateCarNameLength(carnames);
        return carnames;
    }

    public Integer parserTotalRound(String inputData) {
        Integer number = validator.tryParserToInt(inputData);
        validator.validatePositiveNumber(number);
        return number;
    }

    public Api<RoundDto> transformRoundDto(List<CarDto> carDtos, Integer round) {
        RoundDto roundDto = new RoundDto(carDtos, round);
        return new Api<>(ServerMessage.서버_성공, roundDto);
    }

    public Api<String> transformResultDto(List<CarDto> winnerCars) {
        StringBuilder result = new StringBuilder();
        winnerCars.forEach(winCar -> {
            result.append(winCar.getCarname()).append(", ");
        });

        if (!result.isEmpty()) {
            result.setLength(result.length() - 2);
        }

        return new Api<>(ServerMessage.서버_성공, result.toString());
    }
}
