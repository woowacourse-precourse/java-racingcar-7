package racingcar;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RacingCarTest {
  @Test
  void 자동차이름_쉼표기준으로_나누기() {
      assertEquals(List.of("pobi","woni","jun"), RacingCar.makeNameList("pobi,woni,jun"));
      assertEquals(List.of("abcde","woni","jun"), RacingCar.makeNameList("abcde,woni,jun"));
      assertEquals(List.of("가나다라마","woni","jun"), RacingCar.makeNameList("가나다라마,woni,jun"));
      assertEquals(List.of("12345","woni","jun"), RacingCar.makeNameList("12345,woni,jun"));
      assertEquals(List.of("월","woni","jun"), RacingCar.makeNameList("월,woni,jun"));
      assertEquals(List.of(";=;","월","jun"), RacingCar.makeNameList(";=;,월,jun"));
  }

  @DisplayName(",를 기준으로 구분했을 때 빈문자열이 있으면 오류")
  @Test
  void 자동차이름_잘못된_입력() {
      assertThrows(IllegalArgumentException.class, ()  -> RacingCar.makeNameList(""));
      assertThrows(IllegalArgumentException.class, ()  -> RacingCar.makeNameList("pobi,,woni,jun"));
      assertThrows(IllegalArgumentException.class, ()  -> RacingCar.makeNameList(",pobi,woni,jun"));
      assertThrows(IllegalArgumentException.class, ()  -> RacingCar.makeNameList("pobi,woni,jun,"));
  }

  @Test
  void 자동차이름_5자_제한_확인() {
      assertThrows(IllegalArgumentException.class, () -> RacingCar.makeNameList("abcdef,pobi,jun"));
      assertThrows(IllegalArgumentException.class, () -> RacingCar.makeNameList("가나다라마바,pobi,jun"));
      assertThrows(IllegalArgumentException.class, () -> RacingCar.makeNameList("123456,pobi,jun"));
  }


}