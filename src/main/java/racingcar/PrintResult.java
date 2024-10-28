package racingcar;

import java.util.ArrayList;
import java.util.List;

public class PrintResult {

    // 현재 각 자동차의 위치를 출력
    public static void printRaceResult(List<Car> cars) {
        for (Car car : cars) {
            System.out.print(car.getName() + " : ");
            for (int i = 0; i < car.getPosition(); i++) {
                System.out.print("-");
            }
            System.out.println();
        }
        System.out.println();
    }

    //최종 우승자
    public static void printWinners(List<Car> cars) {
        int maxPosition = 0;
        for(Car car : cars){
            if(maxPosition<car.getPosition()) maxPosition= car.getPosition();
        }
        List<String> winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.getPosition() == maxPosition) {
                winners.add(car.getName());
            }
        }
        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }


}
