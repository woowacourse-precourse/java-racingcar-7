package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분");
        String carNames = Console.readLine();

        Car[] cars = separateNames(carNames);




    }

    public static Car[] separateNames(String carNames) {

        String[] names = carNames.split(",");
        Car[] cars = new Car[names.length];

        /*
         * 자동차 이름에 대해 자동차 객체 생성
         */

        return cars;
    }
}
