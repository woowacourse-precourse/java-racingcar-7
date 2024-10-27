package racingcar.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ValidServiceTest {
    ValidService validService;

    @BeforeEach
    void setValidService(){
        validService = new ValidService();
    }

    @Test
    void isCarnamesTest(){
        //given
        String str = "kimyelin,hi1,hi2";
        List<String> carList = List.of(str.split(","));
        //when
        boolean res = true;
        List<String> newList = carList.stream().distinct().collect(Collectors.toList());
        if(newList.size() != carList.size()){
            res = false;
        }
        for(String car : carList){
            if(car.isEmpty()){
                res = false;
            }
        }
        //then
        assertThat(res).isTrue();

    }

    @Test
    void isCarnamesTest2(){
        //given
        String str = "kim ye lin, hi1, hi2";
        //when
        boolean res = validService.isCarNames(str);
        //then
        assertThat(res).isTrue();
    }
    @Test
    void isCarnamesTest3(){
        //given
        String str = "kim ye lin, hi1, hi1";
        //when
        boolean res = validService.isCarNames(str);
        //then
        assertThat(res).isFalse();
    }
    @Test
    void isCarnamesTest4(){
        //given
        String str = "kimyelin,hi1, ";

        //when
        boolean res = validService.isCarNames(str);
        //then
        assertThat(res).isFalse();
    }

    @Test
    void isRepeatTest(){
        //given
        String n = "1";
        //when
        boolean res = validService.isRepeat(n);
        //then
        assertThat(res).isTrue();
    }

    @Test
    void isRepeatTest2(){
        //given
        String n = "a";
        //when
        boolean res = validService.isRepeat(n);
        //then
        assertThat(res).isFalse();
    }
}