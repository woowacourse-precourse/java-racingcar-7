package racingcar;

public class ParseInput {

    private String[] raceMember;

    ParseInput(String inputCar) {

        raceMember = inputCar.split(",");

        //아무것도 입력하지 않은 경우
        if(inputCar.isEmpty()) {
            throw new IllegalArgumentException("데이터를 입력해주세요");
        }

        if(raceMember.length >5) {
            throw new IllegalArgumentException("대회 참여자는 5명까지만 받습니다");
        }

        //이름 길이 검사
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
