## 자동차 경주

### 요구사항

**구현할 기능 목록**

**입력**

- [x]  n대의 자동차에 이름 부여하기 (쉼표로 구분, 5자 이하)
    
    **예외처리**
    
    - [x]  특수문자 입력이 가능하다. ($jun$,&woni 도 자동차 이름으로 가능)
    - [x]  5자 이하인 경우, 공백 포함을 허용한다. (Top P,Hey W 꼴도 가능)
    - [x]  다음의 경우에서 IllegalArgumentException 을 발생시킨다.
        - [x]  길이가 1~5 사이가 아닌 경우
        - [x]  공백으로만 구성된 경우
        - [x]  자동차 이름을 중복으로 입력한 경우
- [x]  몇 번의 이동을 할 지 입력 받기
    - [x]  숫자만으로 입력을 제한한다.

**출력**

- [x]  전진하는 자동차를 출력할 때 자동차 이름을 같이 출력하기
    - [x]  자동차이름 : - 꼴로 출력
    - [x]  n번의 실행 결과를 한 번에 출력
- [x]  경주 게임 완료 후 우승자 알려주기
    - [x]  우승자는 여러 명 가능하고 여러 명인 경우 쉼표(,)로 구분

**라이브러리**

- [x]  camp.nextstep.edu.missionutils 에서 제공하는 Randoms 및 Console API 를 사용해 구현해야 한다.
    - [x]  Random 값 추출은 camp.nextstep.edu.missionutils.Randoms 의 pickNumberInRange() 를 활용한다.
    - [x]  사용자가 입력하는 값은 camp.nextstep.edu.missionutils.Console 의 readLine() 을 활용한다.
    - [x]  사용예시) Randoms.pickNumberInRange(0, 9);

**제한사항**

- [x]  잘못된 입력 처리하기
    - [x]  IllegalArgumentException 예외 발생시키기
- [x]  Indent depth가 3이 넘지 않도록 구현했나요?
- [x]  3항 연산자 쓰지 않았나요?
- [x]  함수는 한 가지 일만 하도록 구현했나요?
