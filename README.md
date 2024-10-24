# java-racingcar-precourse
자동차 경주 게임

## 📌 구현할 기능 목록
### 1. 자동차 이름 입력
- [ ] 자동차 이름 입력 문구를 출력한다.
- [ ] 자동차 이름을 입력받는다.

### 2. 입력값(자동차 이름) 예외 처리
- [ ] 빈 문자열이 입력된 경우
- [ ] 이름이 6자 이상인 경우
- [ ] 동일한 이름이 2번 이상 입력된 경우
- [ ] 이름에 공백이 들어간 경우
- [ ] 이름에 알파벳, 또는 한글 이외의 값이 들어간 경우

### 3. 시도할 횟수 입력
- [ ] 시도할 횟수 입력 문구를 출력한다.
- [ ] 시도할 횟수를 입력받는다.

### 4. 입력값(시도할 횟수) 예외 처리
- [ ] 빈 문자열이 입력된 경우
- [ ] 숫자가 아닌 값이 입력된 경우
- [ ] 1 이상인 양수 값이 입력된 경우
- [ ] 공백이 섞인 값이 입력된 경우

### 5. 자동차 경주 실행
- [ ] 실행 결과 문자를 출력한다.
- [ ] 각 자동차마다 무작위 값을 구한 뒤 전진 또는 멈춘다.
- [ ] 각 자동차마다 전진 또는 멈춤의 과정을 출력한다.
- [ ] 시도할 횟수만큼 반복한다.

### 6. 최종 우승자 출력
- [ ] 최종 우승자 출력 문구를 출력한다.
- [ ] 최종 우승자를 출력한다.
  - [ ] 여러 명일 경우 쉼표로 구분하여 출력한다.

<br>

## 📂 프로젝트 구조 설계
```plaintext
racingcar/
 ├── Application.java                      # 애플리케이션 시작
 ├── controller/                      
 │    └── RacingcarController.java          # 자동차 경주 게임 로직 처리
 ├── service/                            
 │    ├── RacingcarService.java             # 자동차 경주 게임 비즈니스 로직 인터페이스
 │    └── RacingcarServiceImpl.java         # 자동차 경주 게임 비즈니스 로직 구현체
 ├── model/                          
 │    └── Racingcar.java                    # 자동차 데이터 모델
 ├── io/                               
 │    ├── Input.java                        # 사용자 입력값 처리
 │    └── Output.java                       # 결과 출력
 └── util/                              
      ├── Validator.java                    # 입력값 유효성 검사
      └── Constants.java                    # 상수값 정의 클래스
```
