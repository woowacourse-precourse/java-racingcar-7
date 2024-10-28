package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.CarRacing;
import racingcar.domain.RacingCarPolicy;
import racingcar.dto.RacingOutputDTO;
import racingcar.dto.ValidatedInputDataDTO;
import racingcar.exception.ExceptionMessage;
import racingcar.infrastructure.RacingCarHistory;
import racingcar.presentation.RacingCarOutputView;

class CarRacingTest {

    @DisplayName("자동차 객체를 생성하여 repository에 저장한다.")
    @Test
    void generateCar() {
        //given
        ValidatedInputDataDTO validatedInputDataDTO = new ValidatedInputDataDTO("dada,toto,lala", 10L);
        RacingCarHistory racingCarHistory = new RacingCarHistory();
        CarRacing racing = new CarRacing(validatedInputDataDTO,new RacingCarPolicy(),racingCarHistory );

        //when
        racing.generateRacer(validatedInputDataDTO.name().split(","));

        //then
        Assertions.assertThat(racingCarHistory.getCars(0L).size()).isEqualTo(3);
    }


    @DisplayName("레이스 진행사항을 출력한다.")
    @Test
    void runRace() {
        //given
        ValidatedInputDataDTO validatedInputDataDTO = new ValidatedInputDataDTO("dada,toto,lala", 10L);
        CarRacing racing = new CarRacing(validatedInputDataDTO,new RacingCarPolicy(), new RacingCarHistory());
        racing.generateRacer(validatedInputDataDTO.name().split(","));
        //when

        RacingOutputDTO racingOutputDTO = racing.racingStart();

        RacingCarOutputView racingCarOutputView = new RacingCarOutputView(racingOutputDTO);
        racingCarOutputView.printRacingResult();

        //then

    }

    @DisplayName("레이스 우승자를 찾는다.")
    @Test
    void findRaceWinner() {
        //given
        ValidatedInputDataDTO validatedInputDataDTO = new ValidatedInputDataDTO("dada,toto,lala", 10L);
        CarRacing racing = new CarRacing(validatedInputDataDTO,new RacingCarPolicy(),new RacingCarHistory());
        //when

        RacingOutputDTO racingOutputDTO = racing.racingStart();
        String winner = racing.fineRaceWinner(validatedInputDataDTO.count());
        System.out.println("최종우승자 : " + winner);

        //then
    }

    @DisplayName("저장된 라운드가 데이터가 없을경우 에러반환")
    @Test
    void findRaceWinnerOrThrow() {
        //given
        ValidatedInputDataDTO validatedInputDataDTO = new ValidatedInputDataDTO("dada,toto,lala", 10L);
        CarRacing racing = new CarRacing(validatedInputDataDTO,new RacingCarPolicy(),new RacingCarHistory());
        //when

        //then
        Assertions.assertThatThrownBy(() -> racing.fineRaceWinner(validatedInputDataDTO.count()))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.NO_PARTICIPANTS_IN_ROUND.getMessage());
    }


}