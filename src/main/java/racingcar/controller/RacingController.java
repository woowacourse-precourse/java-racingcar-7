package racingcar.controller;

import racingcar.model.entity.CarsByNames;
import racingcar.model.dto.RacingRecording;
import racingcar.model.dto.CarNames;
import racingcar.model.entity.RacingChance;
import racingcar.model.entity.RacingTurns;
import racingcar.model.entity.StrategiesByCarNames;
import racingcar.service.RacingService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

/**
 * View와 Service 사이를 연결하는 클래스
 * InputView로부터 자동차 이름과 주행 시도 횟수 문자열을 건네 받아서
 * 객체 생성 후 Cars 객체를 생성한다. Service에게 Cars객체와 RacingChance를
 * 넘겨주고 결과 값을 요청하며 OutputView에 결과를 전달한다.
 */
public class RacingController {

    private final InputView inputView;

    private final OutputView outputView;

    private final RacingService racingService;

    public RacingController(InputView inputView, OutputView outputView,
                                RacingService racingService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.racingService = racingService;
    }

    public void run() {

        // 주요 모델 생성
        CarNames names = CarNames.getAfterValidateFormat(inputView.getCarNames());
        RacingChance chance =
                RacingChance.getAfterValidateFormat(inputView.getChanceToMove());
        CarsByNames carsByNames = CarsByNames.getInstance(names);
        StrategiesByCarNames strategies =
                StrategiesByCarNames.getAllRandomMove(names, chance);
        RacingTurns turns =
                RacingTurns.getInstance(names, strategies, chance);

        // 레이싱 서비스 호출
        racingService.raceOfCarsAndTurns(carsByNames, turns);

        // 레이싱 기록 불러와서 출력
        RacingRecording recording = racingService.getRecord();
        outputView.printResult(recording);

    }

}
