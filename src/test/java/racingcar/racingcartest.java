package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.io.ByteArrayInputStream;
import java.util.LinkedHashMap;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class racingcartest {
    private LinkedHashMap<String, Integer> carNameAndScore;
    private static class FixedRandomRacingGame extends RacingGame {
        private final int fixedNumber;

        public FixedRandomRacingGame(LinkedHashMap<String, Integer> carNameAndScore, int tryCount, int fixedNumber) {
            super(carNameAndScore, tryCount);
            this.fixedNumber = fixedNumber;
        }

        @Override
        protected int getRandomNumber() {
            return fixedNumber;
        }
    }


    @BeforeEach
    void setup() {
        carNameAndScore = new LinkedHashMap<>();
        carNameAndScore.put("harua", 0);
        carNameAndScore.put("nico", 0);
        carNameAndScore.put("ej", 0);
    }

    @Test
    @DisplayName("자동차 이름 입력, 5자 이하 영문")
    void carNameInput() {
        System.setIn(new ByteArrayInputStream("".getBytes()));

        assertThatThrownBy(() -> {
            Input.inputCarName();
        }).isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("자동차 이름은 공백일 수 없습니다.");
    }

    @Test
    @DisplayName("자동차 이름 쉼표로 구분")
    void carNameSplit() {
        String carNames = "harua,nico,ej";
        String[] names = carNames.split(",");
        assertThat(names).containsExactly("harua", "nico", "ej");
    }

    @Test
    @DisplayName("중복된 자동차 이름 불가")
    void duplicateCarName() {
        String input = "nico,EJ,nico";
        System.setIn(new java.io.ByteArrayInputStream(input.getBytes())); // Console 입력 모의

        assertThatThrownBy(CarInformation::getCarInformation)
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("자동차 이름은 중복되지 않아야 합니다.");
    }

    @Test
    @DisplayName("랜덤함수, 4이상인 경우 전진")
    void randomMoveForward() {
        int randomNumber = 4;
        if (randomNumber >= 4) {
            carNameAndScore.put("ej", carNameAndScore.get("ej") + 1);
        }
        assertThat(carNameAndScore.get("ej")).isEqualTo(1);
    }

//    @Test
//    @DisplayName("랜덤함수, 4미만인 경우 정지")
//    void randomMoveStop() {
//        LinkedHashMap<String, Integer> carNameAndScore = new LinkedHashMap<>();
//        carNameAndScore.put("Nico", 0);
//
//        RacingGame game = new RacingGame(carNameAndScore, 1);
//        game.randomMove(); // 랜덤 값을 제어하여 테스트의 일관성 보장
//        assertThat(carNameAndScore.get("Nico")).isEqualTo(0);
////        int randomNumber = 3;
////        if (randomNumber < 4) {
////            carNameAndScore.put("nico", carNameAndScore.get("nico") + 1);
////        }
////        assertThat(carNameAndScore.get("nico")).isEqualTo(0);
//    }
//
//    @Test
//    @DisplayName("자동차 이동 결과 출력")
//    void printCarMove() {
//        RacingGame racingGame = new RacingGame(carNameAndScore, 3);
//        racingGame.randomMove();
//        assertThat(carNameAndScore.values()).allMatch(score -> score == 0);
//    }

    @Test
    @DisplayName("랜덤 값에 따라 자동차가 이동하거나 정지하는지 통합 테스트")
    void randomMoveIntegrationTest() {
        LinkedHashMap<String, Integer> carNameAndScore = new LinkedHashMap<>();
        carNameAndScore.put("Nico", 0);
        carNameAndScore.put("EJ", 0);

        racingcartest.FixedRandomRacingGame gameForStop = new racingcartest.FixedRandomRacingGame(carNameAndScore, 1, 3);
        gameForStop.randomMove();
        assertThat(carNameAndScore.get("Nico")).isEqualTo(0);

        RacingGame gameForMove = new racingcartest.FixedRandomRacingGame(carNameAndScore, 1, 4);
        gameForMove.randomMove();
        assertThat(carNameAndScore.get("EJ")).isEqualTo(1);
    }

    @Test
    @DisplayName("우승자 출력")
    void printWinner() {
        carNameAndScore.put("harua", 3);
        carNameAndScore.put("nico", 2);
        carNameAndScore.put("ej", 3);

        RacingGame racingGame = new RacingGame(carNameAndScore, 3);
        List<String> winners = racingGame.printWinner();
        assertThat(winners).contains("harua", "ej").doesNotContain("nico");
    }
}
