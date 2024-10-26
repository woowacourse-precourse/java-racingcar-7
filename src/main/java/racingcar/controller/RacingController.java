package racingcar.controller;

import racingcar.service.RacingService;
import racingcar.utils.StringSplitter;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class RacingController {

    private final InputView inputView;
    private final OutputView outputView;
    private final StringSplitter stringSplitter;
    private final RacingService racingService;

    public RacingController(InputView inputView, OutputView outputView, StringSplitter stringSplitter, RacingService racingService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.stringSplitter = stringSplitter;
        this.racingService = racingService;
    }

    public void run() {
        /*
         * 상수 데이터 출력
         */
        outputView.askCarName();
        /*
         * 자동차 이름 입력 받기
         */
        String carNames = inputView.askCarName();
        /*
         * 구분자 기분으로 문자열 리스트로 변환
         */
        List<String> carList = stringSplitter.split(carNames);
        /*
         * Racingcar 객체를 Racingcars 객체 리스트에 저장
         */
        racingService.saveCarName(carList);
    }
}
