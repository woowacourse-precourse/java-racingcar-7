package racingcar.controller;

import racingcar.service.RaceService;
import racingcar.util.Converter;
import racingcar.view.InputView;

import java.util.List;

public class Controller {

    private final InputView inputView = new InputView();
    private final Converter converter = new Converter();
    private final RaceService raceService = new RaceService();

    public void run() {
        String inputCarList = inputView.inputCarList();
        String inputTryCnt = inputView.inputTryCnt();
        List<String> carList = converter.parseCarList(inputCarList);
        int tryCnt = converter.convertTryCnt(inputTryCnt);

        // 테스트용
        for (String car : carList) {
            System.out.println(car);
        }

        System.out.println("시도할 횟수: " + tryCnt);
    }
}
