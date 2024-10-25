package racingcar.view;

import java.util.List;

import racingcar.car.service.dto.CarMoveRespDto;

public class OutputView {
	private OutputView() {
	}

	private static class OutputViewHolder {
		private static final OutputView INSTANCE = new OutputView();
	}

	public static OutputView getInstance() {
		return OutputView.OutputViewHolder.INSTANCE;
	}

	public void printMoveResults(List<CarMoveRespDto> moveResults) {
		StringBuilder sb = new StringBuilder();
		moveResults.forEach(moveResult -> {
			sb.append(moveResult.getCarName())
				.append(" : ")
				.append("-".repeat(moveResult.getPosition()))
				.append("\n");
		});
		System.out.println(sb);
	}
}
