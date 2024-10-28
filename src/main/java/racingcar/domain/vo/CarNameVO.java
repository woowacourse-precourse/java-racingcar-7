package racingcar.domain.vo;

import racingcar.domain.entity.car.CarName;

public record CarNameVO(String value) {

	public static CarNameVO from(CarName carName) {
		return carName.toCarNameVO();
	}

	// public List<CarNameVO> toCarNames() {
	// 	return carNames.stream()
	// 		.map(CarNameVO::from)
	// 		.collect(Collectors.toUnmodifiableList());
	// }
}
