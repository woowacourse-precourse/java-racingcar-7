package racingcar;

import racingcar.domain.CarList;
import racingcar.dto.InputRequest;
import racingcar.io.InputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        InputRequest inputRequest = InputView.readLine();
        CarList carList = CarList.from(inputRequest.carNames());

    }
}
