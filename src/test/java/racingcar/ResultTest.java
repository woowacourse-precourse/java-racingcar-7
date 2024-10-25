package racingcar;

import org.junit.jupiter.api.Test;
import utility.Result;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;

public class ResultTest {
    private static final List<String> CARS = new ArrayList<>(Arrays.asList("Hi", "Hello", "Woowa"));
    private static final List[] PROGRESS = {
            new ArrayList<>(Arrays.asList(1, 3, 7)),
            new ArrayList<>(Arrays.asList(1, 3, 3)),
            new ArrayList<>(Arrays.asList(3, 3, 3))
    };
    private static final String[] ANSWER_ONGOING = {
            "Hi : -\nHello : ---\nWoowa : ------",
            "Hi : -\nHello : ---\nWoowa : ---",
            "Hi : ---\nHello : ---\nWoowa : ---"
    };
    private static final String[] ANSWER_WINNER = {
            "최종 우승자 : Woowa",
            "최종 우승자 : Hello, Woowa",
            "최종 우승자 : Hi, Hello, Woowa"
    };

    @Test
    void printTest() {
        assertSimpleTest(() -> {
            for (int i = 0; i < PROGRESS.length; i++) {
                String[] result = runMain(CARS, PROGRESS[i]);
                String answerOngoing = ANSWER_ONGOING[i];
                String answerWinner = ANSWER_WINNER[i];

                printResult(result[0].contains(answerOngoing), result[1].contains(answerWinner));

                Result.setOngoing("");
                Result.setWinner("");
                Result.setIdxMax(0);
            }
        });
    }

    void printResult(boolean result1, boolean result2) {
        if (result1 && result2) {
            System.out.println("Success");
        } else {
            System.out.println("Fail");
        }
    }

    public String[] runMain(List<String> cars, List<Integer> progress) {
        return Result.test(cars, progress);
    }
}
