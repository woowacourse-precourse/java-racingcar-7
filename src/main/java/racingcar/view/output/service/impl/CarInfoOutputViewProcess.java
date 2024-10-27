package racingcar.view.output.service.impl;

import racingcar.view.output.service.InfoOutputViewService;

public class CarInfoOutputView implements InfoOutputViewService {
    @Override
    public void info() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }
}
