package racingcar;

import racingcar.domain.Car;
import racingcar.util.RacingUtil;
import racingcar.util.RacingValidator;

import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Racing {

    private List<Car> carList;

    public void play() {
        carList = getCarListFromUser();
        int moveCount = getMoveCountFromUser();
        move(moveCount);
    }

    private List<Car> getCarListFromUser() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = readLine();
        RacingValidator.isCarNameInput(input);
        return RacingUtil.getCarList(input);
    }

    private int getMoveCountFromUser() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        String input = readLine();
        RacingValidator.isInteger(input);
        return Integer.parseInt(input);
    }

    private void move(int moveCount) {
        System.out.println("실행 결과");
        for (int i = 0; i < moveCount; i++) {
            RacingUtil.setMoveOrStop(carList);
        }
    }
}
