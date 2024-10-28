package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import racingcar.car.Cars;
import racingcar.validator.InputValidator;

public class Application {
    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String strPlayer = Console.readLine();
        InputValidator.validatePlayer(strPlayer);

        System.out.println("시도할 횟수는 몇 회인가요?");
        String strRound = Console.readLine();
        InputValidator.validateRound(strRound);
        int totalRound = Integer.parseInt(strRound);

        Cars cars = new Cars(strPlayer.split(","));

        System.out.println("\n실행 결과");
        for (int round = 0; round < totalRound; round++) {
            cars.run();
            List<String> results = cars.getResults();
            results.forEach(System.out::println);
            System.out.println();
        }

        String winner = cars.getWinners();
        System.out.println("최종 우승자 : " + winner);
    }
}
