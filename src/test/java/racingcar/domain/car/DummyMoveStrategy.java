package racingcar.domain.car;

public class DummyMoveStrategy implements MoveStrategy {
	private final boolean isMovable;

	public DummyMoveStrategy(boolean isMovable) {
		this.isMovable = isMovable;
	}

	@Override
	public boolean isMovable() {
		return isMovable;
	}
}
