package racingcar.view;

import static racingcar.constant.RacingCarInfoMsg.TRACKING_START_MSG;

import java.util.Map;
import java.util.Set;

public class OutputView {

    //TODO : 출력 기능을 담당하는 클래스

    public void printTrackingStartMsg() {
        System.out.println(TRACKING_START_MSG.getMsg());
    }

    public void printCurrentRaceProcess(Map<String, String> raceTracker) {

        StringBuilder sb = new StringBuilder();

        Set<String> carNames = raceTracker.keySet();

        for (String carName : carNames) {
            sb.append("%s : %s\n".formatted(carName, raceTracker.get(carName)));
        }

        System.out.println(sb);
    }
}
