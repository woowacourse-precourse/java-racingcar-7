package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;


public class Application {
    public static void main(String[] args) {
        // TODO:
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String string = Console.readLine();
        String[] carList = string.split(",");
        List<RacingCar> racingCars = new ArrayList<>();

        for (String carName : carList) {
            RacingCar newRacingCar = new RacingCar(carName);
            racingCars.add(newRacingCar);
        }

        System.out.println("시도할 횟수는 몇 회인가요?");
        String cycle = Console.readLine();
    }
}
