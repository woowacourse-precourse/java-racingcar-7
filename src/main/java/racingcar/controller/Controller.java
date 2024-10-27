package racingcar.controller;

import racingcar.model.Car;
import racingcar.model.RaceService;
import racingcar.util.Converter;
import racingcar.view.InputView;

import java.util.ArrayList;
import java.util.List;

public class Controller {

    private final InputView inputView = new InputView();
    private final Converter converter = new Converter();
    private final RaceService raceService = new RaceService();

    public void run() {
        List<Car> carList = createCarList();
        String inputTryCnt = inputView.inputTryCnt();
        int tryCnt = converter.convertTryCnt(inputTryCnt);

        // 테스트용
        for (Car car : carList) {
            System.out.println(car.getName());
        }

        System.out.println("시도할 횟수: " + tryCnt);
    }

    private List<Car> createCarList() {
        String inputCarList = inputView.inputCarList();
        String[] carNameList = converter.parseCarList(inputCarList);
        return convertToCar(carNameList);
    }

    private List<Car> convertToCar(String[] carNameList) {
        List<Car> carList = new ArrayList<>();
        for (String carName : carNameList) {
            Car car = new Car(carName);
            carList.add(car);
        }

        return carList;
    }
}
