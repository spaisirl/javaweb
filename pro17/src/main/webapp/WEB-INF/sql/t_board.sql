-- 게시판 테이블 생성
CREATE TABLE t_board (
	bno number primary key, --글번호(PK)
	title varchar2(100) not null, --글제목
	content varchar2(4000),  --글내용
	writer varchar2(50) not null, --작성자
	regdate date default sysdate --작성한날짜
);

--글번호 시퀀스
create sequence seq_bno;