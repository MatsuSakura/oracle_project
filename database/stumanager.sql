CREATE TABLE tb_class  (
  classId NUMBER(11) NOT NULL,
  departName varchar(100),
  specName varchar(100),
  className NUMBER(11) NOT NULL,
  PRIMARY KEY (classId)
)
drop table tb_class
-- ----------------------------
-- Records of tb_class
-- ----------------------------
INSERT INTO tb_class(departName,specName,className) VALUES ('计算机学院', '软件工程', 1);
INSERT INTO tb_class(departName,specName,className) VALUES ('计算机学院', '计算机科学与技术', 2);
INSERT INTO tb_class(departName,specName,className) VALUES ('艺术设计学院', '服装设计', 1);
INSERT INTO tb_class(departName,specName,className) VALUES ('自动化学院', '物联网工程', 2);
INSERT INTO tb_class(departName,specName,className) VALUES ('自动化学院', '物联网工程', 1);
INSERT INTO tb_class(departName,specName,className) VALUES ('计算机学院', '计算机科学与技术', 1);
INSERT INTO tb_class(departName,specName,className) VALUES ('政法学院', '法学', 1);
INSERT INTO tb_class(departName,specName,className) VALUES ('政法学院', '法学', 2);
INSERT INTO tb_class(departName,specName,className) VALUES ('计算机学院', '软件工程', 2);
INSERT INTO tb_class(departName,specName,className) VALUES ('物理学院', '物理学', 1);
INSERT INTO tb_class(departName,specName,className) VALUES ('政法学院', '法学', 3);

-- ----------------------------
-- Table structure for tb_cource
-- ----------------------------

CREATE TABLE tb_cource  (
  courceId NUMBER(11) NOT NULL,
  courceName varchar(100)NOT NULL,
  courceHour float,
  courceSpecName varchar(100),
  PRIMARY KEY (courceId)
)
drop table tb_cource
-- ----------------------------
-- Records of tb_cource
-- ----------------------------
INSERT INTO tb_cource(courceName,courceHour,courceSpecName) VALUES ('大学英语', 2.5, '法学');
INSERT INTO tb_cource(courceName,courceHour,courceSpecName) VALUES ('大学物理', 1.5, '物联网工程');
INSERT INTO tb_cource(courceName,courceHour,courceSpecName) VALUES ('高等数学', 5, '计算机科学与技术');
INSERT INTO tb_cource(courceName,courceHour,courceSpecName) VALUES ('C语言程序设计', 3, '软件工程');
INSERT INTO tb_cource(courceName,courceHour,courceSpecName) VALUES ('数据结构', 3.5, '软件工程');
INSERT INTO tb_cource(courceName,courceHour,courceSpecName) VALUES ('线性代数', 1.5, '物理学');
INSERT INTO tb_cource(courceName,courceHour,courceSpecName) VALUES ('大学语文', 1.5, '服装设计');
INSERT INTO tb_cource(courceName,courceHour,courceSpecName) VALUES ('Linux课程设计', 2, '软件工程');
INSERT INTO tb_cource(courceName,courceHour,courceSpecName) VALUES ('数据库管理', 2.5, '软件工程');

-- ----------------------------
-- Table structure for tb_depart
-- ----------------------------

CREATE TABLE tb_depart  (
  departId NUMBER(11) NOT NULL,
  departName varchar(100)NOT NULL,
  PRIMARY KEY (departId)
)

-- ----------------------------
-- Records of tb_depart
-- ----------------------------
INSERT INTO tb_depart VALUES (1, '计算机学院');
INSERT INTO tb_depart VALUES (3, '艺术设计学院');
INSERT INTO tb_depart VALUES (4, '自动化学院');
INSERT INTO tb_depart VALUES (5, '政法学院');
INSERT INTO tb_depart VALUES (7, '物理学院');

-- ----------------------------
-- Table structure for tb_score
-- ----------------------------
CREATE TABLE tb_score  (
  scoreId number(11) NOT NULL,
  stuNumber number(11) NOT NULL,
  courceName varchar(100)NOT NULL,
  score float,
  PRIMARY KEY (scoreId)
)
drop table tb_score
-- ----------------------------
-- Records of tb_score
-- ----------------------------
INSERT INTO tb_score(stuNumber,courceName,score) VALUES (3001, 'C语言程序设计', 95);
INSERT INTO tb_score(stuNumber,courceName,score) VALUES (3002, '高等数学', 70);
INSERT INTO tb_score(stuNumber,courceName,score) VALUES (3004, '高等数学', 96);
INSERT INTO tb_score(stuNumber,courceName,score) VALUES (3001, '数据结构', 97);
INSERT INTO tb_score(stuNumber,courceName,score) VALUES (3006, '大学物理', 100);
INSERT INTO tb_score(stuNumber,courceName,score) VALUES (3007, '大学语文', 80);
INSERT INTO tb_score(stuNumber,courceName,score) VALUES (3008, '大学物理', 59);
INSERT INTO tb_score(stuNumber,courceName,score) VALUES (3001, 'Linux课程设计', 85);
INSERT INTO tb_score(stuNumber,courceName,score) VALUES (3001, '数据库管理', 80);

-- ----------------------------
-- Table structure for tb_spec
-- ----------------------------

