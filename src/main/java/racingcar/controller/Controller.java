package racingcar.controller;

import java.util.List;
import racingcar.TypeConvertUtils;
import racingcar.dto.InputDto;
import racingcar.model.Car;
import racingcar.view.RacingView;

public class Controller {
    private final RacingView racingView;

    public Controller(RacingView racingView) {
        this.racingView = racingView;
    }

    public void doRacing(InputDto inputDto) {
        List<Car> carList = TypeConvertUtils.stringToCarList(inputDto.getCarNames());

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

        List<Car> winnerCarList = getWinnerList(carList);
        return TypeConvertUtils.carListToString(winnerCarList);
    }

    private int getWinnerLocation(List<Car> carList) {
        return carList.stream()
                .mapToInt(Car::getLocation)
                .max()
                .getAsInt();
    }

    private List<Car> getWinnerList(List<Car> carList) {
        int winnerLocation = getWinnerLocation(carList);

        return carList.stream()
                .filter(car -> car.getLocation() == winnerLocation)
                .toList();
    }

}
