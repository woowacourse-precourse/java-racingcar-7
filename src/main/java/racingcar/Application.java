package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNames = Console.readLine();

        List<RacingCar> carList = new ArrayList<>();
        for (String carName : carNames.split(",")) {
            carList.add(new RacingCar(carName));
        }

        System.out.println("시도할 횟수는 몇 회인가요?");
        int numberOfAttempts = Integer.parseInt(Console.readLine());

        System.out.println("\n실행 결과");
        RacingGame racingGame = new RacingGame(carList, numberOfAttempts);
        racingGame.startRace();

        Console.close();
    }
}
