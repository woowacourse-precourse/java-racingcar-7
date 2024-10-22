package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        RacingCar racingCar = new RacingCar();
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분");
        String inputString = Console.readLine();
        String[] racingCars = racingCar.separateCarNames(inputString);

        System.out.println("시도할 횟수는 몇 회인가요?");
        String inputString2 = Console.readLine();
        int NumberOfAttempts = racingCar.validateNumberOfAttempts(inputString2);
        racingCar.race(NumberOfAttempts);
    }
}
