package racingcar.view;

public class OutputView implements View {

    private static final String OUTPUT_WINNER_MESSAGE = "최종 우승자 : ";

    @Override
    public void print() {
        System.out.print(OUTPUT_WINNER_MESSAGE);
    }

    public void printWinner(String winnerList) {
        System.out.println(winnerList);
    }
}
