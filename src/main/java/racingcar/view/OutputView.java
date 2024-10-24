package racingcar.view;

import racingcar.domain.Cars;
import racingcar.service.RacingService;

public class OutputView {

    public static void nowResult(String name, String position){
        System.out.println(name+" : "+position);
    }

    public static void racingResult(Cars cars){
        System.out.println("실행 결과");
        RacingService.doRacing(cars);
        System.out.println();
    }
}
