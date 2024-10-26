package racingcar.service;

import java.util.List;
import racingcar.dto.CarNameRequest;
import racingcar.dto.TryNumberRequest;
import racingcar.model.Car;
import racingcar.view.OutputView;

public class CarRacingGameService {

    public void startRacing(CarNameRequest carNameRequest, TryNumberRequest tryNumberRequest) {
        int round = tryNumberRequest.tryNumber();
        List<Car> carList = carNameRequest.carNameList().stream()
                .map(Car::of)
                .toList();

        OutputView.printRacingResultMessage();
        playRound(carList, round);

    }

    private void playRound(List<Car> carList, int round) {
        for(int i=0; i<round; i++) {
            carList.forEach(Car::move);
            OutputView.printRacingResult(carList);
        }
    }

}
