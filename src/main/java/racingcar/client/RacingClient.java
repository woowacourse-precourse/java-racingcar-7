package racingcar.client;

import camp.nextstep.edu.missionutils.Console;
import racingcar.controller.Controller;
import racingcar.dto.RaceRequest;
import racingcar.exceptions.InvalidInputException;
import racingcar.factory.controller.ControllerFactory;
import racingcar.factory.controller.ControllerType;
import racingcar.utility.StringUtil;
import racingcar.view.View;

public class RacingClient implements Client {

    private Controller<RaceRequest> controller;
    private ControllerFactory controllerFactory;

    public RacingClient() {
        controllerFactory = new ControllerFactory();
        controller = controllerFactory.create(ControllerType.RACE);
    }

    private RaceRequest input() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carInput = Console.readLine();

        System.out.println("시도할 횟수는 몇 회인가요?");
        String numberInput = Console.readLine();

        if (carInput.isEmpty() || numberInput.isEmpty() || StringUtil.isNotNumber(numberInput)) {
            throw new InvalidInputException();
        }

        int tryCount = Integer.parseInt(numberInput);
        if (tryCount < 0) {
            throw new InvalidInputException();
        }

        return new RaceRequest(carInput, tryCount);
    }

    private void output(RaceRequest request) {
        View view = controller.run(request);
        view.draw();
    }

    @Override
    public void request() {
        RaceRequest request = input();
        output(request);
    }
}
