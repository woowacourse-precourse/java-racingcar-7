package racingcar.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarModelTest {
    private RacingCarModel racingCarModel;

    @BeforeEach
    void beforeEach(){
        racingCarModel = new RacingCarModel();
    }

    @Test
    @DisplayName("입력받은 자동차 이름 문자열을 ','기준으로 나누어 리스트로 반환한다")
    void setCarNameListTest(){
        //given
        String carNameString = "pobi,woni,jun";

        //when
        racingCarModel.setCarNameList(carNameString);
        List<String> carNameList = racingCarModel.getCarNameList();

        //then
        assertThat(carNameList).contains("pobi", "woni", "jun");
    }

    @Test
    @DisplayName("자동차 이름의 맨 앞과 뒤의 공백을 제거하고 저장하는지 확인한다")
    void setCarNameListTest2(){
        //given
        String carNameString = "  pobi ,woni   ,jun";

        //when
        racingCarModel.setCarNameList(carNameString);
        List<String> carNameList = racingCarModel.getCarNameList();

        //then
        assertThat(carNameList).contains("pobi", "woni", "jun");
    }

    @Test
    @DisplayName("자동차가 전진했을 시 그에 따라 value 값을 1씩 증가시킨다")
    void updateCarMapTest(){
        //given
        String carName = "pobi";
        int forwardCount = 0;

        //when
        racingCarModel.addRacingCar(carName, forwardCount);
        racingCarModel.updateCarMap(carName);

        //then
        int updatedForwardCount = racingCarModel.getForwardCount(carName);
        assertThat(updatedForwardCount).isEqualTo(1);
    }


    @Test
    @DisplayName("최종 우승자 리스트가 적절히 반환되는지 확인한다")
    void getWinnerListTest(){
        //given
        String carNameString = "pobi,woni,jun";

        //when
        racingCarModel.setCarNameList(carNameString);
        racingCarModel.setCarHashMap();
        racingCarModel.updateCarMap("woni");
        racingCarModel.updateCarMap("jun");

        //then
        List<String> winnerList = racingCarModel.getWinnerList();
        assertThat(winnerList).contains("woni", "jun");

    }

    @Test
    @DisplayName("모든 자동차의 전진 횟수가 0이면 모두가 공동 우승자가 되는지 확인한다")
    void getWinnerListTest2(){
        //given
        String carNameString = "pobi,woni,jun";

        //when
        racingCarModel.setCarNameList(carNameString);
        racingCarModel.setCarHashMap();
        List<String> winnerList = racingCarModel.getWinnerList();

        //then
        assertThat(winnerList).contains("pobi", "woni", "jun");

    }




}
