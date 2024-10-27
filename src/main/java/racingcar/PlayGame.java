package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class PlayGame {
    public void setTryNumber(Car[] cars, int count) {
        for (Car car : cars) {
            car.tryNumber = Randoms.pickNumberInRange(0, 9); // 각 자동차에 시도 횟수 설정

            // tryNumber가 4 이상일 경우 advance에 "-" 추가
            if (car.tryNumber >= 4) {
                advance(car, car.tryNumber);
            }
        }
    }

    public void advance(Car car, int tryNumber) {
        for (int i = 0; i < tryNumber; i++) {
            car.advance.append("-"); // 기존 전진 상태에 "-"를 추가하여 누적
        }
    }

    public void printAdvanceArrays(Car[] cars) {
        for (Car car : cars) {
            System.out.print(car.name +" : ");
            System.out.println(car.advance.toString()); // 누적된 전진 상태 출력
        }
    }
    public String findWinners(Car[] cars) {
        int maxDistance = 0;
        List<String> winners = new ArrayList<>();

        for (Car car : cars) {
            int distance = car.advance.length();
            if (distance > maxDistance) {
                maxDistance = distance;
                winners.clear(); // Clear previous winners
                winners.add(car.name);
            } else if (distance == maxDistance) {
                winners.add(car.name);
            }
        }
        return String.join(", ", winners);
    }
}
