package racingcar.io;

import racingcar.racing.Car;

import java.util.List;

public class Output {
    public void printRaceResult(Car[] cars){
        for (Car car : cars) {
            System.out.print(car.getName() + " : ");
            for (int i = 0; i < car.getPosition(); i++) {
                System.out.print("-");
            }
            System.out.println();  // 각 자동차 결과 후 줄바꿈 추가
        }
        System.out.println();  // 모든 자동차의 결과 출력 후 추가 줄바꿈
    }

    public void printWinner(List<String> winners){
        System.out.print("최종 우승자 : ");
        for (String winner : winners) {
            System.out.print(winner);
            if(!winner.equals(winners.get(winners.size() - 1))) {
                System.out.print(", ");
            }
        }
    }
}
