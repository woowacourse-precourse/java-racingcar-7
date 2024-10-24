package racingcar.service;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PlayerServiceTest {

    @Test
    @DisplayName("전체 참가자 이름 문자열에서 쉼표(,)를 기준으로 split한다.")
    void splitPlayer() {
        String input = "a,b,c,d";
        List<String> result = List.of("a", "b", "c", "d");

        PlayerService playerService = new PlayerService();
        List<String> player = playerService.splitPlayer(input);

        Assertions.assertThat(player).hasSameElementsAs(result);
    }
}