package racingcar;

public class Application {
	public static void main(String[] args) {
		RaceManager raceManager = RaceManager.of(
			IoHandler.of(InputHandler.create(), OutputHandler.create(), ValidatingParser.create()),
			RandomNumberProvider.create());

		raceManager.run();
	}
}
