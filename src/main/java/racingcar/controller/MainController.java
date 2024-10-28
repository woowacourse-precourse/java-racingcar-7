package racingcar.controller;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.List;
import racingcar.service.CarService;

public class MainController {
    private static final CarService carService = new CarService();

    public static void run() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름을 쉼표(,) 기준으로 구분");
        CarController.saveCarNames();
        System.out.println("시도할 횟수는 몇 회인가요?");
        int repeat = Integer.parseInt(readLine());
        System.out.println();

        System.out.println("실행 결과");
        for (int i = 1; i <= repeat; i++) {
            carService.moveCars();
            carService.printCarsStatus();
            System.out.println();
        }
        List<String> winnerList = carService.findWinners();
        String winner = String.join(", ", winnerList);
        System.out.println("최종 우승자 : " + winner);

    }
}
