//package racingcar.module;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.RepeatedTest;
//import racingcar.user.UserObject;
//
//public class GameEngineTest {
//    private GameEngine gameEngine;
//    private UserObject user;
//    private int initialScore;
//
//    @BeforeEach
//    public void setUp() {
//        gameEngine = new GameEngine();
//        user = new UserObject("TestUser");
//        initialScore = user.getUserScoreNum();
//    }
//
//    @RepeatedTest(10)
//    public void testScoreUpdate() {
//        // randomNum 값을 생성
//        gameEngine.extractRandom();
//        // randomNum이 4 이상이면 점수가 증가하는지 확인
//        if (gameEngine.randomNum >= 4) {
//            gameEngine.scoreUpdate(user);
//            assertEquals(initialScore + 1, user.getUserScoreNum());
//        } else {
//            assertEquals(initialScore, user.getUserScoreNum());
//        }
//    }
//
//}
