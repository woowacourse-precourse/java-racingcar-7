package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.util.Constants;
import racingcar.util.Converter;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RaceService {

    private final Converter converter = new Converter();
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

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
            outputView.printRaceResult(carList);
        }

        // 모든 라운드가 끝난 후 우승자 찾기
        List<String> winners = getWinners(carList);
        outputView.printWinners(winners);
    }

    private void raceRound(List<Car> carList) {
        for (Car car : carList) {
            if (pickRandomNumber() >= Constants.MOVE_NUM)
                car.move();
        }
    }

    private List<String> getWinners(List<Car> carList) {
        int maxDistance = carList.stream()
                .mapToInt(Car::getDistance)
                .max()
                .orElse(0);

        return carList.stream()
                .filter(car -> car.getDistance() == maxDistance)
                .map(Car::getName)
                .collect(Collectors.toList());
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
        return Randoms.pickNumberInRange(Constants.MIN_RANDOM_NUM, Constants.MAX_RANDOM_NUM);
    }

}
