package racingcar;

import java.util.ArrayList;
import java.util.List;

public class GameResult {
    // 게임의 결과 과정 처리, 라운드 출력, 우승자 결정
    static void printRoundResult(List<Car> cars) {
        // 각 라운드 결과 출력
        for (Car car : cars) {
            System.out.println(car.getName() + " : " + "-".repeat(car.getCount()));
        }
        System.out.println();
    }

    static int findMaxPoint(List<Car> cars) {
        // 가장 멀리간 점수 찾기
        int maxPoint = 0;
        for (Car car : cars) {
            if (car.getCount() > maxPoint) {
                maxPoint = car.getCount();
            }
        }

        return maxPoint;
    }

    static void printWinners(List<Car> cars) {
        // 최종 우승자 출력
        int maxPoint = findMaxPoint(cars);
        List<Car> winners = getWinners(cars, maxPoint);     // 최대 점수만큼 이동한 자동차 확인
        showWinners(winners);   // 우승자 출력
    }

    static List<Car> getWinners(List<Car> cars, int maxPoint) {
        // 최대 점수와 같은 자동차 찾기
        List<Car> winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.getCount() == maxPoint) {
                winners.add(car);   // 우승자
            }
        }

        return winners;
    }

    static void showWinners(List<Car> winners) {
        // 우승자 출력 과정
        List<String> names = new ArrayList<>();
        for (Car car : winners) {
            names.add(car.getName());   // 우승자 이름 추가
        }

        String result = String.join(", ", names);
        System.out.println("최종 우승자 : " + result);
    }
}
