package racingcar.domain;

import static org.assertj.core.api.AssertionsForClassTypes.tuple;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.dto.CarPositionDto;
import racingcar.dto.CarsPositionDto;
import racingcar.support.AlwaysMovingStrategy;
import racingcar.vo.CarsPositionSnapshot;
import racingcar.vo.Name;

class RaceHistoryTest {

    @Test
    void 빈_레이스_히스토리를_생성한다() {
        // when
        RaceHistory history = RaceHistory.create();

        // then
        assertSoftly(softly -> {
            softly.assertThat(history.toPositionDtos())
                    .isEmpty();
        });
    }

    @Test
    void 단일_스냅샷을_추가하고_DTO로_변환한다() {
        // given
        RaceHistory history = RaceHistory.create();
        List<Car> cars = List.of(
                Car.withName(Name.from("car1")),
                createCarWithMove("car2", 1)
        );
        CarsPositionSnapshot snapshot = CarsPositionSnapshot.from(cars);

        // when
        history.add(snapshot);
        List<CarsPositionDto> dtos = history.toPositionDtos();

        // then
        assertSoftly(softly -> {
            softly.assertThat(dtos)
                    .hasSize(1);

            CarsPositionDto firstDto = dtos.get(0);
            List<CarPositionDto> carPositions = firstDto.carPositions();

            softly.assertThat(carPositions)
                    .hasSize(2)
                    .extracting(CarPositionDto::name)
                    .containsExactlyInAnyOrder("car1", "car2");

            softly.assertThat(carPositions)
                    .filteredOn(dto -> dto.name().equals("car1"))
                    .extracting(CarPositionDto::position)
                    .containsExactly(0);

            softly.assertThat(carPositions)
                    .filteredOn(dto -> dto.name().equals("car2"))
                    .extracting(CarPositionDto::position)
                    .containsExactly(1);
        });
    }

    @Test
    void 여러_스냅샷을_순서대로_추가하고_변환한다() {
        // given
        RaceHistory history = RaceHistory.create();

        // first snapshot - 초기 상태
        List<Car> firstCars = List.of(
                Car.withName(Name.from("car1")),
                Car.withName(Name.from("car2"))
        );

        // second snapshot - car1만 전진
        List<Car> secondCars = List.of(
                createCarWithMove("car1", 1),
                Car.withName(Name.from("car2"))
        );

        // when
        history.add(CarsPositionSnapshot.from(firstCars));
        history.add(CarsPositionSnapshot.from(secondCars));
        List<CarsPositionDto> dtos = history.toPositionDtos();

        // then
        assertSoftly(softly -> {
            softly.assertThat(dtos)
                    .hasSize(2);

            // 첫 번째 스냅샷 검증
            List<CarPositionDto> firstSnapshot = dtos.get(0).carPositions();
            softly.assertThat(firstSnapshot)
                    .extracting(CarPositionDto::name, CarPositionDto::position)
                    .containsExactlyInAnyOrder(
                            tuple("car1", 0),
                            tuple("car2", 0)
                    );

            // 두 번째 스냅샷 검증
            List<CarPositionDto> secondSnapshot = dtos.get(1).carPositions();
            softly.assertThat(secondSnapshot)
                    .extracting(CarPositionDto::name, CarPositionDto::position)
                    .containsExactlyInAnyOrder(
                            tuple("car1", 1),
                            tuple("car2", 0)
                    );
        });
    }

    @Test
    void 스냅샷_추가_후_원본_변경이_히스토리에_영향을_주지_않는다() {
        // given
        RaceHistory history = RaceHistory.create();
        Car car = Car.withName(Name.from("car1"));
        List<Car> cars = List.of(car);
        CarsPositionSnapshot snapshot = CarsPositionSnapshot.from(cars);

        // when
        history.add(snapshot);
        car.attemptMove(() -> true);  // 원본 Car 객체 이동 시도
        List<CarsPositionDto> dtos = history.toPositionDtos();

        // then
        assertSoftly(softly -> {
            softly.assertThat(dtos)
                    .hasSize(1);

            List<CarPositionDto> carPositions = dtos.get(0).carPositions();
            softly.assertThat(carPositions)
                    .hasSize(1)
                    .extracting(CarPositionDto::name, CarPositionDto::position)
                    .containsExactly(tuple("car1", 0));
        });
    }

    private Car createCarWithMove(String name, int moves) {
        Car car = Car.withName(Name.from(name));
        for (int i = 0; i < moves; i++) {
            car.attemptMove(new AlwaysMovingStrategy());
        }

        return car;
    }
}
