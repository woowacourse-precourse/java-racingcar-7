package racingcar.module;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.user.UserObject;

public class WinnerSelectorTest {
    private UserObject[] users;
    private List<String> topScorerNames;
    private int maxRandomValue;
    private Random random;

    @BeforeEach
    public void setUp() {
        random = new Random();
        topScorerNames = new ArrayList<>();
        maxRandomValue = Integer.MIN_VALUE;

        users = new UserObject[]{
                new UserObject("Alice"),
                new UserObject("Bob"),
                new UserObject("Charlie"),
                new UserObject("David")
        };

        // 각 유저마다 랜덤값 n을 생성하고 점수를 n씩 올림
        for (UserObject user : users) {
            int n = random.nextInt(10) + 1;
            for (int i = 0; i < n; i++) {
                user.updateUserScore();
            }
            System.out.println("User: " + user.getUserName() + ", 점수: " + user.getUserScoreNum());

            // 최고 점수를 가진 유저 이름
            if (n > maxRandomValue) {
                maxRandomValue = n;
                topScorerNames.clear();
                topScorerNames.add(user.getUserName());
            } else if (n == maxRandomValue) {
                topScorerNames.add(user.getUserName());
            }
        }
        for (String name : topScorerNames) {
            System.out.println(name);
        }
    }

    @Test
    public void testGetTopScores() {
        WinnerSelector selector = new WinnerSelector(users);
        List<String> resultTopScorers = selector.getTopScores();
        // 예상과 실제 비교
        assertEquals(topScorerNames, resultTopScorers);
    }
}
