package racingcar.exception;

public enum ErrorCode {


    CANT_CONVERT_TO_INTEGER("사용자의 입력을 숫자로 변환하지 못했습니다"),
    CANT_CAR_NAME_LENGTH_EXCEED_FIVE("차의 이름은 5글자 이하만 가능합니다"),

    ABNORMAL_USER_INPUT("사용자의 입력값이 비정상 적입니다"),

    CANT_CONVERT_CAR_NAME_WITH_NULL_OR_BLANK("NULL 혹은 빈 값은 차량의 이름이 되지 못합니다"),

    CANT_TRY_COUNT_UNDER_ZERO("시도 횟수는 0 이하가 될 수 없습니다"),

    CANT_INSERT_DUPLICATE_CAR_NAME("중복된 차량의 이름은 입력할 수 없습니다");

   private final String message;

   ErrorCode(final String message){
       this.message = message;
   }

   public String getMessage(){
       return this.message;
   }
}
