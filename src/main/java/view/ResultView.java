package view;

import java.util.List;

public class ResultView {
    private final static String WINNER_MESSAGE = "최종우승자 : ";

    public void getWinners(List<String> winners) {
        System.out.println(WINNER_MESSAGE + String.join(", ",winners));
    }
}
