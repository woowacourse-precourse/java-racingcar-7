package racingcar.controller;

import java.util.Arrays;
import java.util.List;
import racingcar.service.Cars;
import racingcar.view.InputView;
import java.util.Map;

public class RacingController {
    public void start() {
        // 입력 받기
        List<String> carNames = InputView.getCarNames();
        int tryTime = InputView.getTryTime();

//        System.out.println(carNames);
//        System.out.println(tryTime);

        // 자동차 설정
        Cars cars = new Cars(carNames, tryTime);

//        List<Car> carList = cars.getCars();
//        System.out.println(carList);

        System.out.println("실행 결과");

        // tryTime만큼 반복
        while (!cars.getTryTime()) {
            cars.moveAllCar();
            printScores(cars.getCarInfo());
        }

        // 최종 우승자 출력
        System.out.printf("최종 우승자 : %s", String.join(", ", cars.findWinner()));
    }
    public static void printScores(Map<String, Integer> scores) {
        scores.forEach((key, value) -> {
            System.out.printf("%s : %s", key, "-".repeat(value));
            System.out.println();
        });
        System.out.println();
    }


}
