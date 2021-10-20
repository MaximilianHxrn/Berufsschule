-- AB Aufgabe Problem
create table csv_ort (
osm_id VARCHAR(20),
ags VARchar(20),
ort varchar(50),
plz varchar(10),
landkreis varchar(50),
bundesland varchar(50)
); 

load data local infile 'C:/Users/shb/Downloads/zuordnung_plz_ort_landkreis.csv'
into table csv_ort
character set utf8
fields terminated by ','
lines terminated by '\n'
ignore 1 rows;

create table Landkreis(
id int primary key,
name varchar(50),
bid int,
bname varchar(50));

create table Ort(
id int primary key,
name varchar(50),
plz int,
lid int,
lname varchar(50));

insert into landkreis (name) 
    select name from ort 
        where(lid is null);

update ort set lid=(
    select id from landkreis 
        where name=ort.name limit 1) 
where lid is null;

update landkreis set bid=(
    select id from bundesland 
        where (name=(
            select bundesland from csv_ort 
                where(ort=landkreis.name) 
            limit 1)) 
    limit 1) 
where (bid is null);

select 
    o.Name as Ort, 
    (select Name from Landkreis l 
        where(id=o.lid)) as Landkreis, 
    (select Name from Bundesland 
        where(id in 
            (select bid from Landkreis 
                where(id=o.lid)))) as Bundesland 
from Ort o;