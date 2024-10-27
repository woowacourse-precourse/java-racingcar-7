package racingcar.io;

import racingcar.Car;
import racingcar.RaceCars;

import java.util.List;

public class OuputHandler {

    public void askRaceCarsNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public void askRaceCount() {
        System.out.println("시도할 횟수는 몇 회인가요?");
    }

    public void showExecutionResult(int raceCount, RaceCars raceCars) {
        System.out.println("실행 결과");
        showExecutionResultByRound(raceCars, raceCount);
    }

    public void showFinalWinner(List<String> finalWinners) {
        System.out.print("최종 우승자 : ");

        if (finalWinners.size() == 1) {
            System.out.println(finalWinners.get(0));
        } else {
            System.out.println(String.join(", ", finalWinners));
        }
    }

    private void showExecutionResultByRound(RaceCars raceCars, int raceCount) {
        for (int round = 0; round < raceCount; round++) {
            showRaceRecordsByCars(raceCars, round);
            System.out.println();
        }
    }

    private void showRaceRecordsByCars(RaceCars raceCars, int round) {
        for (int index = 0; index < raceCars.size(); index++) {
            Car car = raceCars.getCarByIndex(index);
            car.showRaceRecordsByRound(round);
        }
    }
}