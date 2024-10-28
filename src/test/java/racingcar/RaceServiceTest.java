package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;
import racingcar.model.RaceService;
import racingcar.util.Converter;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RaceServiceTest {

    private RaceService raceService = new RaceService();
    private Converter converter = new Converter();

    @Test
    @DisplayName("자동차 리스트 생성 테스트")
    void createCarList() {
        // 직접 입력값 설정
        String inputCarList = "pobi,woni,conn";
        String[] carNameList = raceService.parseCarNames(inputCarList);
        List<Car> carList = raceService.convertToCarList(carNameList);

        assertThat(carList).hasSize(3);
        assertThat(carList.get(0).getName()).isEqualTo("pobi");
        assertThat(carList.get(1).getName()).isEqualTo("woni");
        assertThat(carList.get(2).getName()).isEqualTo("conn");
    }

    @Test
    @DisplayName("시도 횟수 입력 테스트")
    void getTryCount() {
        // 직접 입력값 설정
        String inputTryCnt = "5";
        int tryCount = converter.convertTryCnt(inputTryCnt);

        assertThat(tryCount).isEqualTo(5);
    }

}
