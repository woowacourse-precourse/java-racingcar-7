package racingcar.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class SystemServiceTest {

	@Test
	@DisplayName("Cars String Split 검증")
	void 입력값에서_이름들_추출_테스트() {

		String cars = "pobi  ,woni ,jun ";

		SystemService systemService = new SystemService();
	}

}