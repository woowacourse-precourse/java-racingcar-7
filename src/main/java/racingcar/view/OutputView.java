package racingcar.view;

public class OutputView implements View {

    private final String winners;

    public OutputView(String winners) {
        this.winners = winners;
    }

    private void printWinners() {
        String announcement = "최종 우승자 : ";
        System.out.println(announcement + winners);
    }

    @Override
    public void printView() {
        printWinners();
    }
}
