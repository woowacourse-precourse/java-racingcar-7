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
            printRaceResult(carList);
        }
        System.out.println();

        // 모든 라운드가 끝난 후 우승자 찾기
        List<String> winners = getWinners(carList);
        printWinners(winners);
    }

    private void raceRound(List<Car> carList) {
        for (Car car : carList) {
            if (pickRandomNumber() >= 4)
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

    private void printRaceResult(List<Car> carList) {
        for (Car car : carList) {
            System.out.println(car.getName() + " : " + "-".repeat(car.getDistance()));
        }
        // 라운드 간 간격을 위한 빈 줄 출력
        System.out.println();
    }

    private void printWinners(List<String> winners) {
        System.out.println("최종 우승자 : " + String.join(", ", winners));
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

    private boolean goStraight(int num) {
        if (num >= 4)
            return true;
        return false;
    }
}
