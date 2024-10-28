package util;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import dto.RacingParam;
import java.util.ArrayList;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import repository.CarRepository;

class ExtractorTest {
    private Car car;
    private Car car2;
    private Car car3;

    @BeforeEach
    void beforeEach() {
        this.car = new Car("car1");
        this.car2 = new Car("car2");
        this.car3 = new Car("car3");
        ArrayList<Car> cars = new ArrayList<>();

        car.moveForward();
        car.moveForward();
        car.moveForward();
        car.moveForward();

        car2.moveForward();
        car2.moveForward();
        car2.moveForward();
        car2.moveForward();

        car3.moveForward();
        car3.moveForward();
        car3.moveForward();
        car3.doNotMoveForward();

        cars.add(car);
        cars.add(car2);
        cars.add(car3);

        RacingParam racingParam = new RacingParam(cars, 4);
        CarRepository.saveCarsAndRepeatCount(racingParam);
    }

    @Test
    void extractCarList() {
        // 기능이 합쳐져 있으니까 어떻게 짜야할지 막막하네...

        // given
        String example1 = "pobi,java";
        String 공백포함 = "pob1, java";
        String 다섯글자초과 = "pob1,javajigi";
        String 자동차이름미입력 = "";
        String 중복입력 = "pobi,pobi";
        String 이중컴마 = "pobi,,java";

        // when

        // then
        // 정상입력
        ArrayList<String> expect1 = new ArrayList<>();
        expect1.add("pobi");
        expect1.add("java");
        Assertions.assertThat(Extractor.extractCarList(example1)).isEqualTo(expect1);

        // 예외상황
        assertSimpleTest(() ->
                assertThatThrownBy(() -> Extractor.extractCarList(공백포함))
                        .isInstanceOf(IllegalArgumentException.class)
        );
        assertSimpleTest(() ->
                assertThatThrownBy(() -> Extractor.extractCarList(다섯글자초과))
                        .isInstanceOf(IllegalArgumentException.class)
        );
        assertSimpleTest(() ->
                assertThatThrownBy(() -> Extractor.extractCarList(자동차이름미입력))
                        .isInstanceOf(IllegalArgumentException.class)
        );
        assertSimpleTest(() ->
                assertThatThrownBy(() -> Extractor.extractCarList(중복입력))
                        .isInstanceOf(IllegalArgumentException.class)
        );
        assertSimpleTest(() ->
                assertThatThrownBy(() -> Extractor.extractCarList(이중컴마))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void extractMaxDistance() {
        // given
        int expectedMax = 4;

        // then
        Assertions.assertThat(Extractor.extractMaxDistance()).isEqualTo(expectedMax);
    }

    @Test
    void extractWinningCarList() {
        ArrayList<String> winningCarList = new ArrayList<>();

        winningCarList.add("car1");
        winningCarList.add("car2");

        Assertions.assertThat(Extractor.extractWinningCarList()).isEqualTo(winningCarList);
    }

    @Test
    void extractRaceStatus() {
        // given
        int forwardCount = 4;
        String result = "----";

        // then
        Assertions.assertThat(Extractor.extractRaceStatus(forwardCount))
                .isEqualTo(result);
    }

    @Test
    void extractRepeatCount() {
        // 여기서 validatior 예외체크를 하는게 맞나...
        String successInput = "10";
        String 빈값 = "";
        String 큰수 = "100000000000000000000000000000000000000000000000000000";
        String 문자 = "aa";
        String 음수 = "-10";

        Assertions.assertThat(Extractor.extractRepeatCount(successInput)).isEqualTo(10);

        assertSimpleTest(() ->
                assertThatThrownBy(() -> Extractor.extractRepeatCount(빈값))
                        .isInstanceOf(IllegalArgumentException.class)
        );
        assertSimpleTest(() ->
                assertThatThrownBy(() -> Extractor.extractRepeatCount(큰수))
                        .isInstanceOf(IllegalArgumentException.class)
        );
        assertSimpleTest(() ->
                assertThatThrownBy(() -> Extractor.extractRepeatCount(문자))
                        .isInstanceOf(IllegalArgumentException.class)
        );
        assertSimpleTest(() ->
                assertThatThrownBy(() -> Extractor.extractRepeatCount(음수))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

}