package racingcar.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import racingcar.dto.CarPosition;

@DisplayName("[Car Test]")
public class CarTest {

    @Nested
    @DisplayName("차량 객체 생성 시 name에 인자로 입력된 값이 할당된다")
    class createCarTest{
        @Test
        @DisplayName("차량 객체 생성 시 입력한 값과 이름이 동일하다")
        void Given_ValidName_When_CreateCar_Then_Success() {
            //given
            String validName = "뽀뚜";

            //when
            Car car = new Car(validName);

            //then
            assertThat(car.getName()).isEqualTo(validName);
        }
    }



    @Nested
    @DisplayName("move - position이 1 증가한다")
    class moveTest{

        @Test
        @DisplayName("move() 실행 후 정상적으로 position이 1 증가한다.")
        void Given_ValidName_When_Move_Then_Success(){
            //given
            String validName = "뽀뚜";
            Car car = new Car(validName);
            int startPosition = car.getPosition();

            //when
            car.move();

            //then
            assertThat(car.getPosition()).isEqualTo( startPosition+1);
        }
    }

    @Nested
    @DisplayName("buildCarPosition - 라운드 결과를 DTO형태로 리턴한다")
    class buildCarPositionTest{

        @Test
        @DisplayName("라운드 결과를 정상적으로 DTO형태로 리턴한다")
        void Given_ValidName_When_BuildCarPosition_Then_Success(){
            //given
            String validName = "뽀뚜";
            Car car = new Car(validName);

            //when
            CarPosition carPosition = car.buildCarPosition();

            //then
            assertThat( carPosition.carName()).isEqualTo(car.getName());
            assertThat( carPosition.position()).isEqualTo(car.getPosition());

        }

    }

}
