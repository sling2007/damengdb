
达梦db：
下载地址： https://eco.dameng.com/download/
windows和docker安装启动： https://eco.dameng.com/document/dm/zh-cn/start/dm-install-docker.html
客户端：https://eco.dameng.com/document/dm/zh-cn/start/tool-dm-manager.html

mybatis参考：
https://eco.dameng.com/document/dm/zh-cn/app-dev/java_Mybatis_frame.html

达梦数据库的Java驱动：
提前建表：  注意必须在表、序列前，指定一个用户名！！！否则会无法解析sql。
``` sql

CREATE TABLE "HMNTECH"."CITY"
(
"CITY_ID" CHAR(3) NOT NULL,
"CITY_NAME" VARCHAR(40),
"REGION_ID" INT) STORAGE(ON "TEST", CLUSTERBTR) ;

CREATE TABLE "HMNTECH"."YOUR_TABLE"
(
"COLUMN1" VARCHAR(40),
"COLUMN2" INT) ;

-- 自增主键的sequence
CREATE SEQUENCE HMNTECH.seller_sequence
START WITH 1
INCREMENT BY 1
NOCYCLE
NOCACHE;

-- 自增主键
CREATE TABLE HMNTECH.SELLER (
    id NUMBER PRIMARY KEY, -- 创建id字段并设为主键
    name VARCHAR2(50) -- 创建name字段
);



```

1、单连接jdbc测试文件 ： DamonJdbcExample

2、连接池jdbc测试文件 ： DamonDBPoolExample

3、springweb、mybatia、druid连接池测试 ：
    入口： DamonApp
    controller：SellerController
    service：SellerService
    dao: SellerMapper
    entity: Seller

用到自增序列的主键时，可以如下操作，用于给主键生成一个自增值，并且返回给调用方。
``` 
@SelectKey(statement = "SELECT HMNTECH.seller_sequence.NEXTVAL", keyProperty = "id", before = true, resultType = Long.class)
@Insert("INSERT INTO HMNTECH.SELLER(id, name) VALUES(#{id}, #{name})")
```


备注： 
1、windows默认安装的达梦数据库，登录是 SYSDBA/SYSDBA
docker安装的是：
docker run -d -p 35236:5236 --restart=always --name=dm8_test --privileged=true -e LD_LIBRARY_PATH=/opt/dmdbms/bin -e PAGE_SIZE=16 -e EXTENT_SIZE=32 -e LOG_SIZE=1024 -e UNICODE_FLAG=1  -e INSTANCE_NAME=dm8_test -v /opt/data:/opt/dmdbms/data dm8_single:dm8_20241022_rev244896_x86_rh6_64

/opt/dmdbms/bin/disql SYSDBA/SYSDBA001

2、可能是个bug
创建了Seller表后，在达梦客户端里正常crud。
但springweb的测试中，一直无法crud，在客户端sql语句编辑器里点提交，貌似也不行（不是必现）。
重新断开，又连接了达梦客户端，才正常操作。





