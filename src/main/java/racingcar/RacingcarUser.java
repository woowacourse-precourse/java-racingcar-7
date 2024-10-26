package racingcar;

import java.util.List;

public class RacingcarUser {

    private RaceManagerInterface raceManager;
    private final ReaderInterface reader = new Reader();
    private final DisplayerInterface displayer = new Displayer();

    private List<String> names;
    private int attempt;

    private List<List<String>> raceLog;
    private List<String> winners;


    public void setRace() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        names = reader.getNameInput();
        System.out.println("시도할 횟수는 몇 회인가요?");
        attempt = reader.getTryInput();
    }

    public void startRace() {
        raceManager = new RaceManager(names);

        raceManager.doRace(attempt);

        raceLog = raceManager.getLog();

        winners = raceManager.getWinner();
    }

    public void showResult() {
        displayer.showLog(raceLog);

        displayer.showWinner(winners);
    }
}
