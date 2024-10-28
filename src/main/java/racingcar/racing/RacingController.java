package racingcar.racing;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.car.Car;
import racingcar.car.CarValidator;
import racingcar.view.Request;
import racingcar.view.Response;


public class RacingController {

    private List<Car> carList;
    private int tryCount;
    private List<Car> winners = new ArrayList<>();


    public void start(List<Car> carList) {
        this.carList = carList;
        inputTryCount();
        Response.outputStart();
        race();
        getWinners();
        Response.outputFinalWinner(winners);
    }

    private void inputTryCount() {
        String tryCountString = Request.inputTryCount();
        validateTryCount(tryCountString);
        tryCount = Integer.parseInt(tryCountString);
    }

    private void validateTryCount(String tryCountString) {
        RacingValidator.tryCountEmpty(tryCountString);
        RacingValidator.tryCountParseInteger(tryCountString);
    }

    private void race() {
        for (int count = 0; count < tryCount; count++) {
            carList.forEach(Car::forward);
            Response.outputExecute(carList);
        }
    }

    private void getWinners() {
        int maxFront = 0;
        for(Car car : carList) {
            int forward = car.getForward();

            if (forward == maxFront) {
                winners.add(car);
            }

            if (forward > maxFront) {
                maxFront = car.getForward();
                winners.clear();
                winners.add(car);
            }
        }
    }

}
