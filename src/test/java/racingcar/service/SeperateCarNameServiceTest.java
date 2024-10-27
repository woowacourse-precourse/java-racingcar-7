package racingcar.service;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.Cars;

class SeperateCarNameServiceTest {

    private SeperateCarNameService seperateCarNameService;

    @BeforeEach
    public void init(){
        this.seperateCarNameService = new SeperateCarNameService();
    }

    @Test
    @DisplayName("사용자의 입력값으로 부터 차 이름 분리-정상")
    public void 사용자_입력_차_이름_분리(){

        //given
        String userInput = "pobi,momo,papa";


        //when
        Cars cars = seperateCarNameService.seperateCarNameFromCarNamesWithDelimeter(userInput);

        //then
        assertThat(cars.getCars().size()).isEqualTo(3);
        assertThat(cars.getCars().get(0).getName()).isEqualTo("pobi");
        assertThat(cars.getCars().get(1).getName()).isEqualTo("momo");
        assertThat(cars.getCars().get(2).getName()).isEqualTo("papa");


    }

}