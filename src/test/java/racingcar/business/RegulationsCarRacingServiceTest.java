package racingcar.business;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Comparator;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.object.carEngine.RegulationsCarEngine;
import racingcar.object.value.CarName;
import racingcar.object.value.CarNames;
import racingcar.object.value.CarRacingResult;
import racingcar.object.value.CarRecord;
import racingcar.object.value.RaceRecord;
import racingcar.object.value.TotalLapCount;
import racingcar.object.value.Winners;

class RegulationsCarRacingServiceTest {

    public static final TotalLapCount LAP_COUNT_FOR_RACING = new TotalLapCount(5);
    public static final CarNames CAR_NAMES_OF_PARTICIPANTS = new CarNames(List.of(
            new CarName("2번차"),
            new CarName("1번차"),
            new CarName("3번차")
    ));

    private CarRacingResult carRacingResult;

    @BeforeEach
    void setUp() {
        CarRacingService regulationsCarRacingService = new CarRacingService(new RegulationsCarEngine());
        carRacingResult = regulationsCarRacingService.performCarRacing(LAP_COUNT_FOR_RACING, CAR_NAMES_OF_PARTICIPANTS);
    }

    @Test
    void 레이싱경기는_지정한_랩수만큼_진행된다() {
        RaceRecord raceRecordOfTotal = carRacingResult.raceRecord();

        assertThat(raceRecordOfTotal.lapRecords().size()).isEqualTo(LAP_COUNT_FOR_RACING.lapCount());
    }

    @Test
    void 레이싱경기는_승자가_한명이상_존재한다() {
        Winners winnersOfTotal = carRacingResult.winners();

        assertThat(winnersOfTotal.winners().carNames().size()).isGreaterThanOrEqualTo(1);
    }

    @Test
    void 출력기준은_이름의_오름차순이다() {
        RaceRecord raceRecordOfTotal = carRacingResult.raceRecord();
        List<CarName> expect = CAR_NAMES_OF_PARTICIPANTS.carNames().stream()
                .sorted(Comparator.comparing(CarName::name))
                .toList();

        List<CarName> actual = raceRecordOfTotal.lapRecords().getLast().carRecords().stream()
                .map(CarRecord::carName)
                .sorted(Comparator.comparing(CarName::name))
                .toList();

        assertThat(actual).containsExactlyElementsOf(expect);
    }

}