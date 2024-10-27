package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RacingServiceTest {
    RacingService racingService = new RacingService();

    @Test
    void carGoListTest(){
        //given
        List<String> strList = List.of("kimyelin,l1,l2".split(","));
        //when
        List<Boolean> result = new ArrayList<>();
        for(String car : strList){
            int randomNum = Randoms.pickNumberInRange(0,9);
            result.add(racingService.isGo(randomNum));
        }
        //then
        assertThat(result.size()).isEqualTo(3);
    }

    @Test
    void isGoTest(){
        //given
        List<Integer> ls = List.of(1,2,3,4,5,6,7,8);
        //when
        List<Integer> result = new ArrayList<>();
        for(int res : ls){
            if(racingService.isGo(res)){
                result.add(res);
            }
        }
        //then
        assertThat(result).contains(4);
        assertThat(result).contains(5);
        assertThat(result).contains(6);
        assertThat(result).contains(7);
        assertThat(result).contains(8);
    }

    @Test
    void winnerCarListTest(){
        //given
        List<String> carList = List.of("k,k1,k2".split(","));
        List<Integer> distance = List.of(3,2,1);
        //when
        List<String> res = racingService.winnerCarList(carList, distance);
        //then
        assertThat(res).contains("k");
    }

    @Test
    void winnerCarListTest2(){
        //given
        List<String> carList = List.of("k,k1,k2".split(","));
        List<Integer> distance = List.of(3,3,1);
        List<String> res = new ArrayList<>();

        //when
        int bestScore = 0;
        int carIdx = 0;
        for(int i=0; i<distance.size(); i++){
            if(distance.get(i) > bestScore){
                carIdx = i;
                bestScore = distance.get(i);
            }
        }
        res.add(carList.get(carIdx));

        for(int i=0; i<distance.size(); i++){
            if((distance.get(i) == bestScore) && (i != carIdx)){
                res.add(carList.get(i));
            }
        }

        //then
        assertThat(res).contains("k").contains("k1");
    }

    @Test
    void winnerCarListTest3(){
        //given
        List<String> carList = List.of("k1,k2,k3".split(","));
        List<Integer> distance = List.of(1,2,3);
        //when
        List<String> winner = racingService.winnerCarList(carList, distance);
        //then
        assertThat(winner).contains("k3");
    }
}