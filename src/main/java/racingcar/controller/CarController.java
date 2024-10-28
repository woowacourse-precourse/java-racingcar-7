package racingcar.controller;

import racingcar.domain.Car;
import racingcar.service.CarCountService;
import racingcar.service.CarGameService;
import racingcar.service.CarNameService;

import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class CarController {
    private final CarNameService carNameService = new CarNameService();
    private final CarCountService carCountService = new CarCountService();
    private final CarGameService carGameService = new CarGameService();

    public void run() {
        System.out.println("경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분");
        List<Car> carNames = carNameService.getNamesFromString(readLine());

        System.out.println("시도할 횟수는 몇 회인가요?");
        int tryCount = carCountService.getTryCountFromString(readLine());

        System.out.println();

        System.out.println("실행 결과");
        String result = carGameService.playGames(carNames, tryCount);

        System.out.print("최종 우승자 : ");
        System.out.print(result);
    }

}