CREATE TABLE tb_spec  (
  specId number(11) NOT NULL,
  departName varchar(100),
  specName varchar(100)NOT NULL,
  PRIMARY KEY (specId)
) 

-- ----------------------------
-- Records of tb_spec
-- ----------------------------
INSERT INTO tb_spec VALUES (1, '计算机学院', '计算机科学与技术');
INSERT INTO tb_spec VALUES (3, '艺术设计学院', '服装设计');
INSERT INTO tb_spec VALUES (5, '计算机学院', '软件工程');
INSERT INTO tb_spec VALUES (7, '自动化学院', '物联网工程');
INSERT INTO tb_spec VALUES (8, '物理学院', '物理学');
INSERT INTO tb_spec VALUES (14, '计算机学院', '网络工程');

-- ----------------------------
-- Table structure for tb_student
-- ----------------------------

CREATE TABLE tb_student (
  stuId number(11) NOT NULL,
  stuNumber number(11) NOT NULL,
  stuName varchar(20)NOT NULL,
  stuDepart varchar(100),
  stuSpec varchar(100),
  stuClass number(11),
  PRIMARY KEY (stuId)
  
)

-- ----------------------------
-- Records of tb_student
-- ----------------------------
INSERT INTO tb_student VALUES (1, 3001, '张灵涛', '计算机学院', '软件工程', 1);
INSERT INTO tb_student VALUES (4, 3003, '黄昌俊', '计算机学院', '计算机科学与技术', 2);
INSERT INTO tb_student VALUES (6, 3002, '卢家豪', '自动化学院', '物联网工程', 1);
INSERT INTO tb_student VALUES (7, 3004, '徐楷', '自动化学院', '物联网工程', 2);
INSERT INTO tb_student VALUES (8, 3005, '郑黄穗', '自动化学院', '物联网工程', 2);
INSERT INTO tb_student VALUES (9, 3006, '朱汐月', '物理学院', '物理学', 1);
INSERT INTO tb_student VALUES (10, 3007, '张磊', '政法学院', '法学', 1);
INSERT INTO tb_student VALUES (13, 3009, '李四', '艺术设计学院', '服装设计', 1);
INSERT INTO tb_student VALUES (14, 1111, '1111', '艺术设计学院', '服装设计', 1);

-- ----------------------------
-- Table structure for tb_user
-- ----------------------------

CREATE TABLE tb_user  (
  userId number(11) NOT NULL,
  userName varchar(45)NOT NULL,
  userPwd varchar(45),
  userType number(11) NOT NULL,
  PRIMARY KEY (userId)
)

-- ----------------------------
-- Records of tb_user
-- ----------------------------
INSERT INTO tb_user VALUES (1, 'admin', '', 1);
INSERT INTO tb_user VALUES (5, 'abc', '123', 2);
INSERT INTO tb_user VALUES (6, '111', '111', 2);
INSERT INTO tb_user VALUES (7, 'ljh', '123', 2);
INSERT INTO tb_user VALUES (8, 'xukai', '12', 2);
INSERT INTO tb_user VALUES (9, '333', '111', 2);

-- ----------------------------
-- VIEW
-- ----------------------------
CREATE or replace VIEW vi_stu
AS
SELECT s.STUID,s.STUNUMBER,s.stuname,c.COURCENAME,c.SCORE FROM tb_score c FULL OUTER JOIN tb_student s
on c.stunumber=s.stunumber;


-- ----------------------------
-- TRIGGER
-- ----------------------------
create or replace trigger tr_score_between
after update of score on tb_score
for each ROW
BEGIN
if(:new.score<0 or :new.score>100) THEN
raise_application_error(-20008,'分数应该限制在0~100之间');
end if;
END;
update tb_score set score=110 where stunumber=3008;


create or replace trigger tr_score_low
after update of SCORE on TB_SCORE
for each ROW
BEGIN
if(:new.score<:old.score) THEN
raise_application_error(-20009,'重考分数低于原来的，修改失败');
end if;
END;
drop trigger tr_score_low;
update TB_SCORE set score=55 where stunumber=3008;

create SEQUENCE seq_id
start with 1
INCREMENT by 1;


create or replace trigger tr_scoreid
before INSERT on TB_SCORE
for each ROW
BEGIN
select seq_id.NEXTVAL into :new.SCOREID from dual;
END;
drop trigger tr_scoreid;

create SEQUENCE seq_courceid
start with 1
INCREMENT by 1;

create or replace trigger tr_courceid
before INSERT on TB_COURCE
for each ROW
BEGIN
select seq_courceid.NEXTVAL into :new.courceId from dual;
END;
drop trigger tr_courceid;

create or replace trigger tr_deptid
before INSERT on TB_DEPART
for each ROW
BEGIN
select seq_id.NEXTVAL into :new.departId from dual;
END;

create or replace trigger tr_specid
before INSERT on TB_SPEC
for each ROW
BEGIN
select seq_id.NEXTVAL into :new.specId from dual;
END;

create SEQUENCE seq_classid
start with 1
INCREMENT by 1;
create or replace trigger tr_classid
before INSERT on TB_CLASS
for each ROW
BEGIN
select seq_classid.NEXTVAL into :new.classId from dual;
END;

-- ----------------------------
-- PROCEDURE
-- ----------------------------


