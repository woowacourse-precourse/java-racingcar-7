package racingcar;

/**
 * @author ddaerae
 * 자동차와 관련된 기능이 모이는 유틸리티 클래스
 */
class Car {

    // 차량의 정지, 혹은 전진 여부를 판단하여 문자열을 리턴한다.
    static String goOrStop(int ranNum) {
        if(ranNum >= 4){
            return "-";
        }else{
            return "";
        }
    }

    private Car() {

    }


}
