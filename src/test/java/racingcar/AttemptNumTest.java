package racingcar;

import camp.nextstep.edu.missionutils.Console;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.HashMap;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

public class AttemptNumTest {
    private static RacingGame testGame;

    @BeforeAll
    static void initAll() {
        testGame = new RacingGame();
    }

    @Test
    @DisplayName("attemptNum 초기화")
    void initAttemptNum(){
        //given
        setInpout("하나,둘\n3");
        Integer testNum = 3;

        //when
        testGame.run();

        //then
        assertThat(testGame.attemptNum).isEqualTo(testNum);
    }

    @Test
    @DisplayName("숫자 외 문자 예외")
    void attemptNumContext(){
        //given
        setInpout("하나,둘\n-3");

        //when
        final Throwable thrown = catchThrowable(() -> {
            testGame.run();
        });

        //then
        assertThat(thrown)
                .as("attemptNumContext 예외 처리 테스트")
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("시도 횟수는 양의 정수만 입력 가능합니다.");
    }

    @Test
    @DisplayName("숫자 크기 0이거나 10 초과 예외")
    void attemptNumSize(){
        //given
        setInpout("하나,둘\n11");

        //when
        final Throwable thrown = catchThrowable(() -> {
            testGame.run();
        });

        //case2
        closeConsole();
        setInpout("하나,둘\n0");
        final Throwable thrown2 = catchThrowable(() -> {
            testGame.run();
        });


        //then
        assertThat(thrown)
                .as("attemptNumSize 예외 처리 테스트")
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("시도 횟수는 1 이상, 10 이하로 입력해야 합니다.");

        assertThat(thrown2)
                .as("attemptNumSize 예외 처리 테스트")
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("시도 횟수는 1 이상, 10 이하로 입력해야 합니다.");
    }

    void setInpout(String input){
        final InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);
    }

    // camp.nextstep.edu.missionutils.Console에서 scanner가 static이다.
    // readLine()의 getInstance()에서 scanner가 null이 아니면 scanner 객체를 그대로 반환하고 nextLine()을 반환한다.
    // 따라서 input값을 새롭게 할당하기 위해 scanner을 null로 만들어야 한다.
    @AfterEach
    void closeConsole() {
        Console.close();
    }
}
