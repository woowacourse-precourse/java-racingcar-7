package racingcar;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarNamesTest {
  @Test
  void 자동차이름_쉼표기준으로_나누기() {
      assertEquals(List.of("pobi","woni","jun"), CarNames.createList("pobi,woni,jun"));
      assertEquals(List.of("abcde","woni","jun"), CarNames.createList("abcde,woni,jun"));
      assertEquals(List.of("가나다라마","woni","jun"), CarNames.createList("가나다라마,woni,jun"));
      assertEquals(List.of("12345","woni","jun"), CarNames.createList("12345,woni,jun"));
      assertEquals(List.of("월","woni","jun"), CarNames.createList("월,woni,jun"));
      assertEquals(List.of(";=;","월","jun"), CarNames.createList(";=;,월,jun"));
  }

  @DisplayName(",를 기준으로 구분했을 때 빈문자열이 있으면 오류")
  @Test
  void 자동차이름_잘못된_입력() {
      assertThrows(IllegalArgumentException.class, ()  -> CarNames.createList(""));
      assertThrows(IllegalArgumentException.class, ()  -> CarNames.createList("pobi,,woni,jun"));
      assertThrows(IllegalArgumentException.class, ()  -> CarNames.createList(",pobi,woni,jun"));
      assertThrows(IllegalArgumentException.class, ()  -> CarNames.createList("pobi,woni,jun,"));
  }

  @Test
  void 자동차이름_5자_제한_확인() {
      assertThrows(IllegalArgumentException.class, () -> CarNames.createList("abcdef,pobi,jun"));
      assertThrows(IllegalArgumentException.class, () -> CarNames.createList("가나다라마바,pobi,jun"));
      assertThrows(IllegalArgumentException.class, () -> CarNames.createList("123456,pobi,jun"));
  }
}
