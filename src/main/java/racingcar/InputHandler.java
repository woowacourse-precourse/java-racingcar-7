package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InputHandler {

    public List<String> getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        String[] names = input.split(",");


        // 각 이름의 유효성 검사
        for (String name : names) {
            validateCarName(name);
        }

        return List.of(names);
    }

    public int getRaceAttemptCount() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        String attempt = Console.readLine();
        return Integer.parseInt(attempt); // String을 int로 변환
    }

    public List<Car> initializeCars(List<String> carNames){
        List<Car> cars = new ArrayList<>();

        for (String name : carNames){
            cars.add(new Car(name));

        }

        return cars;
    }

    // 자동차 이름 유효성 검사 메서드
    private void validateCarName(String carName) {
        if (carName.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5자를 초과할 수 없습니다: " + carName);
        }
    }

}
