package racingcar;

import camp.nextstep.edu.missionutils.Console;
import racingcar.car.Cars;
import racingcar.validator.InputValidator;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String strPlayer = Console.readLine();
        InputValidator.validatePlayer(strPlayer);

        System.out.println("시도할 횟수는 몇 회인가요?");
        String strRound = Console.readLine();
        InputValidator.validateRound(strRound);
        int round = Integer.parseInt(strRound);

        Cars cars = new Cars(strPlayer.split(","));

        System.out.println("\n실행 결과");
        while (round > 0) {
            cars.run();
            System.out.println();

            round--;
        }

        String winner = cars.getWinners();
        System.out.println("최종 우승자 : " + winner);
    }
}
