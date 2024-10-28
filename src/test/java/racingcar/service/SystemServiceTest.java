package racingcar.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SystemServiceTest {

	@Test
	@DisplayName("Cars String Split 검증")
	void 입력값에서_이름들_추출_테스트() {

		String cars = "pobi  ,woni ,jun ";

		SystemService systemService = SystemService.getInstance();
	}

}