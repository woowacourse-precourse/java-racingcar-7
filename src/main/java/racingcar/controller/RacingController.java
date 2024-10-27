package racingcar.controller;

import racingcar.dto.RacingInfoDTO;
import racingcar.dto.RacingInputReq;
import racingcar.service.RacingService;
import racingcar.service.WinnerService;
import racingcar.util.Validator;
import racingcar.view.InputView;
public class RacingController {
    public void run() {
        /*
        입력, 레이싱, 최종 우승 자동차 출력 수행
        */
        InputView inputView = new InputView();
        Validator validator = new Validator();
        RacingService racingService = new RacingService();
        WinnerService winnerService = new WinnerService();

        // 유저 입력 받기
        RacingInputReq racingInputReq = new RacingInputReq(inputView.inputCarNames(), inputView.inputRaceRounds());
        RacingInfoDTO racingInfoDTO = validator.validInput(racingInputReq);

        // 유저 입력 검증 및 레이싱 수행
        racingService.racing(racingInfoDTO);

        // 우승 자동차 찾기
        winnerService.findWinner(racingInfoDTO);
    }
}