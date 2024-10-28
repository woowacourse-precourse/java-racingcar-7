package racingcar.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RaceStorageTest {
    private RaceStorage raceStorage;

    @BeforeEach
    void 초기화() {
        raceStorage = new RaceStorage();
    }

    @Test
    void 결과_추가() {
        //given
        String result = "a : ---\nb : --";

        //when
        raceStorage.addResult(result);

        //then
        assertThat(raceStorage.getResults()).isEqualTo(result + "\n");
    }

    @Test
    void 빈줄_추가() {
        //given
        String result = "a : ---\nb : --";

        //when
        raceStorage.addResult(result);
        raceStorage.addBlankLine();

        //then
        assertThat(raceStorage.getResults()).isEqualTo(result + "\n\n");
    }


}