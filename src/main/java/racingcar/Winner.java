package racingcar;

import java.util.List;
import java.util.ArrayList;

public class Winner {
    public static void FindWinner(List<Car> carList) {
        List<String> winners = new ArrayList<>();
        // 최고 위치 초기화
        int TopPosition = 0;

        // 최고 위치 값 찾기
        for (Car car : carList) {
            if (car.GetCarPosition() > TopPosition) {
                TopPosition = car.GetCarPosition();
            }
        }

        // 최고 위치의 자동차들 목록에 추가
        for (Car car : carList) {
            if (car.GetCarPosition() == TopPosition) {
                winners.add(car.GetCarName());
            }
        }

        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }
}
