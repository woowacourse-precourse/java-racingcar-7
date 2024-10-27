package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.util.Converter;
import racingcar.view.InputView;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RaceService {

    private final Converter converter = new Converter();
    private final InputView inputView = new InputView();

    public List<Car> createCarList() {
        String inputCarList = inputView.inputCarList();
        String[] carNameList = parseCarNames(inputCarList);
        return convertToCarList(carNameList);
    }

    public int getTryCount() {
        String inputTryCnt = inputView.inputTryCnt();
        return converter.convertTryCnt(inputTryCnt);
    }

    private String[] parseCarNames(String inputCarList) {
        return converter.parseCarList(inputCarList);
    }

    private List<Car> convertToCarList(String[] carNameList) {
        return Arrays.stream(carNameList)
                .map(Car::new)
                .collect(Collectors.toList());
    }

    private int pickRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }
}
