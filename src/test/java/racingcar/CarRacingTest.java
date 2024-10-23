package racingcar;

import java.util.ArrayList;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class CarRacingTest {


    @Test
    public void 자동차이름목록_쉼표기준분리_5글자이하_테스트() throws Exception {
        //Given
        CarRacing carRacing = new CarRacing();
        String carNames = "pobi,woni,jun";

        List<Car> expectedCarList = new ArrayList<>();
        expectedCarList.add(new Car("pobi"));
        expectedCarList.add(new Car("woni"));
        expectedCarList.add(new Car("jun"));
        int expectedSize = expectedCarList.size();

        //When, Then
        Assertions.assertThatCode(() -> carRacing.parseCarList(carNames))
                .doesNotThrowAnyException();
        Assertions.assertThat(carRacing.getCarList().size()).isEqualTo(expectedSize);
    }

    @Test
    public void 자동차이름목록_쉼표_외_문자기준분리_5글자이하_예외테스트() throws Exception {
        //Given
        CarRacing carRacing = new CarRacing();
        String carNames = "pobi,woni:jun";

        //When
        Assertions.assertThatThrownBy(() -> carRacing.parseCarList(carNames))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void 자동차이름_중복허용_테스트() throws Exception {
        //Given
        CarRacing carRacing = new CarRacing();
        String carNames = "pobi,pobi,pobi";

        List<Car> expectedCarList = new ArrayList<>();
        expectedCarList.add(new Car("pobi"));
        expectedCarList.add(new Car("pobi"));
        expectedCarList.add(new Car("pobi"));
        int expectedSize = expectedCarList.size();

        //When, Then
        Assertions.assertThatCode(() -> carRacing.parseCarList(carNames))
                .doesNotThrowAnyException();
        Assertions.assertThat(carRacing.getCarList().size()).isEqualTo(expectedSize);
    }

    @Test
    public void 시도횟수_테스트() throws Exception {
        //Given
        CarRacing carRacing = new CarRacing();
        String attempts = "5";

        //When, Then
        Assertions.assertThatCode(() -> carRacing.parseAttempts(attempts))
                .doesNotThrowAnyException();
    }

    @Test
    public void 시도횟수_int범위초과_예외테스트() throws Exception {
        //Given
        CarRacing carRacing = new CarRacing();
        String attempts = Long.toString(Long.MAX_VALUE);

        //When, Then
        Assertions.assertThatThrownBy(() -> carRacing.parseAttempts(attempts))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void 시도횟수_음수_예외테스트() throws Exception {
        //Given
        CarRacing carRacing = new CarRacing();
        String attempts = "-1";

        //When, Then
        Assertions.assertThatThrownBy(() -> carRacing.parseAttempts(attempts))
                .isInstanceOf(IllegalArgumentException.class);
    }
}