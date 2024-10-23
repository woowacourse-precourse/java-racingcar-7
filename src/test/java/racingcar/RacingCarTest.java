package racingcar;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RacingCarTest {
  @Test
    void makeCarNameList(String str) {
      assertEquals(["pobi","woni","jun"], str.split(","));
  }
}