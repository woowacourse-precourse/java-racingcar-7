package racingcar.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class GameCountsTest {

    @ParameterizedTest
    @ValueSource(ints={0,-8})
    void 영_이하_입력시_예외_발생(int gameCounts){
        assertThatThrownBy(()->new GameCounts(gameCounts)).
                isInstanceOf(IllegalArgumentException.class).
                hasMessageContaining("게임은 한 번 이상 실행되어야 합니다");
    }

    @Test
    void 정상_작동_확인(){
        GameCounts expectedCounts=new GameCounts(3);

        assertThat(new GameCounts(3)).usingRecursiveComparison().isEqualTo(expectedCounts);
    }

}




