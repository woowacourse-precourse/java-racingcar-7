package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;


class CarTest {

    @Test
    void createNamedCar_이름이10자초과_예외발생(){
        assertThatThrownBy(()->{
                Car car = Car.createNamedCar("xxxxxxxxxxx");
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 최대 10자까지 가능합니다.");
    }
    @Test
    void createNamedCar_이름이1자미만_예외발생(){
        assertThatThrownBy(() -> {
            Car car = Car.createNamedCar("");
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 최소 1자부터 가능합니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"1","22","333","4444","55555","666666","7777777","88888888","!!!!!!!!!","ㅌㅌㅌㅌㅌㅌㅌㅌㅌㅌ"})
    void createNamedCar_1부터10자사이_생성성공(String name){
        assertThatCode(()->Car.createNamedCar(name))
                .doesNotThrowAnyException();;


    }
    //
    //
    //

    @Test
    void moveForwardPosition_이동횟수1미만_예외발생(){

    }
    @Test
    void moveForwardPosition_이동횟수100초과_예외발생(){

    }
    @Test
    void moveForwardPosition_이동횟수1포함100포함사이_위치증가(){

    }
    //
    @Test
    void maintainCurrentPosition_위치유지_이전위치유지() {

    }
    //
    @Test
    void provideCarName_이름조회_이름반환() {

    }
    @Test
    void provideCurrentPosition_초기생성_0반환() {

    }
    //


}