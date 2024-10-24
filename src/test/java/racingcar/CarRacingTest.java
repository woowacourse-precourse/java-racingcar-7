package racingcar;

import java.util.ArrayList;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.accelerator.Accelerator;
import racingcar.accelerator.BrokenAccelerator;

class CarRacingTest {

    private final Accelerator accelerator = new BrokenAccelerator();

    private Car createCar(String carName) {
        return new Car(carName, accelerator);
    }

    @Test
    public void 자동차이름목록_쉼표기준분리_5글자이하_테스트() throws Exception {
        //Given
        CarRacing carRacing = new CarRacing();
        String carNames = "pobi,woni,jun";

        List<Car> expectedCarList = new ArrayList<>();
        expectedCarList.add(createCar("pobi"));
        expectedCarList.add(createCar("woni"));
        expectedCarList.add(createCar("jun"));
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
        expectedCarList.add(createCar("pobi"));
        expectedCarList.add(createCar("pobi"));
        expectedCarList.add(createCar("pobi"));
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
        Car pobi = new Car("pobi", accelerator);
        Car woni = new Car("woni", accelerator);
        Car jun = new Car("jun", accelerator);

        pobi.setMileageForTest(4);
        woni.setMileageForTest(3);
        jun.setMileageForTest(2);

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
        Car pobi = new Car("pobi", accelerator);
        Car woni = new Car("woni", accelerator);
        Car jun = new Car("jun", accelerator);

        pobi.setMileageForTest(4);
        woni.setMileageForTest(4);
        jun.setMileageForTest(4);

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