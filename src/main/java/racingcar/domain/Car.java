package racingcar.domain;

import camp.nextstep.edu.missionutils.*;

public class Car {
    private static long carCnt;
    private long carId;
    private String name;
    private int loc;

    public Car( String name ) {
        this.carId = carCnt++;

        this.name = name;
        this.loc = 0;
    }

    public String getName() { return this.name; }

    public int getLoc() { return this.loc; }

    /**
     * 자동차가 랜덤값에 따라 앞으로 이동하도록 합니다
     * @return 자동차가 랜덤값에 따라 이동한 후 위치
     */
    public int run() {
        if ( Randoms.pickNumberInRange(0, 9) < 4 )
            return this.getLoc();
        return ++this.loc;
    }
}
