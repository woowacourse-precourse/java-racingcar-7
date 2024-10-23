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
- [ ] 
- [ ]


- [ ] 예외처리

    - [x] 입력된 수가 양수가 아닐 때
        -[x] 0 인 경우 IllegalArgumentException 발생 후 프로그램 종료
        -[x] -를 구분자로 세팅하지 않고 입력한 경우 IllegalArgumentException 발생 후 프로그램 종료

    - [x] 커스텀 구분자로 선언되지 않은 구분자가 입력됐을 경우 IllegalArgumentException 발생 후 프로그램 종료

    - [x] 커스텀 구분자 세팅이 중간에 입력될 경우 IllegalArgumentException 발생 후 프로그램 종료

    - [x] 커스텀 구분자가 공백이 될 경우 IllegalArgumentException 발생 후 프로그램 종료

    - [x] 숫자와 숫자 사이에 구분자 없이 공백이 입력될 경우 IllegalArgumentException 발생 후 프로그램 종료 