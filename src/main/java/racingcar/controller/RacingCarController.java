package racingcar.controller;

import racingcar.dto.RacingCarRequestDto;
import racingcar.dto.RacingCarResponseDto;
import racingcar.service.RacingCarService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarController {

    private final RacingCarService racingCarService = new RacingCarService();

    public void start() {
        String carNames = InputView.getCarNames();
        Integer round = InputView.getRound();

        RacingCarRequestDto requestDto = new RacingCarRequestDto(carNames, round);
        RacingCarResponseDto responseDto = racingCarService.start(requestDto);
        String winnerName = responseDto.winnerName();

        OutputView.printWinner(winnerName);
    }
}
