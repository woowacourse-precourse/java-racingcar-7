package racingcar;

import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import racingcar.domain.controller.RaceController;
import racingcar.domain.model.CarList;
import racingcar.domain.view.RaceView;
import racingcar.view.TestRaceView;

class RaceControllerTest {

	private CarList carList;
	private RaceController raceController;

	@ParameterizedTest
	@MethodSource("provide_input_for_test_valid_input")
	void test_add_cars_when_valid_input(String names, int lap, int expectedCarCount, int expectedLapCount) {
		//given
		carList = new CarList();
		RaceView raceView = new TestRaceView(names, lap);
		raceController = new RaceController(carList, raceView);

		//when
		raceController.receiveCarNames();
		int receivedRaceLap = raceController.receiveRaceLap();

		//then
		Assertions.assertEquals(expectedCarCount, carList.getCount());
		Assertions.assertEquals(expectedLapCount, receivedRaceLap);
	}

	static Stream<Arguments> provide_input_for_test_valid_input() {
		return Stream.of(Arguments.of("pobi,woni,jun", 5, 3, 5), Arguments.of("pobi,jun", 3, 2, 3),
			Arguments.of("pobi,woni,jun,lee", 99999, 4, 99999));
	}

	@Test
	void test_add_cars_when_invalid_lap() {
		//given
		carList = new CarList();
		RaceView raceView = new TestRaceView("lb, ld", -1);
		raceController = new RaceController(carList, raceView);

		//when & then
		Assertions.assertThrows(IllegalArgumentException.class, () -> raceController.receiveRaceLap());
	}

	@ParameterizedTest
	@MethodSource("provide_input_for_test_invalid_name")
	void test_add_cars_when_invalid_name(String names) {
		//given
		carList = new CarList();
		RaceView raceView = new TestRaceView(names, 1);
		raceController = new RaceController(carList, raceView);

		//when & then
		Assertions.assertThrows(IllegalArgumentException.class, () -> raceController.receiveCarNames());
	}

	static Stream<Arguments> provide_input_for_test_invalid_name() {
		return Stream.of(Arguments.of(""), Arguments.of("   "), Arguments.of("\n"), Arguments.of("\t"),
			Arguments.of("biads5,adf,as"), Arguments.of("biads5,adf45,a22s"));
	}

}
