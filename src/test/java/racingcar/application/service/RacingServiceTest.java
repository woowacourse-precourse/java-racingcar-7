package racingcar.application.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.*;
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
  void getWinners() {
    RacingService racingService = new RacingService();
    racingService.setup("pobi,woni,jun", 5);

    racingService.playRound();

    List<String> winners = racingService.getWinners();

    assertTrue(winners.size() >= 1 && winners.size() <= 3);

    List<String> initialCarNames = List.of("pobi", "woni", "jun");
    for (String winner : winners) {
      assertTrue(initialCarNames.contains(winner));
    }
  }
}
