package racingcar;

import java.util.ArrayList;
import java.util.List;
import model.Car;
import model.WinnerFinder;
import view.InputView;
import view.OutputView;

public class Application {
    public static void main(String[] args) {

        // 1. 입력 & 2. 구분
        InputView inputView = new InputView();
        List<String> carNames = inputView.getCarNames();
        int moveCount = inputView.getMoveCount();

        // 3. 자동차 객체 생성
        List<Car> cars = new ArrayList<>(carNames.size());
        for (String name : carNames) {
            cars.add(new Car(name));
        }

        // 4. 전진 & 5. 차수별 실행 결과 출력
        // move()를 전체에 대해 시행하고 Cars를 consoleView로 넘길지 (일단 이걸로)
        // move()한 객체를 하나씩 넘기기
        // TODO: for문 개선하기 (일단 구현)
        OutputView outputView = new OutputView();
        outputView.showRaceStart();

        for (int i = 0; i < moveCount; i++) {
            for (Car car : cars) {
                car.move();
            }
            outputView.showRaceStatus(cars);
        }

        // TODO: 5번 테스트 작성하기 / view를 테스트 할 필요는 없을 듯함

        // 6. 우승자 판단
        WinnerFinder winnerFinder = new WinnerFinder();
        List<Car> winners = winnerFinder.getWinners(cars);

        outputView.showWinners(winners);

        // TODO: 전체 코드 개선
    }
}
