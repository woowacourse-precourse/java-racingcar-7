package view;

import java.util.List;

public class WinnerOutputView {
  public List<String> winnerList;

  public void showWinner(List<String> winnerList) {
    final String delimiter = ", ";
    final String winners = String.join(delimiter, winnerList);
    System.out.println("최종 우승자 : " + winners);
  }
}
