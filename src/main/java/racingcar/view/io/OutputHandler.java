package racingcar.view.io;

import java.util.List;
import racingcar.model.RacingCarSnapShot;

public class OutputHandler {

    public void showCarNameInputComment() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public void showAttemptCountInputComment() {
        System.out.println("시도할 횟수는 몇 회인가요?");
    }

    public void showRaceResultComment() {
        System.out.println();
        System.out.println("실행 결과");
    }

    public void showRaceResult(List<RacingCarSnapShot> snapShots) {
        for (RacingCarSnapShot snapShot : snapShots) {
            System.out.printf("%s : %s%n", snapShot.name(), "-".repeat(snapShot.position()));
        }
        System.out.println();
    }

    public void showWinners(List<String> winners) {
        System.out.printf("최종 우승자 : %s", String.join(", ", winners));
    }

}
