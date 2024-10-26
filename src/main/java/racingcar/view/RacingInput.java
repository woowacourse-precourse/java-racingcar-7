package racingcar.view;

import racingcar.common.view.ConsoleInput;
import racingcar.common.view.ConsoleOutput;
import racingcar.object.value.CarName;
import racingcar.object.value.CarNames;
import racingcar.object.value.TotalLapCount;

public class RacingInput {

    public static CarNames askCarNamesForParticipants() {
        ConsoleOutput.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return new CarNames(ConsoleInput.readStrings().stream()
                .map(CarName::new)
                .toList());
    }

    public static TotalLapCount askTotalLapCount() {
        ConsoleOutput.println("시도할 횟수는 몇 회인가요?");
        return new TotalLapCount(ConsoleInput.readInteger());
    }

}
