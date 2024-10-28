package racingcar.view;

import java.util.List;
import racingcar.service.collection.RacingCar;

public class OutputView {
    // 게임 차수 별 진행상황 출력 메서드
    public void printPerDegreeResult(RacingCar racingCar) {
        final List<String> allRacingCarName = racingCar.getAllRacingCarName();

        for (String eachRacingCarName : allRacingCarName) {
            int nowCarPosition = racingCar.getRacingCarPosition(eachRacingCarName);
            System.out.println(eachRacingCarName + " : " + ("-".repeat(nowCarPosition)));
        }
    }

    public void printWinners(List<String> winningCars) {
        String result = winningCars.get(0);

        if (winningCars.size() == 1) {
            System.out.println("최종 우승자 : " + result);
            return;
        }

        for (int i = 1; i < winningCars.size(); i++) {
            result += ", " + winningCars.get(i);
        }
        System.out.println("최종 우승자 : " + result);
    }
}
