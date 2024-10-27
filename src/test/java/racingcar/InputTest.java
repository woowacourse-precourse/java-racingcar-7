package racingcar;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;

class InputTest {

  Input input;
  @DisplayName("유저가 자동차 이름을 입력한다")
  @ParameterizedTest
  public void inputCarNamesTest() throws Exception{
      //given
    String cars = "pobi,woni";

      //when
    input.inputCarNames(cars);


      //then
  }
  @DisplayName("유저가 게임 시도 횟수를 입력한다")
  @ParameterizedTest
  public void inputPlayCountsTest() throws Exception{
    //given
    int playCount = 3;

    //when
    input.inputPlayCounts(playCount);

    //then
  }


}