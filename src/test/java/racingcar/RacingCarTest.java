package racingcar;

import java.util.ArrayList;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class RacingCarTest {

    private static final RacingCar racingCar = new RacingCar();

    @Test
    public void 자동차이름목록_쉼표기준분리_테스트() throws Exception {
        //Given
        String carNames = "pobi,woni,jun";

        List<String> expectedCarList = new ArrayList<>();
        expectedCarList.add("pobi");
        expectedCarList.add("woni");
        expectedCarList.add("jun");
        int expectedSize = expectedCarList.size();

        //When
        List<String> carList = racingCar.splitCarNamesByComma(carNames);

        //Then
        Assertions.assertThat(carList.size()).isEqualTo(expectedSize);
        Assertions.assertThat(carList).containsExactlyElementsOf(expectedCarList);
    }

    @Test
    public void 자동차이름목록_쉼표_외_문자기준분리_테스트() throws Exception {
        //Given
        String carNames = "pobi,woni:jun";
        int expectedSize = 2;

        //When
        List<String> carList = racingCar.splitCarNamesByComma(carNames);

        //Then
        Assertions.assertThat(carList.size()).isEqualTo(expectedSize);
    }

    @Test
    public void 자동차이름_5글자이하_테스트() throws Exception {
        //Given
        String carName = "pobi";

        //When, Then
        Assertions.assertThatCode(() -> racingCar.validateCarName(carName))
                .doesNotThrowAnyException();
    }

    @Test
    public void 자동차이름_5글자초과_예외테스트() throws Exception {
        //Given
        String carName = "woni:jun";

        //When, Then
        Assertions.assertThatThrownBy(() -> racingCar.validateCarName(carName))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void 빈_자동차이름_예외테스트() throws Exception {
        //Given
        String carName = "";

        //When, Then
        Assertions.assertThatThrownBy(() -> racingCar.validateCarName(carName))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void 자동차이름목록_쉼표기준분리_5글자이하_테스트() throws Exception {
        //Given
        String carNames = "pobi,woni,jun";

        List<String> expectedCarList = new ArrayList<>();
        expectedCarList.add("pobi");
        expectedCarList.add("woni");
        expectedCarList.add("jun");
        int expectedSize = expectedCarList.size();

        //When
        List<String> carList = racingCar.splitCarNamesByComma(carNames);

        //Then
        Assertions.assertThat(carList.size()).isEqualTo(expectedSize);
        for (String carName : carList) {
            Assertions.assertThatCode(() -> racingCar.validateCarName(carName))
                    .doesNotThrowAnyException();
        }
    }

    @Test
    public void 자동차이름목록_쉼표_외_문자기준분리_5글자이하_예외테스트() throws Exception {
        //Given
        String carNames = "pobi,woni:jun";
        int expectedSize = 2;

        //When
        List<String> carList = racingCar.splitCarNamesByComma(carNames);

        //Then
        Assertions.assertThat(carList.size()).isEqualTo(expectedSize);
        Assertions.assertThatCode(() -> racingCar.validateCarName(carList.get(0)))
                .doesNotThrowAnyException();
        Assertions.assertThatThrownBy(() -> racingCar.validateCarName(carList.get(1)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void 자동차이름_중복허용_테스트() throws Exception {
        //Given
        String carNames = "pobi,pobi,pobi";

        List<String> expectedCarList = new ArrayList<>();
        expectedCarList.add("pobi");
        expectedCarList.add("pobi");
        expectedCarList.add("pobi");
        int expectedSize = expectedCarList.size();

        //When
        List<String> carList = racingCar.splitCarNamesByComma(carNames);

        //Then
        Assertions.assertThat(carList.size()).isEqualTo(expectedSize);
        for (String carName : carList) {
            Assertions.assertThatCode(() -> racingCar.validateCarName(carName))
                    .doesNotThrowAnyException();
        }
    }
}