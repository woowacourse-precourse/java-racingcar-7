package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.util.SplittingRacingCarName;

public class InputView {
    public String[] inputCarNames(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNames = Console.readLine();  // Scanner 대신 Console 사용
        return SplittingRacingCarName.splitRacingCarName(carNames);
    }
}
