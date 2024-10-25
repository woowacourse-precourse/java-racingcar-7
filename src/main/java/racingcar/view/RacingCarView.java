package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import racingcar.model.RacingCarSnapShot;

public class RacingCarView {

    public List<String> getRacingCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        return List.of(input.split(","));
    }

    public int getAttemptCount() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        String input = Console.readLine();
        return convertToNumber(input);
    }

    private int convertToNumber(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자를 입력해주세요.");
        }
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
