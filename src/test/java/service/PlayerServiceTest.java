package service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.model.RacingCar;

class PlayerServiceTest {

    private final PlayerService playerService = new PlayerService();

    @Test
    void 유효한_차_이름_입력시_테스트() {
        String carNames = "pobi,woni,jun";

        List<RacingCar> racingCarList = playerService.registerPlayers(carNames);

        assertThat(racingCarList).hasSize(3);
        assertThat(racingCarList.getFirst().getName()).isEqualTo("pobi");
        assertThat(racingCarList.get(1).getName()).isEqualTo("woni");
        assertThat(racingCarList.get(2).getName()).isEqualTo("jun");
    }

    @Test
    void 전처리_필요한_차_이름_입력시_테스트() {
        String carNames = "  pobi,    woni, jun ";

        List<RacingCar> racingCarList = playerService.registerPlayers(carNames);

        assertThat(racingCarList).hasSize(3);
        assertThat(racingCarList.getFirst().getName()).isEqualTo("pobi");
        assertThat(racingCarList.get(1).getName()).isEqualTo("woni");
        assertThat(racingCarList.get(2).getName()).isEqualTo("jun");
    }

    @Test
    void 빈_문자열_입력시_테스트() {
        String carNames = "";

        assertThatThrownBy(() -> {
            playerService.registerPlayers(carNames);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("부적절한 형식의 자동차 이름을 입력했습니다. (자동차 이름은 공백이 아닌 5자 이하 문자열)");
    }

    @Test
    void 다섯_자_이상_차_이름_입력시_테스트() {
        String carNames = "very_loooooooong_name, pobi,woni,jun";

        assertThatThrownBy(() -> {
            playerService.registerPlayers(carNames);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("부적절한 형식의 자동차 이름을 입력했습니다. (자동차 이름은 공백이 아닌 5자 이하 문자열)");
    }

    @Test
    void 중복된_이름_입력시_테스트() {
        String carNames = "pobi,pobi,jun";

        assertThatThrownBy(() -> {
            playerService.registerPlayers(carNames);
        }).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("중복된 자동차 이름을 입력했습니다.");
    }
}