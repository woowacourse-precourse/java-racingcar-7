package racingcar;

public class ParseInput {

    private String[] raceMember;

    ParseInput(String inputCar) {
        raceMember = inputCar.split(",");

        if(raceMember.length==0) {
            throw new IllegalArgumentException("데이터를 입력해주세요");
        }

        for(String car : raceMember) {
            if(car.length() >5) {
                throw new IllegalArgumentException("차 이름의 길이가 너무 깁니다 5글자 이하로 입력해주세요");
            }
        }


    }

    public String[] getRaceMember() {
        return raceMember;
    }
}
