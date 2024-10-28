package racingcar.service;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.dto.RaceRequestDTO;
import racingcar.dto.RaceResultDTO;
import racingcar.util.random.RaceRandomGeneratorImpl;

class RacingServiceTest {

    private RaceEngine raceEngine;
    private List<String> names;

    @BeforeEach
    void setUp() {
        raceEngine = new RaceEngine(RaceRandomGeneratorImpl.getInstance());
        names = List.of("name1", "name2", "name3");
    }

    @Test
    @DisplayName("Racing service 객체를 생성한다.")
    void racingService_객체_생성_테스트() {
        RacingService racingService = new RacingService(raceEngine);
        Assertions.assertThat(racingService).isInstanceOf(racingService.getClass());
    }

    @Test
    @DisplayName("Racing service에서 race 로직을 1번 실행한다.")
    void time이_1회일때_race로직_1회_실행_테스트() {
        RacingService racingService = new RacingService(raceEngine);
        RaceRequestDTO raceRequestDTO = new RaceRequestDTO(names, 1);

        RaceResultDTO raceResultDTO = racingService.runAllRaces(raceRequestDTO);

        Assertions.assertThat(raceResultDTO.getRaceResult().getRaces()).hasSize(1);
        Assertions.assertThat(raceResultDTO.getRaceResult().getRaceWinnerList()).hasSizeGreaterThanOrEqualTo(0);
    }


    @Test
    @DisplayName("Racing service에서 race로직을 0회 실행하면 빈 List를 반환한다.")
    void time이_1회일때_race로직이_실행되지않는_테스트() {
        RacingService racingService = new RacingService(raceEngine);
        RaceRequestDTO raceRequestDTO = new RaceRequestDTO(names, 0);

        RaceResultDTO raceResultDTO = racingService.runAllRaces(raceRequestDTO);

        Assertions.assertThat(raceResultDTO.getRaceResult().getRaces()).isEmpty();
        Assertions.assertThat(raceResultDTO.getRaceResult().getRaceWinnerList()).isEmpty();
    }

    @Test
    @DisplayName("RacingService에서 car가 1대이면 우승자도 1대를 반환한다.")
    void car_1대일_때_우승자도_1명_테스트() {
        RacingService racingService = new RacingService(raceEngine);
        RaceRequestDTO raceRequestDTO = new RaceRequestDTO(List.of("name1"), 3);

        RaceResultDTO raceResultDTO = racingService.runAllRaces(raceRequestDTO);

        Assertions.assertThat(raceResultDTO.getRaceResult().getRaceWinnerList()).hasSize(1);
        Assertions.assertThat(raceResultDTO.getRaceResult().getRaces()).hasSize(3);
    }
}