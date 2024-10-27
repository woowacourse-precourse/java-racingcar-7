package racingcar.filter.executor;

import racingcar.model.CarList;

public class MockRaceExecutor extends RaceExecutor {
    private boolean executed = false;

    @Override
    public void executeRace(CarList carList, int iterations) {
        executed = true; // 메서드가 호출되었음을 표시
        // 추가적인 로직을 여기에 추가할 수 있습니다.
    }

    public boolean isExecuted() {
        return executed; // 메서드 호출 여부를 확인하기 위한 getter
    }
}

