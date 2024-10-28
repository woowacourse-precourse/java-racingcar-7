package racingcar.dto;

import java.util.ArrayList;
import java.util.List;

/**
 * 자동차 경주 게임에 참여하는 자동차 목록과 레이싱 시도 회수를 보관하는 DTO
 */
public class RacingCarInitDto {
	private List<String> carNameList = new ArrayList<>();
	private Integer inputCarRaceTimes = 0;

	private RacingCarInitDto() {
	}

	// start: Builder 패턴
	public static Builder builder() {
		return new Builder();
	}

	public static class Builder {
		private RacingCarInitDto dto = new RacingCarInitDto();

		public Builder carNameList(List<String> carNameList) {
			dto.carNameList = carNameList;
			return this;
		}

		public Builder inputCarRaceTimes(Integer inputCarRaceTimes) {
			dto.inputCarRaceTimes = inputCarRaceTimes;
			return this;
		}

		public RacingCarInitDto build() {
			return dto;
		}
	}
	// end: Builder 패턴

	public List<String> getCarNameList() {
		return carNameList;
	}

	public void setCarNameList(List<String> carNameList) {
		this.carNameList = carNameList;
	}

	public Integer getInputCarRaceTimes() {
		return inputCarRaceTimes;
	}

	public void setInputCarRaceTimes(Integer inputCarRaceTimes) {
		this.inputCarRaceTimes = inputCarRaceTimes;
	}
}
