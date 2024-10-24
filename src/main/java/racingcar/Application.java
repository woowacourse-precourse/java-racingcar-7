package racingcar;

import java.util.ArrayList;
import java.util.List;
import model.Car;
import view.ConsoleView;

public class Application {
    public static void main(String[] args) {

        // 1. 입력 & 2. 구분
        ConsoleView consoleView = new ConsoleView();
        List<String> carNames = consoleView.getCarNames();
        int moveCount = consoleView.getMoveCount();

        // 3. 자동차 객체 생성
        List<Car> Cars = new ArrayList<>(carNames.size());
        for (String name : carNames) {
            Cars.add(new Car(name));
        }

        // 4. 전진하기
        for (Car car : Cars) {
            car.move();
        }

        // TODO: 입력 구조 점검 및 다음 기능들 구현

    }
}
