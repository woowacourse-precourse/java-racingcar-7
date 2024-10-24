package racingcar;

import racingcar.domain.Car;
import racingcar.util.RacingUtil;
import racingcar.util.RacingValidator;

import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Racing {


    public void play() {
        List<Car> carList = getCarListFromUser();

    }

    private List<Car> getCarListFromUser() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = readLine();
        RacingValidator.isCarNameInput(input);
        return RacingUtil.getCarList(input);
    }
}
