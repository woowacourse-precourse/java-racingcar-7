package racingcar.controller;

import racingcar.validator.TrialCountValidator;
import racingcar.view.InputView;

// 시도 횟수를 입력받고 검증하는 클래스
public class TrialCountInputHandler {

    // 시도 횟수를 입력받아 검증 후 반환하는 메서드
    public int getTrialCount() {
        // 사용자로부터 시도 횟수 입력 받기
        int trialCount = InputView.inputTrialCount();

        // 입력받은 시도 횟수 검증
        TrialCountValidator.validateTrialCount(trialCount);

        // 검증이 완료된 시도 횟수 반환
        return trialCount;
    }
}
