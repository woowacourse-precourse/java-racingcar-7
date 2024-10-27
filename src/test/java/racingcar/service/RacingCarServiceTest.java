package racingcar.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.constant.Rule;
import racingcar.domain.Car;
import racingcar.domain.Count;
import racingcar.domain.Racing;
import racingcar.dto.RacingCarProgress;
import racingcar.dto.RacingCarResult;
import racingcar.dto.RacingCarWinner;
import racingcar.fake.FakeListValidator;
import racingcar.fake.FakeNumberValidator;
import racingcar.fake.FakeStringValidator;
import racingcar.fake.ForwardNumberGenerator;
import racingcar.util.generator.NumberGenerator;
import racingcar.util.validator.ListValidator;
import racingcar.util.validator.NumberValidator;
import racingcar.util.validator.StringValidator;

class RacingCarServiceTest {

    private NumberGenerator numberGenerator;
    private StringValidator stringValidator;
    private NumberValidator<Integer> numberValidator;
    private ListValidator<String> listValidator;
    private RacingCarService racingCarService;

    @BeforeEach
    void setUp() {
        numberGenerator = new ForwardNumberGenerator();
        stringValidator = new FakeStringValidator();
        numberValidator = new FakeNumberValidator();
        listValidator = new FakeListValidator();
        racingCarService = new RacingCarService(listValidator, numberGenerator, numberValidator, stringValidator);
    }

    @Test
    @DisplayName("자동차 이름으로 자동차 객체를 생성한다.")
    void generateCarsTest() throws Exception {
        //given
        final String value = "작은 자동차,큰 자동차";

        //when
        final List<Car> cars = racingCarService.generateCars(value);
        final Car car1 = cars.getFirst();
        final Car car2 = cars.get(1);

        //then
        assertAll(
                () -> assertThat(car1.getName()).isEqualTo("작은 자동차"),
                () -> assertThat(car2.getName()).isEqualTo("큰 자동차"),
                () -> assertThat(car1.getScore()).isEqualTo(Rule.INITIAL_SCORE),
                () -> assertThat(car2.getScore()).isEqualTo(Rule.INITIAL_SCORE)
        );
    }

    @Test
    @DisplayName("우승자를 가져온다.")
    void getWinnerTest() throws Exception {
        //given
        final String value = "우승 자동차1,우승 자동차2";
        final List<Car> cars = racingCarService.generateCars(value);
        final Car car1 = cars.getFirst();
        final Car car2 = cars.get(1);

        //when
        final RacingCarWinner racingCarWinner = RacingCarWinner.of(cars);
        final List<String> winnerNames = racingCarWinner.winnerNames();
        final String carName1 = winnerNames.getFirst();
        final String carName2 = winnerNames.get(1);

        //then
        assertAll(
                () -> assertThat(car1.getName()).isEqualTo(carName1),
                () -> assertThat(car2.getName()).isEqualTo(carName2)
        );
    }

    @Test
    @DisplayName("경주 결과를 가져온다")
    void getRacingCarResultTest() throws Exception {
        //given
        final String value = "전진 하는 자동차1,전진 하는 자동차2";
        final List<Car> cars = racingCarService.generateCars(value);
        final Racing racing = new Racing(cars);
        final Count count = Count.of("2", numberValidator);
        final RacingCarProgress mockProgress1 = new RacingCarProgress("전진 하는 자동차1", 1);
        final RacingCarProgress mockProgress2 = new RacingCarProgress("전진 하는 자동차2", 1);
        final RacingCarProgress mockProgress3 = new RacingCarProgress("전진 하는 자동차1", 2);
        final RacingCarProgress mockProgress4 = new RacingCarProgress("전진 하는 자동차2", 2);

        //when
        final List<RacingCarResult> results = racingCarService.getRacingCarResult(racing, count);
        final RacingCarResult result1 = results.getFirst();
        final RacingCarResult result2 = results.get(1);
        final List<RacingCarProgress> progresses1 = result1.progresses();
        final List<RacingCarProgress> progresses2 = result2.progresses();
        final RacingCarProgress progress1 = progresses1.getFirst();
        final RacingCarProgress progress2 = progresses1.get(1);
        final RacingCarProgress progress3 = progresses2.getFirst();
        final RacingCarProgress progress4 = progresses2.get(1);

        //then
        assertAll(
                () -> assertThat(progress1).isEqualTo(mockProgress1),
                () -> assertThat(progress2).isEqualTo(mockProgress2),
                () -> assertThat(progress3).isEqualTo(mockProgress3),
                () -> assertThat(progress4).isEqualTo(mockProgress4)
        );

    }

}