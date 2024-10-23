package controller;

import common.BeanFactory;
import input.OriginalInput;
import input.ValidatedInputData;
import service.RacingService;

public class RacingController {

    private final BeanFactory beanFactory;
    private final OriginalInput originalInput;

    public RacingController(BeanFactory beanFactory, OriginalInput originalInput) {
        this.beanFactory = beanFactory;
        this.originalInput = originalInput;
    }

    public String run() {
        ValidatedInputData validatedInputData = validateInput();
        RacingService racingService = beanFactory.provideRacingService(validatedInputData);
        return racingService.racingStart();
    }

    public ValidatedInputData validateInput(){
        OriginalInput replaceBlankInput = replaceBlankInput(originalInput.name(), originalInput.name());
        isEmptyInput(replaceBlankInput.name(), replaceBlankInput.count());
        return new ValidatedInputData(replaceBlankInput.name(),convertTryCount(replaceBlankInput.count()));
    }


    public OriginalInput replaceBlankInput(String name, String count){
        return new OriginalInput(name.replace(" ", ""), count.replace(" ", ""));
    }

    public void isEmptyInput(String name,String count){
        //TODO : exceptionMessage Enum 만들어서 상수관리 하기.
        if (name.isBlank()||name.isEmpty()){
            throw new IllegalArgumentException("이름에는 공백만 입력할 수 없습니다.");
        }
        if (count.isBlank()||count.isEmpty()){
            throw new IllegalArgumentException("시도횟수는 1이상 입력해야합니다.");
        }
    }

    public Long convertTryCount(String tryCount){
        //TODO : Long 범위 벗어나면 예외처리

        return Long.parseLong(tryCount);
    }


}
