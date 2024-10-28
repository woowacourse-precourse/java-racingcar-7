package racingcar.io;

import racingcar.validation.ValidateInput;
import static camp.nextstep.edu.missionutils.Console.readLine;
import static racingcar.validation.ValidateInput.*;

public class Input {
    public static String inputCarName(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String CarName = readLine();

        validateName(CarName);

        return CarName;
    }

    public static String inputNumberOfRound() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        String numberOfRounds = readLine();

        validateMoveCount(numberOfRounds);

        return numberOfRounds;
    }


}
