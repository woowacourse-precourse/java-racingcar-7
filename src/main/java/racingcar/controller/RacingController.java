package racingcar.controller;

import java.util.List;
import racingcar.service.Cars;
import racingcar.view.InputView;

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
        }

        // 최종 우승자 출력

    }
}
