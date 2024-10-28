package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {

        try {
            System.out.println("경주할 자동차 이름을 입력하세요. 이름은 쉼표(,) 기준으로 구분됩니다");
            String input = Console.readLine();
            List<Car> cars = new ArrayList<>();

            for (String name : input.split(",")) {
                Car newCar = new Car(name.trim()); // 문자열 시작과 끝의 공백을 제거
                cars.add(newCar);
            }

            Game game = new Game(cars); // 게임 시작
            
        } catch (IllegalArgumentException e) {
            System.out.println("입력 오류: " + e.getMessage());
        }

    }
}

