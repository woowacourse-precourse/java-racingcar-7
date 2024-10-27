package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import racingcar.model.Car;
import racingcar.view.RacingCarView;

public class Application {
    // 입력
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        RacingCarView carView = new RacingCarView();

        String carNameInput = carView.getCarNameInput();
        int tryCount = Integer.parseInt(carView.getTryCount());

        String[] cars = carNameInput.split(",");
        for(String car : cars) {
            System.out.println("여기:" + car + "사이즈 : " + car.length());
        }
        System.out.println(cars.length);

    }
}
