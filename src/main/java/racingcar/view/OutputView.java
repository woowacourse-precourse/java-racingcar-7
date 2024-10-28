package racingcar.view;

import java.util.List;
import racingcar.domain.RacingCarStatus;

public class OutputView {

    public void printResultMessage() {
        System.out.println("실행 결과");
    }

    public void printWinners(List<String> winners) {
        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }

    public void printRacingCarsStatus(List<RacingCarStatus> racingCarsStatus) {
        for(RacingCarStatus carStatus : racingCarsStatus) {
            System.out.println(carStatus);
        }
        System.out.println();
    }
}
