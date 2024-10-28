package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.model.RacingCars;

public class RacingGameView {
    public void printCarNamesInputMessage() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public void printAttemptCountInputMessage() {
        System.out.println("시도할 횟수는 몇 회인가요?");
    }

    public void printRacingResultStart() {
        System.out.println("\n실행 결과");
    }

    public void printRacingResult(RacingCars racingCars) {
        racingCars.forEach(racingCar ->
            System.out.println(
                racingCar.getName() + " : " + "-".repeat(racingCar.getMoveCount())
            )
        );
        System.out.println();
    }

    public void printWinners(String winners) {
        System.out.println("최종 우승자 : " + winners);
    }

    public String getInput() {
        return Console.readLine();
    }
}
