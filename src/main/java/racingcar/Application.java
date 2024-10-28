package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {

        try {
            System.out.println("경주할 자동차 이름을 입력하세요. 이름은 쉼표(,) 기준으로 구분됩니다");
            String input = Console.readLine();

            for (String name : input.split(",")) {
                Car newCar = new Car(name.trim());
                System.out.println(newCar);
            }
        } catch (IllegalArgumentException e) {
            System.out.println("입력 오류: " + e.getMessage());
        }

    }
}

