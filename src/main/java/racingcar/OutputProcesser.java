package racingcar;

import java.util.List;

public class OutputProcesser {

    // 차수별 실행 결과 출력
    public void printRaceResult(List<Car> cars) {

        for (int i = 0; i < cars.size(); i++) {
            String distanceBar = "-".repeat(cars.get(i).getDistance());
            System.out.println(cars.get(i).getName() + " : " + distanceBar);
        }
        System.out.println();
    }

    // 우승자 출력
    public void printWinners(String winnerNames) {
        System.out.println("최종 우승자 : " + winnerNames);
    }

}
