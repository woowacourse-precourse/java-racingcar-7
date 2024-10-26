package racingcar.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class GameCountsTest {

    @ParameterizedTest
    @ValueSource(strings={"0","-8"})
    void 영_이하_입력시_예외_발생(String gameCounts){
        assertThatThrownBy(()->new GameCounts(gameCounts)).
                isInstanceOf(IllegalArgumentException.class).
                hasMessageContaining("게임은 한 번 이상 실행되어야 합니다");
    }

    @Test
    void 양수정수_범위_초과_입력시_예외_발생(){
        String gameCounts = String.valueOf(Long.MAX_VALUE);

        assertThatThrownBy(()->new GameCounts(gameCounts)).
                isInstanceOf(IllegalArgumentException.class).
                hasMessageContaining("게임은 양수인 정수 범위에서 실행되어야 합니다");
    }

    @Test
    void 정상_작동_확인(){
        GameCounts expectedCounts=new GameCounts("3");

        assertThat(new GameCounts("3")).usingRecursiveComparison().isEqualTo(expectedCounts);
    }
}




