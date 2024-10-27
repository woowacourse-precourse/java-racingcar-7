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

    public void startRace(List<Car> carList, int tryCnt) {
        System.out.println("실행 결과");
        for (int i = 0; i < tryCnt; i++) {
            raceRound(carList);
        }
        System.out.println();
    }

    private void raceRound(List<Car> carList) {
        for (Car car : carList) {
            System.out.println(car.getName() + " 이(가) 뽑은 숫자는 : " + pickRandomNumber());
        }
        // 라운드 별 구분
        System.out.println();
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
