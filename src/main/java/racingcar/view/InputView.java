package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.MovingCount;
import racingcar.util.SplittingRacingCarName;

public class InputView {

    public String[] inputCarNames(){
        String carNames = Console.readLine();  // Scanner 대신 Console 사용
        return SplittingRacingCarName.splitRacingCarName(carNames);
    }

    public MovingCount inputTrialCount(){
        String trialCount = Console.readLine();
        return new MovingCount(trialCount);
    }
}
