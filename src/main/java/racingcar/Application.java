package racingcar;

import racingcar.domain.CarList;
import racingcar.domain.MovingCountValidator;
import racingcar.domain.Racing;
import racingcar.dto.InputRequest;
import racingcar.io.InputView;
import racingcar.io.OutputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        InputRequest inputRequest = InputView.readLine();
        CarList carList = CarList.from(inputRequest.carNames());
        int movingCount = MovingCountValidator.from(inputRequest.movingCount());
        Racing racing = new Racing(carList, movingCount);
        String result = racing.start();
        OutputView.print(result);
    }
}
