package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class RacingGameTest {

    @DisplayName("자동차 객체 만들기 테스트")
    @Test
    void givenStr_whenCreateCars_thenCarsList() {

        //Given
        RacingGame testGame = new RacingGame(3);
        String str = "poni,woni, jun, min";

        //When
        testGame.createCar(str);

        //Then

        assertThat(testGame.cars.size()).isEqualTo(4);
    }

    @DisplayName("우승자 한명 출력하기")
    @Test
    void givenGameRecord_whenOneWinner_thenPrintWinner() {

        //Given
        RacingGame testGame = new RacingGame(0);
        String str = "poni,woni, jun, min";
        testGame.createCar(str);

        //When
        testGame.cars.get(3).location += 1;

        //Then
        assertThat(testGame.printWinner()).isEqualTo("최종 우승자 :  min");

    }

    @DisplayName("공동 우승자 출력하기")
    @Test
    void givenGameRecord_whenManyWinner_thenPrintWinner() {

        //Given
        RacingGame testGame = new RacingGame(0);
        String str = "poni,woni,jun,min";
        testGame.createCar(str);

        //When
        testGame.cars.get(0).location += 1;
        testGame.cars.get(1).location += 1;
        testGame.cars.get(2).location += 1;

        //Then
        assertThat(testGame.printWinner()).isEqualTo("최종 우승자 : poni, woni, jun");

    }

    @DisplayName("램덤 수에 따른 위치 추가 테스트")
    @Test
    void givenCarNumAndRandomNum_whenInputRandomNum_thenRecordLoc() {

        //Given
        RacingGame testGame = new RacingGame(0);
        String str = "poni,woni,jun,min";
        testGame.createCar(str);

        //When
        testGame.recordLoc(0,3);
        testGame.recordLoc(1,5);

        //Then
        assertThat(testGame.cars.get(0).location).isEqualTo(0);
        assertThat(testGame.cars.get(1).location).isEqualTo(1);

    }

    @Test
    void givenGameRecord_when_thenWinnerLoc() {

        //Given
        RacingGame testGame = new RacingGame(0);
        String str = "poni,woni,jun,min";
        testGame.createCar(str);
        testGame.cars.get(2).location += 3;
        //When

        //Then
        assertThat(testGame.getWinnerLoc()).isEqualTo(3);
    }
}