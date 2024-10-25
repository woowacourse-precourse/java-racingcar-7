package racingcar.view;

import java.util.List;
import java.util.stream.IntStream;

import racingcar.domain.racingGame.RacingRecord;
import racingcar.domain.racingGame.RacingSnapshot;

public class OutputView {
	private static final String SCORE_SIGN = "-";
	public static void printRecords(List<RacingRecord> records) {
		records.forEach(record -> printSnapshots(record.getSnapshots()));
	}

	private static void printSnapshots(List<RacingSnapshot> snapshots) {
		snapshots.forEach(OutputView::printEachSnapshot);
		System.out.println();
	}

	private static void printEachSnapshot(RacingSnapshot snapshot) {
		System.out.printf("%s : ", snapshot.getName());
		IntStream.range(0, snapshot.getScore()).forEach(score -> System.out.print(SCORE_SIGN));
		System.out.println();
	}
}
