package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.exception.ErrorCode;

class CarTest {

    @Test
    @DisplayName("차 이름이 5글자 초과일 때 ")
    public void 차_이름_5_글자_초과(){

        //given
        String carName = "가나다라마바";

        //when
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class,()->{
            Car car = new Car(carName);
        });

        //then
        assertThat(e.getMessage()).isEqualTo(ErrorCode.CANT_CAR_NAME_LENGTH_EXCEED_FIVE.getMessage());

    }

    @Test
    @DisplayName("차 이름이 5글자 이하일 때 ")
    public void 차_이름_5_글자_이하(){

        //given
        String carName = "가나다라마";

        //when
        Car car = new Car(carName);

        //then
        assertThat(car.getName()).isEqualTo(carName);

    }

    @Test
    @DisplayName("차 생성시 moveCount 0 임을 확인")
    public void 움직임_0(){
        //given
        String carName = "pobi";

        //when
        Car car = new Car(carName);

        //then
        assertThat(car.getMoveCount()).isEqualTo(0);
    }


    @Test
    @DisplayName("차 이름이 빈 값일때")
    public void 차_이름_빈값(){

        //given
        String carName = " ";

        //when
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class,()->{
            Car car = new Car(carName);
        });


        //then
        assertThat(e.getMessage()).isEqualTo(ErrorCode.CANT_CONVERT_CAR_NAME_WITH_NULL_OR_BLANK.getMessage());

    }

    @Test
    @DisplayName("차 이름이 null 값일때")
    public void 차_이름_NULL값(){

        //given
        String carName = null;

        //when
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class,()->{
            Car car = new Car(carName);
        });


        //then
        assertThat(e.getMessage()).isEqualTo(ErrorCode.CANT_CONVERT_CAR_NAME_WITH_NULL_OR_BLANK.getMessage());

    }

}