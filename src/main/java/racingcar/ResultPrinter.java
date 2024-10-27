package racingcar;

import java.util.ArrayList;
import java.util.List;

public class ResultPrinter {
    // 우승자 출력 메소드
    public static void printWinner(Car[] cars) {
        List<String> winners = findWinner(cars); // 우승자 배열 반환
        System.out.print("최종 우승자 : ");
        System.out.println(String.join(", ", winners)); // 콤마로 구분하여 출력
    }

    // 우승자 추출 메소드
    public static List<String> findWinner(Car[] cars) {
        // 최대 대시("-") 개수를 찾기 위한 변수
        int maxDashCount = 0;

        // 우승자 저장을 위한 리스트
        ArrayList<String> winnersList = new ArrayList<>();

        // 최대 대시("-") 개수 찾기
        for (Car car : cars) {
            if (car.dashCount > maxDashCount) {
                maxDashCount = car.dashCount;   // 대시("-")의 개수가 많은 것을 대시 최대값으로 저장
            }
        }

        // 최대 대시 개수에 해당하는 자동차 이름을 우승자 리스트에 저장
        for (Car car : cars) {
            if (car.dashCount == maxDashCount) {
                winnersList.add(car.getName());
            }
        }

        // 우승자 리스트 반환
        return winnersList;
    }
}