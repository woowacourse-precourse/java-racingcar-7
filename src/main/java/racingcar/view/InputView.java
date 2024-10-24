package racingcar.view;

import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.name.Name;
import racingcar.domain.name.Names;
import racingcar.util.Separator;

public class InputView {
	public static Names inputCarNames() {
		String participants = Console.readLine();
		List<String> splitParticipants = Separator.seperateComma(participants.trim());

		List<Name> carNames = splitParticipants.stream().map(Name::new).toList();

		return new Names(carNames);
	}
}
