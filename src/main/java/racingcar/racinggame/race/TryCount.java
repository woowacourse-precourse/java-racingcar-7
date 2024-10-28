package racingcar.racinggame.race;

import java.util.Objects;

public class TryCount {

	private static final int MIN_TRY_COUNT = 1;
	private static final int MAX_TRY_COUNT = 10_000;
	private static final String OVER_FLOW_TRY_COUNT_RANGE = "시도 횟수가 지정된 범위를 벗어났습니다.";

	private final int count;

	private TryCount(int tryCount) {
		validateTryCountRange(tryCount);

		this.count = tryCount;
	}

	public static TryCount from(int tryCount) {
		return new TryCount(tryCount);
	}

	private void validateTryCountRange(int tryCount) {
		if (tryCount < MIN_TRY_COUNT || MAX_TRY_COUNT < tryCount) {
			throw new IllegalArgumentException(OVER_FLOW_TRY_COUNT_RANGE);
		}
	}

	public int getCount() {
		return count;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		TryCount tryCount = (TryCount)o;
		return count == tryCount.count;
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(count);
	}
}
