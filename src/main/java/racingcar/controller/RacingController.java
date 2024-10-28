package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import racingcar.model.Car;
import racingcar.view.RacingView;
import racingcar.service.RacingService;

public class RacingController {
    private final RacingView view = new RacingView();
    private List<Car> cars = new ArrayList<>();
    private RacingService service;

    public void start() {
        String names = view.inputNames();
        setCarList(names);

        service = new RacingService(cars);

        String countInput = view.inputCount();
        int tryCount = parseCount(countInput);

        for (int i = 0; i < tryCount; i++) {
            service.moveCars();
            view.printCars(cars);
        }

        view.printWinners(service.getWinner());
    }

    public void setCarList(String names) {
        for (String name : names.split(",")) {
            if (isValidName(name)) {
                cars.add(new Car(name));
            }
        }
    }

    public boolean isValidName(String name) {
        if (name.isEmpty() || name.length() > 5) {
            throw new IllegalArgumentException("잘못된 자동차 이름 입니다.");
        }
        return true;
    }
    public int parseCount(String countInput) {
        try {
            return Integer.parseInt(countInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("잘못된 시도 횟수 입니다.");
        }
    }
}
