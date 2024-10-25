package racingcar;

import java.util.List;
import racingcar.context.Car;
import racingcar.service.CarGroup;
import racingcar.service.CarRacing;
import racingcar.service.CarRacingResult;
import racingcar.util.CarNameSeparator;
import racingcar.view.InputView;
import racingcar.view.OutputView;
import racingcar.view.PrintMessage;

public class Application {
    public static void main(String[] args) {
        OutputView.printMessageWithLine(PrintMessage.INPUT_CAR_NAME_MESSAGE);
        String carName = InputView.inputUser();

        //컨트롤러 영역에서 해야 할 일
        //1. 이름 입력 받아 쉼표 기준 분리
        List<String> carNameGroup = CarNameSeparator.splitCarNameWithSeparator(carName);

        //2. 이름 검증(공백 제거, 5자 이하 검증)
        //3. Car List 생성
        CarGroup createCarGroup = new CarGroup(carNameGroup);
        List<Car> carGroup = createCarGroup.getCarGroup();

        //라운드 수 입력 받기
        OutputView.printMessageWithLine(PrintMessage.INPUT_TRY_CAR_MOVEMENT_MESSAGE);
        String totalRound = InputView.inputUser();
        //4. 라운드 수만큼 반복하면서 자동차 이동 시도
        CarRacing carRace = new CarRacing(totalRound, carGroup);

        //자동차 경기 현황 출력
        OutputView.printMessageWithLine(PrintMessage.LINE_SPACE);
        OutputView.printMessageWithLine(PrintMessage.CAR_RACE_RESULT_MESSAGE);
        carRace.startCarRacing();

        //5. 경기 결과 판단
        CarRacingResult carRacingResult = new CarRacingResult(carRace.getCarGroup());
        //자동차 경기 결과 출력
        OutputView.printMessage(PrintMessage.CAR_RACE_WINNER_MESSAGE);
    }
}
