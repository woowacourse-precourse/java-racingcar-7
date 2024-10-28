# java-racingcar-precourse

### 구현할 기능

- [x] "," 기준으로 입력된 문자열에서 글자 잘라내는 로직 구현
    - [x] 각 글자가 5자 이하인지 확인하는 로직 구현
- [x] 무작위값 가져와서 4 이상 조건 거는 로직 구현
    - [x] 랜덤 값이 4 이상인지 확인하는 로직 구현
- [x] 차수별 실행 결과를 출력하는 로직 구현
- [x] 우승자 판별 로직 구현
- [x] 우승자 안내 문구 출력 로직 구현
    - [x] 단독 우승자 안내 문구 구현
    - [x] 공동 우승자 안내 문구 구현


- [ ] 예외처리

- 자동차의 이름은 공백포함 5글자 이하여야한다.
- 자동차의 이름에는 중복이 없어야한다.
- 자동차 이름 사이의 공백은 허용한다.
- 경기 시행 횟수는 int 값 내로 제한한다.
- 경기 시행 횟수는 공백또는 무입력이 아니어야한다.
- 경기 시행 횟수는 반드시 숫자만 입력이 가능해야하 한다.
- 경기 시행 횟수는 0이나 음수가 될 수 없다.
- 경기 시행 횟수는 정수여야만 한다.

    - [x] 입력된 자동차 이름이 정상이 아닐 때
        - [x] ,사이에 아무것도 입력이 안되었을 경우 IllegalArgumentException 발생 후 프로그램 종료
        - [x] ,를 구분자로 세팅하지 않고 입력한 경우 IllegalArgumentException 발생 후 프로그램 종료
        - [x] 5글자를 넘겼을 경우 IllegalArgumentException 발생 후 프로그램 종료
        - [x] 같은 이름을 등록했을 경우 IllegalArgumentException 발생 후 프로그램 종료

    - [x] 횟수가 int 값을 넘겼을 때 IllegalArgumentException 발생 후 프로그램 종료

    - [x] 횟수에 숫자 입력 안했을 때 IllegalArgumentException 발생 후 프로그램 종료
        - [x] 횟수에 공백이 끼었을 때 IllegalArgumentException 발생 후 프로그램 종료
        - [x] 아무것도 입력 안했을 때 IllegalArgumentException 발생 후 프로그램 종료

    - [x] 횟수에 음수 임력했을 때 IllegalArgumentException 발생 후 프로그램 종료 
  
    - [x] 정수형 아닐 때 IllegalArgumentException 발생 후 프로그램 종료 

