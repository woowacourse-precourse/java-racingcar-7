package racingcar.model;
import java.util.ArrayList;

public interface RacingRule {

  boolean goOrStop();

  ArrayList<String> pickWinner();
}
