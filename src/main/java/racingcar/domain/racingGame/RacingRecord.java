package racingcar.domain.racingGame;

import java.util.List;

public class RacingRecord {
	private final List<RacingSnapshot> snapshots;

	public RacingRecord(List<RacingSnapshot> snapshots) {
		this.snapshots = snapshots;
	}

	public List<RacingSnapshot> getSnapshots() {
		return snapshots;
	}
}
