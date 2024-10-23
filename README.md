# java-racingcar-precourse

## racing package
1. Application class
    + static void main()
        + 기능 : 시작점
    + void racingcar(String[] carNames)
        + 기능 : racing진행
        + car의 최대 value값 max변수 관리

2. Input class
    + String[] input()
        + 기능 : 입력을 담당하는 함수
          input : X | output : String[] carNames
    + String check()

3. Car class
    + public Car() : constructor
        + 기능 : init Car
    + public void update(int updateValue)
        + 확률 계산하여  
          updateValue만큼 value값 증가
    + public String getName()
    + public int getValue()