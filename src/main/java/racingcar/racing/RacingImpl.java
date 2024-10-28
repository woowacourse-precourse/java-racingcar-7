package racingcar.racing;

import static racingcar.constant.Letter.*;
import static racingcar.constant.Number.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import camp.nextstep.edu.missionutils.Randoms;

public final class RacingImpl implements Racing {
	private final Map<String, StringBuilder> nameMap;
	
	protected RacingImpl(final Map<String, StringBuilder> nameMap) {
		this.nameMap = nameMap;
	}
	
	@Override
	public final void printResult(final long tryingCount) {
		System.out.println("\n" + ANS_RESULT);
		
		for (long loop = 0; loop < tryingCount; loop++) {
			final StringBuilder result = new StringBuilder();
			raceAndNote(result);
			System.out.println(result);
		}
	}
	
	@Override
	public final void printWinner() {
		final long maxCount = getMaxCount();
		final List<String> winnerList = nameMap.keySet().stream()
				.filter(name -> nameMap.get(name).length() == maxCount)
				.collect(Collectors.toList());
		
		System.out.println(ANS_WINNER.toString() + COLON.toString() + String.join(COMMA.toString(), winnerList));
	}

	private final void raceAndNote(final StringBuilder result) {
		for (final String name : nameMap.keySet()) {
			if (Randoms.pickNumberInRange(START.get(), END.get()) >= FORWARD_NUM.get()) {
				nameMap.get(name).append(FORWARD_LINE);
			}
			result.append(name + COLON + nameMap.get(name) + "\n");
		}
	}
	
	private final long getMaxCount() {
		return nameMap.values().stream()
				.mapToLong(StringBuilder::length)
				.max()
				.orElse(0);
	}
}
