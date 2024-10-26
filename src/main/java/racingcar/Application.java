package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {

        System.out.println("자동차의 수를 입력해주세요");
        int countCars = Integer.parseInt(Console.readLine());

        System.out.println("자동차의 이름을 쉼표(.)로 구분해 입력해주세요 (5자 이하)");
        String[] carNames = (Console.readLine()).split(",");

        if (carNames.length() != countCars) {
            throw new IllegalArgumentException("자동차의 수와 이름의 개수가 일치하지 않습니다");
        }

        Car[] cars = new Car[countCars];

        for (int i=0; i < countCars; i++) {

            if (carNames[i].length() > 5) {
                throw new IllegalArgumentException(carNames[i] + ": 5자 이하여야 합니다");
            }

            cars[i] = new Car(carNames[i].trim());
        }










    }
}
