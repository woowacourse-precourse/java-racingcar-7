package racingcar;

/*
초간단 자동차 경주 게임을 구현한다.

[x]주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
[x]각 자동차에 이름을 부여할 수 있다. 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
[x]자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다.
[x]사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
[x]전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다.
[x]자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다.
[x]우승자가 여러 명일 경우 쉼표(,)를 이용하여 구분한다.
[x]사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨 후 애플리케이션은 종료되어야 한다.
*/

import racingcar.controller.RacingCarController;
import racingcar.service.RacingCarService;
import racingcar.service.RacingCarServiceImpl;
import racingcar.validation.CarNameValidator;
import racingcar.validation.NameValidator;
import racingcar.view.RacingCarView;
import racingcar.view.RacingCarViewImpl;

public class Application {
    public static void main(String[] args) {

        NameValidator nameValidator = new CarNameValidator();
        RacingCarService racingCarService = new RacingCarServiceImpl(nameValidator);
        RacingCarView racingCarView = new RacingCarViewImpl();

        RacingCarController racingCarController = new RacingCarController(racingCarService, racingCarView);
        racingCarController.run();
    }
}
