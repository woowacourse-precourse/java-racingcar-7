package racingcar.view;

import racingcar.domain.Car;
import racingcar.service.RacingCarService;

public class OutputView {

    public void printStartMessage() {
        System.out.println("실행 결과");
    }

    public void printRacingProcess(RacingCarService racingCarService) {
        for (Car car : racingCarService.getCars().getCars()) {
            System.out.println(car.getName().toString() + " : " + "-".repeat(car.getPosition().getValue()));
        }
        System.out.println();
    }

    public void printWinners(RacingCarService racingCarService) {
        System.out.println("최종 우승자 : " + String.join(", ", racingCarService.findWinnersName()));
    }
}
