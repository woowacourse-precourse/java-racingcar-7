package racingcar.domain.vo;

import java.util.List;
import java.util.stream.Collectors;

import racingcar.domain.entity.car.CarName;
import racingcar.domain.entity.car.Distance;

public class CarVO {
	private final CarNameVO name;
	private final DistanceVO distance;

	public CarVO(CarName name, Distance distance) {
		this.name = name.toCarNameVO();
		this.distance = distance.toDistanceVO();
	}

	public CarNameVO getCarNameVO() {
		return name;
	}

	public int getDistance() {
		return distance.value();
	}

	public static List<CarNameVO> getWinnerList(List<CarVO> carVOList) {
		int maxDistance = carVOList.stream()
			.mapToInt(CarVO::getDistance)
			.max()
			.orElse(0);

		return carVOList.stream()
			.filter(winner -> winner.getDistance() == maxDistance)
			.map(CarVO::getCarNameVO)
			.collect(Collectors.toList());
	}
}
