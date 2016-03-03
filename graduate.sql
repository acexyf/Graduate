--1
--创建用户表
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
--用户编号序列
create sequence sq_userid
start with 1001
increment by 1;
--用户编号触发器
create or replace trigger t_userid
before insert on users for each row
begin
 select sq_userid.nextval into :new.userid from dual;
end;


--2
--房屋信息表
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
--房屋编号序列
create sequence sq_houseid
start with 1001
increment by 1;
--房屋编号触发器
create or replace trigger t_houseid
before insert on houses for each row
begin
 select sq_houseid.nextval into :new.houseid from dual;
end;


--地点表
create table locates
(
 locateid int,
 locatename nvarchar2(32)
)
alter table locates add constraint pk_locateid primary key (locateid)
--地点编号序列
create sequence sq_locateid
start with 101
increment by 1;
--地点编号触发器
create or replace trigger t_locateid
before insert on locates for each row
begin
 select sq_locateid.nextval into :new.locateid from dual;
end;

commit;



--管理员admin表
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
--管理员编号序列
create sequence sq_adminid
start with 101
increment by 1;
--管理员编号触发器
create or replace trigger t_adminid
before insert on admins for each row
begin
 select sq_adminid.nextval into :new.adminid from dual;
end;










--测试
select * from users where username='ace';
select h.*,u.*,l.* from houses h,users u,locates l where h.userid=u.userid and h.region=l.locateid;
select * from locates
commit;
--select * from(select houseid,title,genre,ways,resident,locations,layout,area,decorate,orient,floor,depict,release,ispassed,price,image from houses h,users u,locates l where h.userid=u.userid and l.locateid=h.region) where h.genre like '住宅'


--分页查询
select * from(
select a.*,rownum as n from
(select * from(
select houseid,title,genre,ways,resident,locateid,locatename,
locations,layout,area,decorate,orient,floor,floors,depict,release,
ispassed,price,image,u.userid,u.username,u.pwd,u.phone,u.mail,u.isfreezed,
u.userhead from houses h,users u,locates l where h.userid=u.userid and 
l.locateid=h.region) c where c.ispassed=1 and c.layout like '2%') a)
 b where b.n between 1 and 5


--分页查询改进
select houseid,title,genre,ways,resident,locateid,locatename,
locations,layout,area,decorate,orient,floor,floors,depict,release,
ispassed,price,image,u.userid,u.username,u.pwd,u.phone,u.mail,u.isfreezed,
u.userhead from houses h,users u,locates l where h.userid=u.userid and 
l.locateid=h.region and ispassed=1 and layout like '2%'  and
rownum between 1 and 2  order by houseid;

select houseid,title,genre,ways,resident,locateid,locatename,locations,layout,area,decorate,orient,floor,floors,depict,release,ispassed,price,image,u.userid,u.username,u.pwd,u.phone,u.mail,u.isfreezed,u.userhead from houses h,users u,locates l where h.userid=u.userid and l.locateid=h.region and ispassed=1 and layout like '2%'  and rownum between 1 and 2 order by houseid;

--总的数量
select max(rownum) from houses h,users u,locates l where h.userid=u.userid and l.locateid=h.region and ispassed=1 and layout like '2%' order by h.houseid

select adminid,adminname,adminpwd,adminlevel,isfreezed from admins where adminname='acasde'














--插入用户
insert into users values(0,'ace','360e2ece07507675dced80ba867d6dcd','13916302654','ace@qq.com',0,'')


--插入房屋信息
insert into houses values(0,'超好地段·商住两用好房子·租一层送一层·随时看房·拎包住-整租','住宅','整租','中梁香缇',101,'竹园路滨河路交汇处',221,100,'中等装修','南',8,10,'描述暂无',to_date('20150912','yyyymmdd'),1,900,'images/house.jpg',1001);
insert into houses values(0,'莲花三区好房出租（限女生）','住宅','合租','莲花三区',102,'东延路与松涛街交叉口东200米',211,120,'精装修','南',4,12,'描述暂无',to_date('20141024','yyyymmdd'),1,1000,'images/house.jpg',1001);
insert into houses values(0,'地铁房嘉元花园(相城-陆慕)','住宅','整租','陆慕',101,'采莲路与嘉元路交汇处',212,120,'精装修','南',6,9,'描述暂无',to_date('20150210','yyyymmdd'),1,1600,'images/house.jpg',1001);
insert into houses values(0,'羽绒新村60平米中等装修2室1厅（官渎花园边上）','住宅','整租','齐门人家',103,'平江路街道',221,95,'简单装修','南',25,31,'描述暂无',to_date('20150714','yyyymmdd'),1,1900,'images/house.jpg',1001);
insert into houses values(0,'东环家乐福 葑谊新村 精装修3大三房商品房家具家电齐全','住宅','整租','葑谊新村',102,'葑谊街',211,115,'豪华装修','南',4,6,'描述暂无',to_date('20130923','yyyymmdd'),1,2800,'images/house.jpg',1001);

--插入地点信息
insert into locates values(0,'姑苏');
insert into locates values(0,'新区');
insert into locates values(0,'园区');

--插入管理员
insert into admins values(0,'ace','360e2ece07507675dced80ba867d6dcd',5,0);






































