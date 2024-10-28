package racingcar.controller;

import java.util.List;
import racingcar.utils.RacingUtils;
import racingcar.dto.InputDto;
import racingcar.model.Car;
import racingcar.view.RacingView;

public class Controller {
    private final RacingView racingView;

    public Controller(RacingView racingView) {
        this.racingView = racingView;
    }

    public void doRacing(InputDto inputDto) {
        List<Car> carList = RacingUtils.carNamesToCarList(inputDto.getCarNames());

        String winners = runRace(carList, inputDto.getRepeatCount());

        racingView.printWinners(winners);
    }

    private String runRace(List<Car> carList, int repeatCount) {
        System.out.println("실행 결과");
        while (repeatCount > 0) {
            for (final Car car : carList) {
                car.go();
            }

            System.out.println();
            repeatCount--;
        }

        List<Car> winnerCarList = RacingUtils.getWinnerCarList(carList);
        return RacingUtils.carListToString(winnerCarList);
    }
}
