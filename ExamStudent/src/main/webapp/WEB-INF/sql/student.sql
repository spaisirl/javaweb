create table t_student(
    s_no number(4) primary key,
    s_name varchar2(20) not null,
    s_year number not null,
    s_gender varchar2(1) check (s_gender in ('M', 'F')) not null,
    s_major varchar2(20) not null,
    s_score number(3) not null
);

commit;

select * from tbl_student;