package racingcar.view.output.service.impl;

import racingcar.view.output.service.InfoOutputViewService;

public class TryNumberInfoOutputViewProcess implements InfoOutputViewService {
    @Override
    public void info() {
        System.out.println("시도할 횟수는 몇 회인가요?");
    }
}
