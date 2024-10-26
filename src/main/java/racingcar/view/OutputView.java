package racingcar.view;

public class OutputView {
    public void startRacePhase() {
        System.out.println("\n실행 결과");
    }

    public void printProgress(String name, int progress) {
        String progressBar = "";
        for (int i = 0; i < progress; i++) {
            progressBar = progressBar + "-";
        }
        System.out.println(name + " : " + progressBar);
    }

    public void printBlank() {
        System.out.println("");
    }
}
