package racingcar.view;

import racingcar.model.Car;

import java.util.List;

public class RaceGameOutputView {

    public static void printRaceProgress(List<Car> cars) {
        // 각 자동차의 이름과 현재 위치에 따른 하이픈을 출력
        for (Car car : cars) {
            // 자동차 이름과 현재 위치에 맞춰 하이픈을 출력
            System.out.println(car.getName() + " : " + "-".repeat(Math.max(0, car.getPosition())));
        }
        System.out.println();
    }


    public static void printWinners(List<Car> winners) {
        StringBuilder winnerNames = new StringBuilder();
        for (int i = 0; i < winners.size(); i++) {
            winnerNames.append(winners.get(i).getName());
            if (i < winners.size() - 1) {
                winnerNames.append(", ");
            }
        }
        System.out.println("최종 우승자 : " + winnerNames);
    }
}
