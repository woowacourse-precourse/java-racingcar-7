package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.TrialCount;
import racingcar.util.SplittingRacingCarName;

public class InputView {

    public String[] inputCarNames(){
        String carNames = Console.readLine();  // Scanner 대신 Console 사용
        return SplittingRacingCarName.splitRacingCarName(carNames);
    }

    public String inputTrialCount(){
        return Console.readLine();
    }
}
