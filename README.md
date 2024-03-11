# JSP-PROJECT
 **1조 프로젝트 깃 허브**
 ## 홈페이지 구조

 ## 메인 페이지
    - 로그인
    - 검색
    - 고객센터
   ### 로그인 이후 페이지
    - 회원 정보
    - 장바구니
    - 주문 내역
 ## 로그인
    - 회원가입
     > 아이디(중복체크), 비밀번호, 이름, 생년월일, 이메일(google, naver 만)(이메일 중복체크), 주소, 
       전화번호
     ( 회원가입시 이름에 admin 사용 금지, 공지사항 작성시 userid가 admin경우에만 가 
      능하도록 하는 기능 추가 )
    - 로그인
     > 아이디, 비밀번호, 아이디 및 비밀번호 찾기
    - 회원정보
 ### 아이디 및 비밀번호 찾기
   - 아이디 찾기
   > 이름, 이메일 입력<br>
   > --> 이메일로 아이디의 앞, 뒤 3자리 씩 출력 이외의 정보 (*) 표시
   > --> 이름 이메일 DB에서 조회로 사용자 아이디 찾기
   - 비밀번호 찾기
   > 이름, 아이디, 이메일 입력<br>
   > --> 이메일로 비밀번호 변경 페이지 전송(google, naver 정도로 제한)
 ## 회원정보
    - 비밀번호 변경 (원래 사용하던 비밀번호 입력 시 변경 가능)
    - 주소 변경(배송지)
    - 전화번호 변경
    - 주문 내역
    - 문의 내역
   ### 주문 내역
    - 주문 날짜(년-월-일)
    - 배송지
    - 물건 정보(제품 이미지, 제목, 저자)
    - 배송 상태(결재 완료, 이동, 배송지, 배송중, 배송 완료)
 ## 상품 상세 페이지
    - 이미지
    - 가격
    - 제목
    - 출판사
    - 저자
    - 출간일
    - 구매 버튼(장바구니에 담기, 즉시 구매)
 ## 장바구니
    - input type="checkbox"를 이용한 선택
    - 구매 버튼
    - checked 된 물건들의 가격들의 합 표시
 ## 고객센터 및 도움말
    - 공지
    - Q&A
    - 1대1 문의
 
 ## 마이페이지 (회원 상세정보)
   - 회원정보 수정
   - 문의내역
   - 구매내역

 ###
- 조 이름 : 
- 조장 : 
- 조원 :
--------------------------------
# 추가하면 좋을 듯?
- 장바구니 ( 추가 완?)
> 전체선택, 선택삭제, 주문하기
