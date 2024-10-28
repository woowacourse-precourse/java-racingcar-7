package racingcar.controller;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.enums.InterfaceMsg;
import racingcar.domain.enums.ValidationMsg;
import racingcar.service.ValidatorServiceTest;

public class OperatorControllerTest extends NsTest {
	private ValidatorServiceTest validatorServiceTest;
	private List<String> carNameList;

	@BeforeEach
	void setUp() {
		validatorServiceTest = ValidatorServiceTest.getInstance();
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
			String carName = readLine();
			System.out.println(carName);
			ValidationMsg validationMsg = validatorServiceTest.getInstance().validationCarRaceTimes(carName);
			if (validationMsg == ValidationMsg.ZERO_TYPE) {
				System.out.println(validationMsg.getValue());
				throw new IllegalArgumentException();
			}
		});
	}

	@Test
	void 자동차_레이싱_시도_회수_입력값_숫자_이외_값_검증() {
		assertThrows(IllegalArgumentException.class,() -> {
			System.out.print(InterfaceMsg.REQUEST_INPUT_CAR_RACE_TIMES.getValue()); run("pobi");
			String carName = readLine();
			System.out.println(carName);
			ValidationMsg validationMsg = validatorServiceTest.getInstance().validationCarRaceTimes(carName);
			if (validationMsg == ValidationMsg.NOT_NUMBER) {
				System.out.println(validationMsg.getValue());
				throw new IllegalArgumentException();
			}
		});
	}

	@Override
	protected void runMain() {

	}
}
