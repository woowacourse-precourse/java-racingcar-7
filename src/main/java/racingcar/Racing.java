package racingcar;

import racingcar.domain.Car;
import racingcar.ui.Output;
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
        getWinner();
    }

    private List<Car> getCarListFromUser() {
        Output.printCarNameInput();
        String input = readLine();
        RacingValidator.isCarNameInput(input);
        return RacingUtil.getCarList(input);
    }

    private int getMoveCountFromUser() {
        Output.printMoveCountInput();
        String input = readLine();
        RacingValidator.isInteger(input);
        return Integer.parseInt(input);
    }

    private void move(int moveCount) {
        System.out.println("실행 결과");
        for (int i = 0; i < moveCount; i++) {
            RacingUtil.setMoveOrStop(carList);
            Output.printCarPosition(carList);
        }
    }

    private void getWinner() {
        List<String> winners = RacingUtil.findWinner(carList);
        Output.printWinners(winners);
    }

}
