package racingcar.controller;

import racingcar.domain.RacingCar;
import racingcar.dto.InputDto.RequestInputDto;
import racingcar.service.RacingCarService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class RacingCarController {

    private final InputView inputView;
    private final RacingCarService racingCarService;
    private final OutputView outputView;

    public RacingCarController(final InputView inputView, final RacingCarService racingCarService,
            OutputView outputView) {
        this.inputView = inputView;
        this.racingCarService = racingCarService;
        this.outputView = outputView;
    }

    public void runGame() {
        final RequestInputDto requestInputDto = inputView.readInput();
        final List<RacingCar> carStateAfterGame = racingCarService.runGame(requestInputDto.getInputCars(),
                requestInputDto.getInputCnt());
        outputView.calculateWinners(carStateAfterGame);
    }
}
