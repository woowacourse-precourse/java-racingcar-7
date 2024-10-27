package racingcar;

public class RaceController {

	private CarList carList;
	private int attemptNum;

	public RaceController() {
		setCars();
		setAttemptNumber();
		playRace();
		showWinner();
	}

	private void setCars() {
		this.carList = Input.readNames();
	}

	private void setAttemptNumber() {
		this.attemptNum = Input.readAttemptNumber();
	}

	private void playRace() {
		System.out.println(Output.RESULT_MESSAGE);

		for (int i = 0; i < attemptNum; i++) {
			carList.startRace();
			Output.printOneMoveResult(carList.getCars());
			System.out.println();
		}
	}

	private void showWinner() {
		Output.printWinner(carList.getMaxMoveCounter(), carList.getCars());
	}
}
