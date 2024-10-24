package racingcar;

import camp.nextstep.edu.missionutils.Console;
import racingcar.car.Cars;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNames = Console.readLine();
        Cars cars = new Cars(carNames);

        System.out.println("시도할 횟수는 몇 회인가요?");
        String numberOfRaces = Console.readLine();
        int raceNumbers = Integer.parseInt(numberOfRaces);

        System.out.println("실행 결과");
        for (int i = 0; i < raceNumbers; i++) {
            cars.raceStart();
            System.out.println();
        }
    }
}
