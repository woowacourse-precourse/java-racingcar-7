package service;

import racingcar.dto.ValidatedInputDataDTO;
import java.util.HashMap;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.policy.RacingCarPolicy;
import racingcar.repository.RacingCarRepository;
import racingcar.service.RacingCarService;
import racingcar.service.RacingService;

class RacingCarServiceTest {

    @DisplayName("자동차 객체를 생성하여 repository에 저장한다.")
    @Test
    void generateCar() {
        //given
        ValidatedInputDataDTO validatedInputDataDTO = new ValidatedInputDataDTO("dada,toto,lala", 3L);
        RacingCarService racingCarService = new RacingCarService(validatedInputDataDTO, new RacingCarPolicy(),
                new RacingCarRepository(new HashMap<>()));

        //when
        racingCarService.racingStart();
        RacingCarRepository repository = racingCarService.getRacingCarRepository();

        //then
        Assertions.assertThat(repository.size()).isEqualTo(3);
    }


    @DisplayName("레이스 진행사항을 출력한다.")
    @Test
    void runRace() {

        //given
        ValidatedInputDataDTO validatedInputDataDTO = new ValidatedInputDataDTO("dada,toto,dodo", 10L);
        RacingService racingService = new RacingCarService(validatedInputDataDTO,new RacingCarPolicy(),
                new RacingCarRepository(new HashMap<>()));
        racingService.generateRacer(validatedInputDataDTO.name().split(","));
        //when

        String strings = racingService.runRace(validatedInputDataDTO.name().split(","));

        //then


    }


    @DisplayName("레이스 우승자를 찾는다.")
    @Test
    void findRaceWinner() {
        //given
        ValidatedInputDataDTO validatedInputDataDTO = new ValidatedInputDataDTO("dada,toto,dodo", 10L);
        RacingService racingService = new RacingCarService(validatedInputDataDTO,new RacingCarPolicy(),
                new RacingCarRepository(new HashMap<>()));
        racingService.generateRacer(validatedInputDataDTO.name().split(","));
        //when

        String raceStatus = racingService.runRace(validatedInputDataDTO.name().split(","));
        String winner = racingService.fineRaceWinner();
        System.out.println(raceStatus + "\n"+winner);

        //then

    }
}