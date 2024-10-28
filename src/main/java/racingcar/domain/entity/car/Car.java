package racingcar.domain.entity.car;

import racingcar.domain.vo.CarVO;

public class Car {
	private static final int MIN_INT_FOR_MOVING = 4;

	private CarName name;
	private Distance distance;

	public Car(CarName name, Distance distance) {
		this.name = name;
		this.distance = distance;
	}

	public void forward(int number) {
		if (number >= MIN_INT_FOR_MOVING) {
			distance.forward();
		}
	}

	public String[] createResultSentence() {
		String[] sentence = name.createResultSentence();
		return distance.insertResultSentence(sentence);
	}

	public CarVO toCarStatus() {
		return new CarVO(name, distance);
	}
}
