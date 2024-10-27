package racingcar;

import java.util.ArrayList;
import java.util.List;

public class ResultHandler {



    public void printRoundResult(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.getName() + " : " + "-".repeat(car.getPosition()));
        }
        System.out.println();
    }


    // 우승자를 구하는 메서드
    public List<Car> getWinners(List<Car> cars) {
        int maxPos = 0;
        List<Car> winners = new ArrayList<>();

        // 최고 위치를 구함
        for (Car car : cars) {
            if (car.getPosition() > maxPos) {
                maxPos = car.getPosition();
            }
        }

        // 최고 위치에 있는 모든 자동차를 우승자로 추가
        for (Car car : cars) {
            if (car.getPosition() == maxPos) {
                winners.add(car);
            }
        }

        return winners;
    }

    // 최종 우승자 출력
    public void printWinners(List<Car> winners) {
        StringBuilder result = new StringBuilder("최종 우승자 : ");

        for (int i = 0; i < winners.size(); i++) {
            result.append(winners.get(i).getName());
            if (i < winners.size() - 1) {
                result.append(", ");
            }
        }

        System.out.println(result);
    }
}
