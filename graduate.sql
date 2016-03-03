--1
--�����û���
create table users
(
 userid int,
 username nvarchar2(32),
 pwd nvarchar2(32),
 phone nvarchar2(32),
 mail nvarchar2(32),
 isfreezed int,
 userhead nvarchar2(32),
 constraint pk_userid primary key(userid),
 constraint uq_username unique(username)
)
--�û��������
create sequence sq_userid
start with 1001
increment by 1;
--�û���Ŵ�����
create or replace trigger t_userid
before insert on users for each row
begin
 select sq_userid.nextval into :new.userid from dual;
end;


--2
--������Ϣ��
create table houses
(
 houseid int,
 title nvarchar2(64),
 genre nvarchar2(10),
 ways nvarchar2(10),
 resident nvarchar2(32),
 region int,
 locations nvarchar2(32),
 layout int,
 area int,
 decorate nvarchar2(10),
 orient nvarchar2(10),
 floor int,
 floors int,
 depict nvarchar2(200),
 release timestamp,
 ispassed int,
 price int,
 image nvarchar2(32),
 userid int,
 constraint pk_houseid primary key(houseid),
 constraint fk_userid foreign key(userid) references users(userid),
 constraint fk_region foreign key(region) references locates(locateid)
)
--���ݱ������
create sequence sq_houseid
start with 1001
increment by 1;
--���ݱ�Ŵ�����
create or replace trigger t_houseid
before insert on houses for each row
begin
 select sq_houseid.nextval into :new.houseid from dual;
end;


--�ص��
create table locates
(
 locateid int,
 locatename nvarchar2(32)
)
alter table locates add constraint pk_locateid primary key (locateid)
--�ص�������
create sequence sq_locateid
start with 101
increment by 1;
--�ص��Ŵ�����
create or replace trigger t_locateid
before insert on locates for each row
begin
 select sq_locateid.nextval into :new.locateid from dual;
end;

commit;



--����Աadmin��
create table admins
(
 adminid int,
 adminname nvarchar2(50),
 adminpwd nvarchar2(50),
 adminlevel int,
 isfreezed int,
 constraint pk_adminid primary key(adminid),
 constraint uq_adminname unique(adminname)
)
--����Ա�������
create sequence sq_adminid
start with 101
increment by 1;
--����Ա��Ŵ�����
create or replace trigger t_adminid
before insert on admins for each row
begin
 select sq_adminid.nextval into :new.adminid from dual;
end;










--����
select * from users where username='ace';
select h.*,u.*,l.* from houses h,users u,locates l where h.userid=u.userid and h.region=l.locateid;
select * from locates
commit;
--select * from(select houseid,title,genre,ways,resident,locations,layout,area,decorate,orient,floor,depict,release,ispassed,price,image from houses h,users u,locates l where h.userid=u.userid and l.locateid=h.region) where h.genre like 'סլ'


--��ҳ��ѯ
select * from(
select a.*,rownum as n from
(select * from(
select houseid,title,genre,ways,resident,locateid,locatename,
locations,layout,area,decorate,orient,floor,floors,depict,release,
ispassed,price,image,u.userid,u.username,u.pwd,u.phone,u.mail,u.isfreezed,
u.userhead from houses h,users u,locates l where h.userid=u.userid and 
l.locateid=h.region) c where c.ispassed=1 and c.layout like '2%') a)
 b where b.n between 1 and 5


--��ҳ��ѯ�Ľ�
select houseid,title,genre,ways,resident,locateid,locatename,
locations,layout,area,decorate,orient,floor,floors,depict,release,
ispassed,price,image,u.userid,u.username,u.pwd,u.phone,u.mail,u.isfreezed,
u.userhead from houses h,users u,locates l where h.userid=u.userid and 
l.locateid=h.region and ispassed=1 and layout like '2%'  and
rownum between 1 and 2  order by houseid;

select houseid,title,genre,ways,resident,locateid,locatename,locations,layout,area,decorate,orient,floor,floors,depict,release,ispassed,price,image,u.userid,u.username,u.pwd,u.phone,u.mail,u.isfreezed,u.userhead from houses h,users u,locates l where h.userid=u.userid and l.locateid=h.region and ispassed=1 and layout like '2%'  and rownum between 1 and 2 order by houseid;

--�ܵ�����
select max(rownum) from houses h,users u,locates l where h.userid=u.userid and l.locateid=h.region and ispassed=1 and layout like '2%' order by h.houseid

select adminid,adminname,adminpwd,adminlevel,isfreezed from admins where adminname='acasde'














--�����û�
insert into users values(0,'ace','360e2ece07507675dced80ba867d6dcd','13916302654','ace@qq.com',0,'')


--���뷿����Ϣ
insert into houses values(0,'���õضΡ���ס���ú÷��ӡ���һ����һ�㡤��ʱ���������ס-����','סլ','����','�������',101,'��԰·����·���㴦',221,100,'�е�װ��','��',8,10,'��������',to_date('20150912','yyyymmdd'),1,900,'images/house.jpg',1001);
insert into houses values(0,'���������÷����⣨��Ů����','סլ','����','��������',102,'����·�����νֽ���ڶ�200��',211,120,'��װ��','��',4,12,'��������',to_date('20141024','yyyymmdd'),1,1000,'images/house.jpg',1001);
insert into houses values(0,'��������Ԫ��԰(���-½Ľ)','סլ','����','½Ľ',101,'����·���Ԫ·���㴦',212,120,'��װ��','��',6,9,'��������',to_date('20150210','yyyymmdd'),1,1600,'images/house.jpg',1001);
insert into houses values(0,'�����´�60ƽ���е�װ��2��1�������»�԰���ϣ�','סլ','����','�����˼�',103,'ƽ��·�ֵ�',221,95,'��װ��','��',25,31,'��������',to_date('20150714','yyyymmdd'),1,1900,'images/house.jpg',1001);
insert into houses values(0,'�������ָ� �����´� ��װ��3��������Ʒ���Ҿ߼ҵ���ȫ','סլ','����','�����´�',102,'�����',211,115,'����װ��','��',4,6,'��������',to_date('20130923','yyyymmdd'),1,2800,'images/house.jpg',1001);

--����ص���Ϣ
insert into locates values(0,'����');
insert into locates values(0,'����');
insert into locates values(0,'԰��');

--�������Ա
insert into admins values(0,'ace','360e2ece07507675dced80ba867d6dcd',5,0);






































