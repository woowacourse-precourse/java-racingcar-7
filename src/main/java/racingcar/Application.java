package racingcar;

import racingcar.model.RaceManager;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        RaceManager raceManager = new RaceManager(
                new InputView(),
                new OutputView()
        );
        raceManager.run();
    }
}
// RaceManager를 생성하고 run()을 통해서 실행합니다.
// InputView()와 OutputView()를 의존성 주입해주어 view가 변경됨에 따른 유연한 대체가 가능하게 구현하였습니다.