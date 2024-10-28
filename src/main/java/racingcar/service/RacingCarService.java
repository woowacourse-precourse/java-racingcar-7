package racingcar.service;

import java.util.Map;
import racingcar.domain.racingcar.RacingCar;
import racingcar.domain.racingcar.RacingCarRepository;
import racingcar.dto.RacingCarInitDto;

public class RacingCarService {
	private final RacingCarRepository racingCarRepository = RacingCarRepository.getInstance();

	private Integer inputCarRaceTimes = 0;

	// start: Singleton Holder
	private RacingCarService() {
	}

	private static class InnerRacingCarService {
		private static final RacingCarService instance = new RacingCarService();
	}

	public static RacingCarService getInstance() {
		return InnerRacingCarService.instance;
	}
	// end: Singleton Holder

	public void initSaveRacingCar(RacingCarInitDto racingCarInitDto) {
		this.inputCarRaceTimes = racingCarInitDto.getInputCarRaceTimes();
		for (String carName : racingCarInitDto.getCarNameList()) {
			racingCarRepository.initSaveRacingCar(carName);
		}
	}

	public Map<String, RacingCar> getRacingCarMap() {
		return racingCarRepository.getRacingCarMap();
	}


}
