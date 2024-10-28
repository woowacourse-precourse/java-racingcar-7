#### 2024-10-27

##### Chores

* **$ cr:**  자동리뷰 추가 (a97e79ee)

##### Documentation Changes

* **$ README:**
  *  문서 사양 변경 (dd1fc791)
  *  기능 초안 작성 (c4f462e2)

##### New Features

* **$ RacingConfig:**  레이싱 게임 준비 클래스 구현 (54ec01bd)
* **$ Cars, InputView, RacingGame:**  에러 메시지 출력 기능 추가 (eb93ee0d)
* **$ ErrorMessages:**
  *  에러 메시지 추가 (e51dbc7f)
  *  에러 메시지 수정 (a541414b)
  *  에러 메시지 상수 작성 (49723ac1)
* **$ Constants, OutputMessages, RandomNumberGenerator, StringSplitter:**  객체 생성 방지 기능 추가 (fc4cada4)
* **$ Constants:**
  *  애플리케이션 상수 추가 (e75113be)
  *  줄바꿈 상수 추가 (f9e99433)
  *  상수 작성 (40fa017b)
* **$ Application:**  애플리케이션 실행 구현 (aa10335d)
* **$ RacingGame:**
  *  레이싱 게임 실행, 결과 반환 메서드 추가 (ac9b49c8)
  *  tryCount 검증 추가 (c6c2b96b)
  *  레이싱 게임 클래스 구현 (fd744e35)
* **$ RacingGameController:**  컨트롤러 초안 구현 (437e88a4)
* **$ Cars:**
  *  컬렉션 내 자동차들을 움직이게 하는 메서드 추가 (527e4321)
  *  자동차 컬렉션 클래스 구현 (3d6f43c8)
* **$ Car:**
  *  현재 자동차의 상태 반환 기능 추가 (cffd885e)
  *  객체 동등성 판단 기능 구현 (4de338b3)
  *  자동차 객체 레이서 반환 기능 추가 (d129f01d)
  *  자동차 객체 구현 (45bd4153)
* **$ OutputView:**  사용자 출력 UI 구현 (89d5a416)
* **$ InputView:**  사용자 입력 클래스 구현 (e067bb6f)
* **$ RandomNumberGenerator:**  랜덤 정수 메서드 구현 (474936c8)
* **$ StringSplitter:**  구분자 나누기 유틸 기능 구현 (8c81dfde)
* **$ CarTest:**  자동차 객체 테스트 (934edd0f)
* **$ CarRacer:**  자동차 레이서 객체 구현 (e5d44f0e)
* **$ OutputMessages:**  출력 UI 메시지 상수 작성 (944c5b5c)
*  setup project (5ec13447)

##### Bug Fixes

* **$ RacingGame:**  시행횟수 버그 수정 (0006e4c8)
* **$ Car:**  자동차 전진 조건 수정 (01f17362)

##### Refactors

* **$ OutputView:**
  *  변수명 변경 (c34f242f)
  *  에러 메시지 수정 (3495ff6a)
  *  미사용 메서드 삭제 (68646067)
* **$ OutputMessages:**
  *  변수명 변경 (83a564df)
  *  상수명 변경 (c51dacdf)
  *  상수 이름 변경 (e3b3e719)
* **$ InputView, OutputView, RacingController:**  메서드명 변경 (7bca7582)
* **$ RacingConfig:**  변수명 변경 (e62aed9f)
* **$ CarName, Cars:**  에러 메시지 수정 (fe14c44a)
* **$ ErrorMessages:**  에러 메시지 변경 (5c0a5914)
* **$ RacingController:**
  *  컨틀롤러 기능 분리 (f04b6ca5)
  *  컨틀롤러 기능 분리 (be07f268)
* **$ Car, CarName, OutputView, RacingGame, RandomNumberGenerator:**  매직넘버 상수화 (8d28702a)
* **$ RacingGame:**  출력 사양 준수 (45d72476)
* **$ CarName:**
  *  메서드 이름 변경 (71fb0b3d)
  *  자동차 이름 클래스 이름 리팩터링 (b21a8352)
* **$ Cars:**  중복 검사 코드 리펙터링 (4c1ae75d)

##### Code Style Changes

* **$ Constants:**
  *  상수 이름 수정 (64b2933b)
  *  상수 공백 추가 (8500ca0a)

##### Tests

* **$ RacingGameTest:**  레이싱 게임 테스트 추가 (819efcc0)
* **$ MyApplicationTest:**  애플리케이션 테스트 추가 (3653de78)
* **$ CarTest:**
  *  클래스 이름 변경 수정 (70032be5)
  *  자동차 전진 조건 수정 테스트 (092feda7)
* **$ CarsTest:**
  *  메서드 이름 변경 수정 (6d7574e2)
  *  중복 검사 코드 테스트 추가 (acae5ff9)
  *  자동차 컬렉션 클래스 테스트 (860ca674)
* **$ CarNameTest:**  클래스 이름 변경에 따른 테스트명 변경 (e7a620b9)
* **$ StringSplitter:**  구분자 나누기 유틸 기능 테스트 (185b9b89)
* **$ CarRacerTset:**  자동차 레이서 객체 테스트 (59363e59)

