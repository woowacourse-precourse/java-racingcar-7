package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InputHandler {

    public List<String> getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)");
        String cars = Console.readLine();
        return Arrays.stream(cars.split(",")).map(String::trim).toList();
    }

    public int getRaceAttemptCount() {
        System.out.println("시도할 횟수를 입력하세요.");
        String attempt = Console.readLine();
        return Integer.parseInt(attempt); // String을 int로 변환
    }

    public List<Car> initializeCars(List<String> carNames){
        List<Car> cars = new ArrayList<>();

        for (String name : carNames){
            //TODO 유효성 검사 필요

            cars.add(new Car(name));

        }

        return cars;
    }

}
