package racingcar.Model;
import java.util.ArrayList;

public interface RacingRule {

  boolean goOrStop();

  ArrayList<String> pickWinner();
}
