#### 2024-10-27

##### Chores

*  클래스 이름 카멜 케이스로 수정 (84a1fea6)
*  디렉토리 구조 변경 (4e54a8ae)

##### Documentation Changes

* **README:**
  *  업데이트 항목 및 클래스 다이어그램 추가, 도메인 항목 수정 (24325a5f)
  *  기능 구현 목록 초안 작성 (3fa8709d)

##### New Features

* **AppConfig:**  의존성 주입을 위한 설정 클래스 구현 (9e8de2a4)
* **RacingCarController:**  컨트롤러 구현 (e98b65c1)
* **OutputView:**  출력 하는 객체 구현 (fd4cbf1b)
* **InputView:**  입력 받는 객체 구현 (1cdf5f1f)
* **ErrorType:**
  *  자동차 이름 중복 메세지 정의 (3193a893)
  *  에러 메세지 정의 (a88d95ce)
* **RacingCarService:**  서비스 레이어 구현 (085cef13)
* **RacingCarResult:**  경주 결과 dto 구현 (19c3e372)
* **RacingCarProgress:**  경주 진행상황 dto 구현 (1222db1b)
* **RacingCarWinner:**  우승자 dto 구현 (2d2104ad)
* **Racing:**  경주의 책임을 갖는 도메인 구현 (93118552)
* **CarName:**  자동차 이름 관련 도메인 구현 (ad979712)
* **StopNumberGenerator:**  전진 기준값 미만의 숫자를 생성하는 제너레이터 구현 (2456c861)
* **ForwardNumberGenerator:**  전진 기준값 이상의 숫자를 생성하는 제너레이터 구현 (f234b9ee)
* **InputValidator:**  입력 관련 유효성 검증 로직 구현 (77155804)
* **RacingCarValidator:**  도메인 관련 유효성 검증 로직 구현 (7abd95a8)
* **Score:**  스코어 도메인 구현 (d0f0180f)
* **Count:**  시도 횟수에 대한 책임을 갖는 Count 도메인 구현 (9924cdee)
* **Car:**  자동차에 대한 책임을 갖는 Car 도메인 구현 (cdd330f1)
* **RandomNumberGenerator:**  랜덤 숫자 생성 메서드 구현 (484e2ad4)
* **NumberGenerator:**  숫자 생성 메서드 정의 (444f0be0)
* **Rule:**  게임 규칙 상수로 정의 (e0510849)
*  setup project (5ec13447)

##### Refactors

*  초기 스코어, 전진 스코어 상수화 (705502e1)
*  Score 필드 int 타입으로 변경 (38f33153)
*  예외 메세지 추가 (0de060ed)
*  미사용 클래스 삭제 (394b5939)
*  유효성 검증 로직을 인터페이스로 추상화 (313e583c)
* **CarName:**  이름 최대 범위 상수화 (c0e2188b)
* **Application:**  main 메서드 수정 (7349397b)
* **Rule:**
  *  시도 횟수 최대 범위 수정 (bb815112)
  *  자동차 최대 대수 정의 (3d98c98f)
* **Count:**
  *  제네릭 제거 후 필드값 int로 수정 (15303399)
  *  검증 단계 추가 (49231c99)
  *  정적 팩토리 메서드 추가 (741911b1)
* **RacingCarService:**  빈문자열도 split 되게 수정 (4559ba2e)
* **RacingCarStringValidator:**  공백도 검증하도록 수정 (fde0c767)
* **RacingCarListValidator:**  리스트 벨리데이터 제네릭 String 타입으로 수정 (5a7f10fb)
* **Car:**  자동차 도메인 리팩토링 (c37551a2)
* **RacingCarValidatorTest:**  리팩토링을 반영하여 삭제 (ac441a4e)
* **Car, RacingCarValidatorTest:**  Car 도메인 정적팩토리 메서드 추가 및 관련 테스트 수정 (a9d3b19b)

##### Tests

* **ApplicationTest:**
  *  시도 횟수 범위 테스트 입력 숫자 부분 수정 (5471f06b)
  *  통합 테스트 추가 (74a9f639)
* **RacingCarStringValidator:**  문자열 공백 케이스 테스트 추가 (d320797c)
* **CarTest:**
  *  우승자 판단 테스트 추가 (56fc904f)
  *  자동차 도메인 테스트 (58ebd4a0)
  *  Car 도메인 테스트 (deec7a0c)
* **RacingCarServiceTest:**  경주 관련 서비스 레이어 테스트 (bbb7d3da)
* **RacingCarListValidator:**  리스트 검증 클래스 테스트 (a2047683)
* **RacingTest:**  경주 관련 도메인 테스트 (7bb7f9bb)
*  테스트를 위한 페이크 검증 객체 구현 (dfd2679b)
* **RacingCarNumberValidatorTest:**  숫자 유효성 검증 테스트 (b958bbf3)
* **RacingCarStringValidatorTest:**  문자 유효성 검증 테스트 (e98226f1)
* **InputValidatorTest:**  입력 관련 유효성 검증 테스트 (0cabec08)
* **RacingCarValidatorTest:**  도메인 관련 유효성 검증 테스트 (fe49b384)

