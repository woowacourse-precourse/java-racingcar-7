package racingcar;

public class Race {
    private final int numberOfTime;
    private final Racers racers;

    public Race(String inputNumber, Racers racers) {
        this.numberOfTime = Validation.validateNumber(inputNumber);
        this.racers = racers;
    }

    public void run() {
        System.out.println("실행 결과");
        for (int i = 0; i < numberOfTime; i++) {
            racers.go();
            View.outputRace(racers);
            System.out.println();
        }

        Winners.winners(racers);
    }
}
