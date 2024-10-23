# java-racingcar-precourse

### 구현할 기능

- [ ] "," 기준으로 입력된 문자열에서 글자 잘라내는 로직 구현
    - [ ] 각 글자가 5자 이하인지 확인하는 로직 구현
- [ ] 무작위값 가져와서 4 이상 조건 거는 로직 구현
- [ ] 차수별 실행 결과를 출력하는 로직 구현
    - [ ] 각 차수별 실행 결과를 기억하는 로직 구현
- [ ] 
- [ ] 우승자 판별 로직 구현
- [ ] 우승자 안내 문구 출력 로직 구현
    - [ ] 단독 우승자 안내 문구 구현
    - [ ] 공동 우승자 안내 문구 구현


- [ ] 예외처리

    - [x] 입력된 자동차 이름이 정상이 아닐 때
        - [x] ,사이에 아무것도 입력이 안되었을 경우 IllegalArgumentException 발생 후 프로그램 종료
        - [x] ,를 구분자로 세팅하지 않고 입력한 경우 IllegalArgumentException 발생 후 프로그램 종료
        - [ ] 5글자를 넘겼을 경우 IllegalArgumentException 발생 후 프로그램 종료
        - [ ] 같은 이름을 등록했을 경우 IllegalArgumentException 발생 후 프로그램 종료
        - [ ] \n과 같은 에러를 낼만한 이름으로 등록했을 경우 이스케이프 

    - [x] 

    - [x] 횟수가 long 값을 넘겼을 때 IllegalArgumentException 발생 후 프로그램 종료

    - [x] 횟수에 숫자 입력 안했을 때 IllegalArgumentException 발생 후 프로그램 종료
        - [ ] 횟수에 공백이 끼었을 때 IllegalArgumentException 발생 후 프로그램 종료
        - [ ] 아무것도 입력 안했을 때 IllegalArgumentException 발생 후 프로그램 종료

    - [x] 횟수에 음수 임력했을 때 IllegalArgumentException 발생 후 프로그램 종료 
  
    - [ ] 정수형 아닐 때 IllegalArgumentException 발생 후 프로그램 종료 



이름 사이 공백 에러?