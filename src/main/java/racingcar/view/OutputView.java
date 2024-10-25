package racingcar.view;

import java.util.List;
import java.util.stream.Collectors;

import racingcar.domain.name.Name;
import racingcar.domain.racingGame.RacingRecord;
import racingcar.domain.racingGame.RacingSnapshot;

public class OutputView {
	private static final String SCORE_SIGN = "-";

	public static void printRecords(List<RacingRecord> records) {
		records.forEach(record -> printSnapshots(record.getSnapshots()));
	}

	public static void printWinner(List<Name> winners) {
		System.out.println(generateWinnerFormat(winners));
	}

	private static void printSnapshots(List<RacingSnapshot> snapshots) {
		snapshots.forEach(OutputView::printEachSnapshot);
		System.out.println();
	}

	private static void printEachSnapshot(RacingSnapshot snapshot) {
		System.out.println(generateSnapshotFormat(snapshot));
	}

	private static String generateSnapshotFormat(RacingSnapshot snapshot) {
		return new StringBuilder()
			.append(snapshot.getName())
			.append(" : ")
			.append(SCORE_SIGN.repeat(
				snapshot.getScore())).toString();
	}

	private static String generateWinnerFormat(List<Name> winners) {
		return new StringBuilder()
			.append("최종 우승자 : ")
			.append(winners.size() == 1 ? winners.getFirst().getName()
				: winners.stream().map(Name::getName)
				.collect(Collectors.joining(", ")))
			.toString();
	}
}
