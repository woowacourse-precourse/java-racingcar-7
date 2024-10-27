package racingcar.domain.model;

public class RaceStatus {
	private final String name;
	private final int position;

	public RaceStatus(String name, int position) {
		this.name = name;
		this.position = position;
	}

	public String getName() {
		return name;
	}

	public int getPosition() {
		return position;
	}
}
