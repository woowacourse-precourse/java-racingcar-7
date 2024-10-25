package racingcar.view;

import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.name.Name;
import racingcar.domain.name.Names;
import racingcar.domain.racingGame.RacingGameCount;
import racingcar.util.Separator;

public class InputView {
	public static Names inputCarNames() {
		System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
		String participants = Console.readLine();
		List<String> splitParticipants = Separator.separateComma(participants.trim());

		List<Name> carNames = splitParticipants.stream().map(Name::new).toList();

		return new Names(carNames);
	}

	public static RacingGameCount inputRaceCount() {
		System.out.println("시도할 횟수는 몇 회인가요?");
		String raceCount = Console.readLine();
		System.out.println();
		return new RacingGameCount(raceCount);
	}
}
