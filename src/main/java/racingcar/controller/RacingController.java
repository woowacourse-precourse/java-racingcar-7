package racingcar.controller;

import racingcar.dto.RacingInfoDTO;
import racingcar.dto.RacingInputReq;
import racingcar.service.RacingService;
import racingcar.service.WinnerService;
import racingcar.util.Validator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingController {
    public void run() {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        Validator validator = new Validator();
        RacingService racingService = new RacingService();
        WinnerService winnerService = new WinnerService();

        // 유저 입력 받기
        RacingInputReq racingInputReq = new RacingInputReq(inputView.inputCarNames(), inputView.inputRaceRounds());
        RacingInfoDTO racingInfoDTO = validator.validInput(racingInputReq);

        // 유저 입력 검증 및 레이싱 수행
        racingService.racing(racingInfoDTO);

        // 우승 자동차 찾기
        outputView.printWinner(winnerService.findWinner(racingInfoDTO));
    }
}