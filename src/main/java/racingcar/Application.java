package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)\n");
        String carInput = Console.readLine();

        if (carInput == null) {
            throw new IllegalArgumentException("자동차 이름을 입력해주세요.\n");
        }

        String[] cars = carInput.split(",", -1);

        for (String car : cars) {
            car = car.trim();

            if (car.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하로 입력해주세요.\n");
            }
        }
        if (cars.length > 10) {
            throw new IllegalArgumentException("자동차는 10개 이하로 입력해 주세요.\n");
        }
    }
}