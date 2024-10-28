package racingcar.application.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RacingServiceTest {

  @Test
  void setup() {
    RacingService racingService = new RacingService();
    String inputCarNames = "pobi,woni,jun";
    int inputAttemptCount = 5;

    racingService.setup(inputCarNames, inputAttemptCount);

    assertEquals(5, racingService.getAttemptCount());
    assertEquals(3, racingService.playRound().size());
  }

  @Test
  void playRound() {
  }

  @Test
  void getWinners() {
  }
}
