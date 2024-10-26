package racingcar.service;

import racingcar.entity.Car;

import java.util.ArrayList;
import java.util.List;

public class WinnerPrinter {

    public void printWinner(List<Car> carList) {
        int maxLength = 0;
        StringBuilder winnerNames = new StringBuilder();

        List<Car> winners = new ArrayList<>();

        // 모든 자동차의 도로 길이를 비교
        for (Car car : carList) {
            int roadLength = car.getRoad().getRoad(); // Car 객체의 Road 길이 가져오기

            // 새로운 최대 길이를 찾은 경우
            if (roadLength > maxLength) {
                maxLength = roadLength; // 최대 길이 갱신
                winners.clear(); // 이전의 우승자 리스트 비우기
                winners.add(car); // 새로운 우승자 추가
            } else if (roadLength == maxLength) {
                winners.add(car); // 현재 길이가 최대와 같다면 우승자 리스트에 추가
            }
        }

        // 우승자 출력
        System.out.print("Winner(s):");
        for (int i = 0; i < winners.size(); i++) {
            winnerNames.append(winners.get(i).getName());
            if (i < winners.size() - 1) { // 마지막 이름이 아닐 경우에만 쉼표 추가
                winnerNames.append(", ");
            }
        }
        System.out.println(winnerNames); // 모든 우승자 이름 출력
    }
}
