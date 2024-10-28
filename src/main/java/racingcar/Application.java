package racingcar;

import racingcar.domain.CarList;
import racingcar.domain.Racing;
import racingcar.dto.InputRequest;
import racingcar.io.InputView;
import racingcar.io.OutputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        InputRequest inputRequest = InputView.readLine();
        CarList carList = CarList.from(inputRequest.carNames());
        Racing racing = new Racing(carList, inputRequest.movingCount());
        String result = racing.start();
        OutputView.print(result);
    }
}
