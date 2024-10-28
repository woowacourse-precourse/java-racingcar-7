package racingcar.domain.racingcar;

import java.util.LinkedHashMap;
import java.util.Map;
import racingcar.dto.RacingCarDto;

public class RacingCarRepository {
	private Map<String, RacingCar> racingCarMap = new LinkedHashMap<>();

	// start: Singleton Holder
	private RacingCarRepository() {
	}

	private static class InnerRacingCarRepository {
		private static final RacingCarRepository instance = new RacingCarRepository();
	}

	public static RacingCarRepository getInstance() {
		return InnerRacingCarRepository.instance;
	}
	// end: Singleton Holder

	public Map<String, RacingCar> getRacingCarMap() {
		return racingCarMap;
	}

	public void initSaveRacingCar(RacingCarDto racingCarDto) {
		racingCarMap.put(racingCarDto.getCarName(), new RacingCar(racingCarDto.getCarName()));
	}

	public void initSaveRacingCar(String carName) {
		racingCarMap.put(carName, new RacingCar(carName));
	}

	public RacingCar getRacingCarByName(String carName) {
		return racingCarMap.get(carName);
	}

}
