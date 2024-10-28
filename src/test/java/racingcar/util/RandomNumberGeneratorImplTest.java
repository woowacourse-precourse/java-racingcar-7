package racingcar.util;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

/**
 * @author : jiffyin7@gmail.com
 * @since : 24. 10. 28.
 */
class RandomNumberGeneratorImplTest {

  private RandomNumberGenerator randomNumberGenerator;

  @BeforeEach
  void setUp(){
    randomNumberGenerator = new RandomNumberGeneratorImpl();
  }

  @DisplayName("생성된 난수는 0 이상 9 이하여야 한다")
  @Test
  @RepeatedTest(100)
  void generate() {
    int generatedNumber = randomNumberGenerator.generate();
    assertTrue(generatedNumber >= 0 && generatedNumber <= 9);
  }
}