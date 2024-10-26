package racingcar.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.mock.model.dependency.validator.MockedRacingCarValidator;
import racingcar.service.dependency.random_maker.RandomNumberMaker;
import racingcar.util.RacingCarsUtil;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.constant.Constants.RACING_CAR_MIN_MOVABLE_NUMBER;

@DisplayName("RacingCars 테스트")
public class RacingCarsTest {

    // Mock
    private static final MockedRacingCarValidator mockedRacingCarValidator = new MockedRacingCarValidator();

    /*
        매 테스트마다 초기화
        MockedRacingCarValidator 의 상태를 초기화한 후, validateName() 의 결과를 true 로 설정
     */
    @BeforeEach
    void clear() {
        mockedRacingCarValidator.clear();
        mockedRacingCarValidator.setIsValidateNameWillPass(true);
    }

    @Test
    @DisplayName("constructor : 기본_생성자는_깊은_복사로_동작한다")
    void 기본_생성자는_깊은_복사로_동작한다() {

        // when
        List<RacingCar> racingCarList = makeRacingCarList();
        RacingCars racingCars = new RacingCars(racingCarList);

        // then
        List<RacingCar> values = RacingCarsUtil.parseValues(racingCars);

        // List 가 다른 참조를 가지는지
        // 동일한 수의 요소를 가지는지
        // List 의 모든 요소들이 다른 참조를 가지는지
        assertThat(values)
                .isNotSameAs(racingCarList)
                .hasSize(racingCarList.size())
                .allMatch(value -> racingCarList.stream().noneMatch(car -> car == value));
    }

    @Test
    @DisplayName("copy constructor : 복사_생성자는_깊은_복사로_동작한다")
    void 복사_생성자는_깊은_복사로_동작한다() {

        // given
        List<RacingCar> originalCars = makeRacingCarList();

        RacingCars original = new RacingCars(originalCars);

        // when
        RacingCars copied = new RacingCars(original);

        // then
        List<RacingCar> originalValues = RacingCarsUtil.parseValues(original);
        List<RacingCar> copiedValues = RacingCarsUtil.parseValues(copied);


        // List 가 다른 참조를 가지는지
        // 동일한 수의 요소를 가지는지
        // List 의 모든 요소들이 다른 참조를 가지는지
        assertThat(copiedValues)
                .isNotSameAs(originalValues)
                .hasSize(originalValues.size())
                .allMatch(copyValue ->
                        originalValues.stream().noneMatch(originalValue -> originalValue == copyValue)
                );
    }

    @Test
    @DisplayName("validate() : 생성_시_자동차가_없으면_예외가_발생한다")
    void 생성_시_자동차가_없으면_예외가_발생한다() {

        // given
        List<RacingCar> arguments = List.of();

        // when & then
        assertThatThrownBy(() -> new RacingCars(arguments))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("validate() : 생성_시_이름이_같은_자동차가_있으면_예외가_발생한다")
    void 생성_시_이름이_같은_자동차가_있으면_예외가_발생한다() {

        // given
        RacingCar racingCar1 = new RacingCar("abc", mockedRacingCarValidator);
        RacingCar racingCar2 = new RacingCar("abc", mockedRacingCarValidator);

        List<RacingCar> arguments = List.of(racingCar1, racingCar2);

        // when & then
        assertThatThrownBy(() -> new RacingCars(arguments))
                .isInstanceOf(IllegalArgumentException.class);
    }


    @Test
    @DisplayName("move() : 모든_자동차를_움직인다")
    void 모든_자동차를_움직인다() {

        // given
        RandomNumberMaker moveableRandomNumberMaker = () -> RACING_CAR_MIN_MOVABLE_NUMBER;

        List<RacingCar> arguments = makeRacingCarList();
        RacingCars racingCars = new RacingCars(arguments);

        // when
        racingCars.move(moveableRandomNumberMaker);

        // then
        List<RacingCar> values = RacingCarsUtil.parseValues(racingCars);
        assertThat(values)
                .allMatch(car -> car.getPosition() != car.DEFAULT_POSITION);
    }

    @Test
    @DisplayName("getJoinedNames() : 모든_자동차의_이름을_구분자로_연결한다")
    void 모든_자동차의_이름을_구분자로_연결한다() {

        // given
        List<RacingCar> arguments = makeRacingCarList();

        String delimiter = ",";

        String expected = arguments.stream()
                .map(RacingCar::getName)
                .collect(Collectors.joining(delimiter));

        RacingCars racingCars = new RacingCars(arguments);

        // when
        String joinedNames = racingCars.getJoinedNames(delimiter);

        // then
        assertThat(joinedNames).isEqualTo(expected);
    }

    @Test
    @DisplayName("getCarNamesAndPositions() : 모든_자동차의_이름과_위치를_반환한다")
    void 모든_자동차의_이름과_위치를_반환한다() {

        // given
        List<RacingCar> arguments = makeRacingCarList();
        LinkedHashMap<String, Integer> expected = new LinkedHashMap<>();
        arguments.forEach(car -> expected.put(car.getName(), car.getPosition()));

        RacingCars racingCars = new RacingCars(arguments);

        // when
        LinkedHashMap<String, Integer> carNamesAndPositions = racingCars.getCarNamesAndPositions();

        // then
        assertThat(carNamesAndPositions).isEqualTo(expected);
    }

    @Test
    @DisplayName("getMaxPositionCars() : 최대_위치에_있는_자동차들을_반환한다")
    void 최대_위치에_있는_자동차들을_반환한다() {

        // given
        RacingCar car1 = new RacingCar("abc", mockedRacingCarValidator);
        RacingCar car2 = new RacingCar("abc1", mockedRacingCarValidator);
        RacingCar car3 = new RacingCar("abc2", mockedRacingCarValidator);

        car1.move(car1.MIN_MOVEABLE_NUMBER + 1);
        car2.move(car2.MIN_MOVEABLE_NUMBER + 1);

        RacingCars racingCars = new RacingCars(List.of(car1, car2, car3));

        // when
        RacingCars maxPositionCars = racingCars.getMaxPositionCars();

        // then
        List<RacingCar> values = RacingCarsUtil.parseValues(maxPositionCars);

        assertThat(values)
                .hasSize(2)
                .containsExactlyInAnyOrder(car1, car2);
    }

    private List<RacingCar> makeRacingCarList() {
        RacingCar car1 = new RacingCar("abc", mockedRacingCarValidator);
        RacingCar car2 = new RacingCar("abc1", mockedRacingCarValidator);
        RacingCar car3 = new RacingCar("abc2", mockedRacingCarValidator);

        return List.of(car1, car2, car3);
    }
}
