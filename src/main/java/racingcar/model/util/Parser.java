package racingcar.model.util;

public interface Parser<T, R> {
    static <T, R> Parser<T, R> select(Class<? extends Parser<T, R>> parserClass) {
       try{
           return parserClass.getDeclaredConstructor().newInstance();
       }catch (ReflectiveOperationException e){
           throw new IllegalArgumentException("Parse 인스턴스 생성 중, 에러가 발생하였습니다.");
       }
    }

    R parse(T givenInput);
}
