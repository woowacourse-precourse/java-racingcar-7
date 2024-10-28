package racingcar.controller;

import racingcar.model.Car;
import racingcar.model.CarRace;
import racingcar.model.RaceInfo;
import racingcar.view.InputView;
import racingcar.view.OutputView;
import racingcar.view.dto.RaceResult;

import java.util.ArrayList;
import java.util.List;

public class CarRaceController {
    private final InputView inputView;
    private final OutputView outputView;
    private CarRace carRace;

    public CarRaceController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    private RaceInfo getRaceInfo(){
        outputView.printNoticeStatementName();
        List<String> names = inputView.getNames();
        outputView.printNoticeStatementCnt();
        String totalTtyCnt = inputView.getTotalTtyCnt();
        return new RaceInfo(names, totalTtyCnt);
    }

    private List<String> getWinner(List<Car> cars) {
        List<String> winners = new ArrayList<>();

        long maxPosition = cars.stream()
                .mapToLong(Car::getPosition)
                .max()
                .orElse(0);

        for (Car car : cars) {
            if (car.getPosition() == maxPosition) {
                winners.add(car.getName());
            }
        }

        return winners;
    }


}
