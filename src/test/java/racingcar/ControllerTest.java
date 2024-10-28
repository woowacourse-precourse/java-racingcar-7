package racingcar;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ControllerTest {
  private Input input;

  Input input = new Input();
  input

  Controller controller = new Controller();

  @DisplayName("자동차 이름과 시도횟수를 전달받으면 각 자동차를 전진시킨다")
  @Test
  public void moveForwardCars() throws Exception{
      //given
      // 자동자 이름과 시도횟수를 전달받으면
      String readCars = "pobi,woni";
      String readCounts = "pobi,woni";
      String inputCarNames = input.inputCarNames(readCars);
      int inputPlayCounts = input.inputPlayCounts(readCounts);

      //when
      // 각 자동차를 시도횟수만큼 전진시킨다
      moveForwardCars(inputPlayCounts);

      //then
  }

  @DisplayName("0~9 랜덤값을 생성하여 결과가 4이상인 경우 전진을 결정한다")
  @Test
  public void moveOrNotTest() throws Exception{
      //given
    int randoms = controller.moveOrNot();
    boolean actual = randoms >= 4;
    boolean expect = true;

      //when



      //then
    assertEquals(expect, actual);
  }

  // 전진 수가 결정되면 각 자동차 별로 전진 수를 할당한다
  @DisplayName("전진 수가 결정되면 각 자동차 별로 전진 수를 할당한다")
  @Test
  void setMoveCountsTest() {

  }

  @DisplayName("자동차 게임 실행 결과를 내림차순으로 정렬한다")
  @Test
  public void reverseOrderResultTest() throws Exception{
    //given
    String expect = "pobi";
    String actual = controller.reverseOrderResult();

    //when

    //then
    assertEquals(expect, actual);
  }

}