package racingcar;

import java.util.List;
import model.Car;
import model.CarsHandler;
import view.InputView;
import view.OutputView;

public class Application {
    public static void main(String[] args) {

        // 1. 입력 & 2. 구분
        InputView inputView = new InputView();
        List<String> carNames = inputView.getCarNames();
        int moveCount = inputView.getMoveCount();

        // 3. 자동차 객체 생성
        CarsHandler carsHandler = new CarsHandler(carNames);

        // 4. 전진 & 5. 차수별 실행 결과 출력
        OutputView outputView = new OutputView();

        // TODO: carName을 계속 넘겨주고 있음 별로임
        outputView.showRaceStart();
        for (int i = 0; i < moveCount; i++) {
            carsHandler.moveCars();
            outputView.showRaceStatus(carsHandler.getCars());
        }

        // TODO: 5번 테스트 작성하기

        // 6. 우승자 판단
        List<Car> winners = carsHandler.getWinners();
        outputView.showWinners(winners);

        // TODO: 전체 코드 개선
    }
}
