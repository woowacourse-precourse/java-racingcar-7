package racingcar;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import racingcar.validator.InputValidator;

public class InputTest {

    @Test
    void 플레이어_입력_성공_두명_이상() {
        String[] strPlayers = {"Car1", "Car2"};

        assertDoesNotThrow(() -> {
            InputValidator.validatePlayerCount(strPlayers);
        });
    }

    @Test
    void 플레이어_입력_성공_이름_5자_이하() {
        String[] strPlayers = {"Car1", "Car2"};

        assertDoesNotThrow(() -> {
            InputValidator.validatePlayerName(strPlayers);
        });
    }

    @Test
    void 플레이어_입력_실패_두명_미만() {
        String[] strPlayers = {"Car1"};

        assertThrows(IllegalArgumentException.class, () -> {
            InputValidator.validatePlayerCount(strPlayers);
        });
    }

    @Test
    void 플레이어_입력_실패_이름_5자_초과() {
        String[] strPlayers = {"Car1", "Car123"};

        assertThrows(IllegalArgumentException.class, () -> {
            InputValidator.validatePlayerName(strPlayers);
        });
    }

    @Test
    void 라운드_입력_성공_자연수() {
        String round = "5";

        assertDoesNotThrow(() -> {
            InputValidator.validateRound(round);
        });
    }

    @Test
    void 라운드_입력_실패_자연수_아닌_값() {
        String round = "str";

        assertThrows(IllegalArgumentException.class, () -> {
            InputValidator.validateRound(round);
        });
    }

}
