package racingcar.view;

import org.junit.jupiter.api.Test;
import racingcar.dto.CarDto;
import racingcar.dto.RoundDto;
import racingcar.viewHandler.api.Api;
import racingcar.viewHandler.api.message.ServerMessage;

import java.util.List;

class OutputTest {

    private final Output output = Output.of();

    @Test
    void 첫_라운드_성공() {
        List<CarDto> carDtos = List.of(new CarDto("pobi", 1),
                new CarDto("woni", 0),
                new CarDto("jun", 1));
        RoundDto roundDto = new RoundDto(carDtos,1);
        Api api = new Api<RoundDto>(ServerMessage.서버_성공, roundDto);
        output.viewOneRound(api);
    }

    @Test
    void 세번째_라운드_성공() {
        List<CarDto> carDtos = List.of(new CarDto("pobi", 3),
                new CarDto("woni", 2),
                new CarDto("jun", 3));
        RoundDto roundDto = new RoundDto(carDtos,3);
        Api api = new Api<RoundDto>(ServerMessage.서버_성공, roundDto);
        output.viewOneRound(api);
    }

    @Test
    void 최종_우승자_성공() {
        String winner = "pobi, jun";
        Api api = new Api<String>(ServerMessage.서버_성공, winner);
        output.viewResult(api);
    }
}