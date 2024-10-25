package racingcar.view;

import java.util.List;
import racingcar.domain.RacingCarStatus;

public class OutputView {

    public static void printCarNamesInputMessage() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public static void printCountInputMessage() {
        System.out.println("시도할 횟수는 몇 회인가요?");
    }

    public static void printResultMessage() {
        System.out.println("실행 결과");
    }

    public static void printWinners(List<String> winners) {
        System.out.print("최종 우승자 : ");
        if(winners.size()==1){
            System.out.println(winners.getFirst());
            return;
        }
        System.out.println(String.join(", ", winners));
    }

    public static void printRacingCarsStatus(List<RacingCarStatus> racingCarsStatus) {
        for(RacingCarStatus carStatus : racingCarsStatus) {
            System.out.println(carStatus);
        }
        System.out.println();
    }
}
