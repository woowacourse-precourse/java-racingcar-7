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

    @Test
    public void 우승자_테스트() throws Exception {
        //Given
        CarRacing carRacing = new CarRacing();
        List<Car> carList = new ArrayList<>();
        Car pobi = new Car("pobi");
        Car woni = new Car("woni");
        Car jun = new Car("jun");

        for (int i = 0; i < 4; i++) {
            pobi.forwardOrStop(4);
        }
        for (int i = 0; i < 3; i++) {
            woni.forwardOrStop(4);
        }
        for (int i = 0; i < 2; i++) {
            jun.forwardOrStop(4);
        }
        carList.add(pobi);
        carList.add(woni);
        carList.add(jun);

        String expected = "최종 우승자 : pobi";
        //When
        String winner = carRacing.winner(carList);

        //Then
        Assertions.assertThat(winner).isEqualTo(expected);
    }

    @Test
    public void 공동_우승자_테스트() throws Exception {
        //Given
        CarRacing carRacing = new CarRacing();
        List<Car> carList = new ArrayList<>();
        Car pobi = new Car("pobi");
        Car woni = new Car("woni");
        Car jun = new Car("jun");

        for (int i = 0; i < 4; i++) {
            pobi.forwardOrStop(4);
            woni.forwardOrStop(4);
            jun.forwardOrStop(4);
        }
        carList.add(pobi);
        carList.add(woni);
        carList.add(jun);

        String expected = "최종 우승자 : pobi,woni,jun";
        //When
        String winner = carRacing.winner(carList);

        //Then
        Assertions.assertThat(winner).isEqualTo(expected);
    }
}