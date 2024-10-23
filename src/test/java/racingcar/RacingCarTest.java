package racingcar;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;

class RacingCarTest {
  @Test
  void 자동차이름_쉼표기준으로_나누기() {
      assertEquals(List.of("pobi","woni","jun"), RacingCar.makeNameList("pobi,woni,jun"));
      assertEquals(List.of("월","woni","jun"), RacingCar.makeNameList("월,woni,jun"));
      assertEquals(List.of(";=;","월","jun"), RacingCar.makeNameList(";=;,월,jun"));
      assertEquals(List.of("hi","+=+","jun"), RacingCar.makeNameList("hi,,+=+,jun"));
  }
}