package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {

        List<String> carNameList; // 자동차 이름을 입력 받는 List
        int tryCount;

        List<Car> carList = new ArrayList<>(); // Car 객체를 입력 받는 List
        InputView inputView = new InputView();
        RaceWinner raceWinner = new RaceWinner();
        OutputView outputView = new OutputView(raceWinner);

        carNameList = inputView.createCars();

        for (String name: carNameList) {
            carList.add(new Car(name));
        }
        tryCount = inputView.tryCount();

        outputView.startGame(carList, tryCount);
    }
}
