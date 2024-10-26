package racingcar.service;

import racingcar.entity.Car;

import java.util.ArrayList;
import java.util.List;

public class WinnerPrinter {

    public void printWinner(List<Car> carList) {
        int maxLength = 0;

        // 최고 길이를 가진 자동차를 저장할 리스트
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
        for (Car winner : winners) {
            System.out.println(winner.getName()); // 각 우승자의 이름 출력
        }
    }
}
