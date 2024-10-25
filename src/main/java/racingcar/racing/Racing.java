package racingcar.racing;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.car.Car;
import racingcar.view.Request;
import racingcar.view.Response;


public class Racing {

    private static final String CAR_NAME_DELIMITER = ",";
    private static final int MAX_CAR_NAME = 5;
    private static final int FORWARD_CONDITION = 4;

    private List<Car> carList;
    private int tryCount;

    public void start() {
        List<String> carNameList = inputCars();
        validateCars(carNameList);
        createCars(carNameList);
        inputTryCount();
        Response.outputStart();
        race();
        Response.outputFinalWinner(selectWinners());
    }

    public List<String> inputCars() {
        String carNames = Request.inputCar();
        return List.of(carNames.split(CAR_NAME_DELIMITER));
    }

    public void validateCars(List<String> carNameList) {
        for (String name : carNameList) {
            if (name.length() > MAX_CAR_NAME) {
                throw new IllegalArgumentException("자동차 이름이 5자를 넘습니다.");
            }
        }
    }

    public void createCars(List<String> carNameList) {
        carList = carNameList.stream()
                .map(Car::new)
                .collect(Collectors.toList());
    }

    public void inputTryCount() {
        String tryCountString = Request.inputTryCount();
        tryCount = Integer.parseInt(tryCountString);
    }

    public void race() {
        for (int count = 0; count < tryCount; count++) {
            forwardCars();
            Response.outputExecute(carList);
        }
    }

    public void forwardCars() {
        for (Car car : carList) {
            if (FORWARD_CONDITION <= Randoms.pickNumberInRange(0, 9)) {
                car.addForward();
            }
        }
    }

    public List<Car> selectWinners() {
        List<Car> winners = new ArrayList<>();
        int winCount = 0;

        for(Car car : carList) {
            int forward = car.getForward();

            if (forward == winCount) {
                winners.add(car);
            }

            if (forward > winCount) {
                winCount = car.getForward();
                winners.clear();
                winners.add(car);
            }
        }

        return winners;
    }

}
