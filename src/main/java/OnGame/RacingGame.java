package OnGame;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.Map;
import java.util.List;

public class RacingGame {
    private Map<RacingCar, Integer> score;
    private final UserInterface print;

    public RacingGame() {
        this.print = new UserInterface();
    }

    public void gameStart() {
        final String[] carName = print.getCarName();

        score = initScore(carName);
        final Racing round = Racing.of(print.getCount());

        print.printRacingResult();

        for(int i = 0; i < round.getValue(); i++) {
            RoundPlay();
        }

        List<String> winners = victory(score);
        print.printWinner(winners);
    }

    private void RoundPlay() {
        score.forEach((key, value) -> {
            int count = regulate(Randoms.pickNumberInRange(0, 9));
            print.printScore(key.getName(), count);
            score.put(key, value + count);
        });
        System.out.println();
    }

    private List<String> victory(final Map<RacingCar, Integer> score) {
        final int maxCount = score.values().stream()
                .max(Integer::compareTo)
                .orElse(0);

        return score.entrySet().stream()
                .filter(entry -> entry.getValue() >= maxCount)
                .map(entry -> entry.getKey().getName())
                .toList();
    }
    private int regulate(final int randomNum){
        int goOrNot = 0;

        if(randomNum >= 4) {
            goOrNot = 1;
        }

        return goOrNot;
    }

    private Map<RacingCar, Integer> initScore(final String[] carNames) {
        return Arrays.stream(carNames)
                .collect(Collectors.toMap(RacingCar::new, carName -> 0, (a, b) -> b));
    }
}
