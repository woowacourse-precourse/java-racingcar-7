package racingcar;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class InputTest {

  Input input;

  @BeforeEach
  void setUp() {
    input = new Input();

  }
  @DisplayName("유저가 자동차 이름을 입력한다")
  @ParameterizedTest
  @ValueSource(strings = { "pobi,woni" })
  void inputCarNamesTest() throws Exception{
      //given
    String expect = "pobi,woni";

      //when
    String actual = input.getInputCarNames();

    //then
    assertEquals(expect,actual);
  }
//  @DisplayName("유저가 게임 시도 횟수를 입력한다")
//  @ParameterizedTest
//  public void inputPlayCountsTest() throws Exception{
//    //given
//    int playCount = 3;
//
//    //when
//    input.inputPlayCounts(playCount);
//
//    //then
//  }


}