package racingcar.view;

import java.util.List;

public class OutputView {

  static public void printCarPosition(String name, int position) {
    System.out.println(name + " : " + "-".repeat(position));
  }

  static public void printWinner(List<String> winners) {

    System.out.print("최종 우승자 : ");

    int winnersLen = winners.size();
    for (int i = 0; i < winnersLen; i++) {
      System.out.print(winners.get(i));

      if (i < winnersLen - 1) {
        System.out.print(", ");
      }
    }

  }

  static public void printSeparator() {
    System.out.println("------------------------------");
  }
}
