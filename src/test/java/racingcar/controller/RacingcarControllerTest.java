package racingcar.controller;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.enums.InterfaceMsg;
import racingcar.domain.enums.ValidationMsg;
import racingcar.domain.racingcar.RacingCar;
import racingcar.dto.RacingCarInitDto;
import racingcar.service.RacingCarService;
import racingcar.service.RacingCarServiceTest;
import racingcar.service.ValidatorServiceTest;

public class RacingcarControllerTest extends NsTest {
	private ValidatorServiceTest validatorServiceTest;
	private RacingCarServiceTest racingCarServiceTest;
	private List<String> carNameList;

	@BeforeEach
	void setUp() {
		validatorServiceTest = ValidatorServiceTest.getInstance();
		racingCarServiceTest = RacingCarServiceTest.getInstance();
		carNameList = new ArrayList<>(Arrays.asList("pobi", "woni", "crong"));
	}

	@Test
	void 자동차_이름_string_null_입력_체크() {
		assertEquals(ValidationMsg.NULL_TYPE, validatorServiceTest.getInstance().validationCarName(null));
	}

	@Test
	void 자동차_이름_string_empty_입력_체크() {
		assertEquals(ValidationMsg.EMPTY_TYPE, validatorServiceTest.getInstance().validationCarName(""));
	}

	@Test
	void 자동차_2대_이상_검증() {
		String carName = "pobi"; final boolean expectFalseMoreThanTwoCar = false;
		String carNames = "pobi,javaji"; final boolean expectTrueMoreThanTwoCar = true;

		boolean isFalseMoreThanTwoCar = validatorServiceTest.isMoreThanTwoCar(carName);
		boolean isTrueMoreThanTwoCar = validatorServiceTest.isMoreThanTwoCar(carNames);

		assertEquals(expectFalseMoreThanTwoCar, isFalseMoreThanTwoCar);
		assertEquals(expectTrueMoreThanTwoCar, isTrueMoreThanTwoCar);
	}

	@Test
	void 자동차_2대_검증_with_IllegalAccessException() {
		assertThrows(IllegalArgumentException.class,() -> {
			System.out.print(InterfaceMsg.REQUEST_INPUT_CAR_NAME.getValue()); run("pobi");
			String carName = readLine(); System.out.println(carName);
			ValidationMsg validationMsg = validatorServiceTest.getInstance().validationCarName(carName);
			if (validationMsg == ValidationMsg.NEED_MORE_THEN_TWO) {
				System.out.println(validationMsg.getValue()); throw new IllegalArgumentException();
			}
		});
	}

	@Test
	void 자동차_이름_길이_유효성_검증() {
		assertThrows(IllegalArgumentException.class,() -> {
			System.out.print(InterfaceMsg.REQUEST_INPUT_CAR_NAME.getValue()); run("pobi,javaji");
			String carName = readLine(); System.out.println(carName);
			ValidationMsg validationMsg = validatorServiceTest.getInstance().validationCarName(carName);
			if (validationMsg == ValidationMsg.CAR_NAME_OVER_FIVE) {
				System.out.println(validationMsg.getValue()); throw new IllegalArgumentException();
			}
		});
	}

	@Test
	void 자동차_이름_중복_검증() {
		assertThrows(IllegalArgumentException.class,() -> {
			System.out.print(InterfaceMsg.REQUEST_INPUT_CAR_NAME.getValue()); run("pobi, pobi");
			String carName = readLine(); System.out.println(carName);
			ValidationMsg validationMsg = validatorServiceTest.getInstance().validationCarName(carName);
			if (validationMsg == ValidationMsg.NOT_DUPLICATE_NAME) {
				System.out.println(validationMsg.getValue()); throw new IllegalArgumentException();
			}
		});
	}

	@Test
	void 자동차_레이싱_시도_회수_string_null_입력_체크() {
		assertEquals(ValidationMsg.NULL_TYPE, validatorServiceTest.getInstance().validationCarRaceTimes(null));
	}

	@Test
	void 자동차_레이싱_시도_회수_string_empty_입력_체크() {
		assertEquals(ValidationMsg.EMPTY_TYPE, validatorServiceTest.getInstance().validationCarRaceTimes(""));
	}

	@DisplayName("자동차_레이싱_시도_회수_입력값_0_검증")
	@Test
	void 자동차_레이싱_시도_회수_입력값_0_검증() {
		assertThrows(IllegalArgumentException.class,() -> {
			System.out.print(InterfaceMsg.REQUEST_INPUT_CAR_RACE_TIMES.getValue()); run("0");
			String carName = readLine(); System.out.println(carName);
			ValidationMsg validationMsg = validatorServiceTest.getInstance().validationCarRaceTimes(carName);
			if (validationMsg == ValidationMsg.ZERO_TYPE) {
				System.out.println(validationMsg.getValue()); throw new IllegalArgumentException();
			}
		});
	}

	@Test
	void 자동차_레이싱_시도_회수_입력값_숫자_이외_값_검증() {
		assertThrows(IllegalArgumentException.class,() -> {
			System.out.print(InterfaceMsg.REQUEST_INPUT_CAR_RACE_TIMES.getValue()); run("pobi");
			String carName = readLine(); System.out.println(carName);
			ValidationMsg validationMsg = validatorServiceTest.getInstance().validationCarRaceTimes(carName);
			if (validationMsg == ValidationMsg.NOT_NUMBER) {
				System.out.println(validationMsg.getValue()); throw new IllegalArgumentException();
			}
		});
	}

	@Test
	void RacingCarServiceTest를_통해_RacingCarRepository에_여러_자동차_저장() {
		RacingCarInitDto racingCarInitDto = RacingCarInitDto.builder().carNameList(carNameList).inputCarRaceTimes(1).build();

		racingCarServiceTest.initSaveRacingCar(racingCarInitDto);

		Map<String, RacingCar> racingCarMap = racingCarServiceTest.getRacingCarMap();
		racingCarMap.forEach((key, val) -> assertThat(carNameList).contains(key));
	}

	@Test
	void RacingCarService를_통해_RacingCarRepository에_여러_자동차_저장() {
		RacingCarInitDto racingCarInitDto = RacingCarInitDto.builder().carNameList(carNameList).inputCarRaceTimes(1).build();

		RacingCarService.getInstance().initSaveRacingCar(racingCarInitDto);

		RacingCarService.getInstance().getRacingCarMap().forEach((key, val) -> assertThat(carNameList).contains(key));
		RacingCarService.getInstance().getRacingCarMap().forEach((key, val) -> val.movingForward());
		RacingCarService.getInstance().getRacingCarMap().forEach((key, val) -> System.out.println(key + " : " + val.getCarPosition()));
	}

	@Test
	void RacingCarRepository가_가진_RacingCar들의_이름과_전진한_값을_출력() {
		RacingCarInitDto racingCarInitDto = RacingCarInitDto.builder().carNameList(carNameList).inputCarRaceTimes(5).build();
		racingCarServiceTest.initSaveRacingCar(racingCarInitDto);
		racingCarServiceTest.playCarRacing();
	}

	@Test
	void 최종_우승자_결과출력() {
		RacingCarInitDto racingCarInitDto = RacingCarInitDto.builder().carNameList(carNameList).inputCarRaceTimes(5).build();
		racingCarServiceTest.initSaveRacingCar(racingCarInitDto);
		racingCarServiceTest.playCarRacing();
		racingCarServiceTest.carRacingResult();
	}

	@Override
	protected void runMain() {

	}
}
