Drop database if exists LTP_Datenbank;
Create database LTP_Datenbank;

use LTP_Datenbank;
Create table L(lnr int primary key auto_increment, lname varchar(60), status int, sitz varchar(60));
Create table T(tnr int primary key auto_increment, tname varchar(60), farbe varchar(60), gewicht int);
Create table P(pnr int primary key auto_increment, pname varchar(60), ort varchar(60));
Create table LTP(lnr int, tnr int, pnr int, menge int, foreign key (lnr) references L(lnr), foreign key (tnr) references t(tnr), foreign key (pnr) references P(pnr), primary key(tnr,lnr,pnr));

insert into L(lname,status,sitz) values('A', 10,'Berlin');
insert into L(lname,status,sitz) values('B', 40,'Muenchen');
insert into L(lname,status,sitz) values('C', 30,'Berlin');
insert into L(lname,status,sitz) values('Kobold', -1,'Kobol');

insert into T(tname,farbe, gewicht) values('Teil A', 'rot',20);
insert into T(tname,farbe, gewicht) values('Teil B', 'gelb',30);
insert into T(tname,farbe, gewicht) values('Teil C', 'schwarz',10);
insert into T(tname,farbe, gewicht) values('Nicht liefern', 'wei�',-1);
insert into T(tname,farbe, gewicht) values('Teil B', 'schwarz',30);

insert into P(pname, ort) values('Projekt 1', 'Berlin');
insert into P(pname, ort) values('Projekt 2', 'Berlin');
insert into P(pname, ort) values('Projekt 3', 'Muenchen');
insert into P(pname, ort) values('Projekt 4', 'B');

insert into LTP(lnr,tnr,pnr,menge) values (1,1,1,20);
insert into LTP(lnr,tnr,pnr,menge) values (1,2,1,30);
insert into LTP(lnr,tnr,pnr,menge) values (2,2,2,20);
insert into LTP(lnr,tnr,pnr,menge) values (2,2,1,40);
insert into LTP(lnr,tnr,pnr,menge) values (2,3,1,10);
insert into LTP(lnr,tnr,pnr,menge) values (1,3,3,10);
insert into LTP(lnr,tnr,pnr,menge) values (3,1,3,20);

insert into LTP(lnr,tnr,pnr,menge) values (2,5,2,20);
insert into LTP(lnr,tnr,pnr,menge) values (3,2,3,20);
insert into LTP(lnr,tnr,pnr,menge) values (3,5,3,20);


Select l.lnr,lname from L left join ltp on l.lnr = ltp.lnr where ltp.lnr is null;

Select l.lnr, lname, count(distinct pnr) as 'Anzahl belieferter Projekte' from l left join LTP on l.lnr = ltp.lnr group by l.lnr, lname;

Select p.pnr, pname, ifnull(sum(menge), 0) AS 'Anzahl gelieferter Teile' from p left join ltp on p.pnr = ltp.pnr group by p.pnr, pname;

Select l.lnr,lname, t.tnr, tname, sum(menge) AS 'Anzahl' from l natural join ltp natural join t group by 1,2,3,4; 

Select distinct l.lnr, lname, ifnull(ltp.tnr, '') AS 'tnr', ifnull(tname, '') AS 'tname' from l left join ltp on l.lnr = ltp.lnr left join t on t.tnr = ltp.tnr;  

Select t.tnr, tname, farbe from t natural join ltp natural join l where status >=30 group by t.tnr,tname,farbe having(count(distinct lnr)>=2);

Select p.pnr, pname, count(distinct ltp.tnr) as 'Anzahl unterschiedlicher gelieferter Teile' from p left join ltp on p.pnr = ltp.pnr group by p.pnr, pname having(count(distinct ltp.lnr)<=2);  



-- Aufg 1:
select lnr, lname from l where lnr not in (select lnr from ltp);

-- Aufg 2:
select l.lnr, l.lname, ltp.tnr, t.tname from l left join ltp on ltp.lnr = l.lnr left join t on ltp.tnr = t.tnr group by l.lnr, t.tnr;

-- Aufg 3:
select l.lnr, l.lname, Count(distinct ltp.pnr) as "Anzahl b. Proj." from l left join ltp on ltp.lnr=l.lnr group by l.lnr;

-- Aufg 4:
select p.pnr, p.pname, ifnull(Sum(menge), 0) as "Anzahl g. Teile" from p left join ltp on ltp.pnr = p.pnr group by p.pnr;

-- Aufg 5:
select l.lnr, l.lname, t.tnr, t.tname, (Sum(ltp.Menge)) as "Anzahl g. Menge" from l left join ltp on ltp.lnr = l.lnr left join t on t.tnr = ltp.tnr group by l.lnr, t.tnr having t.tnr > 0;

-- Aufg 6:
select t.tnr, t.tname, t.farbe from t left join ltp on ltp.tnr = t.tnr left join l on ltp.lnr = l.lnr where status >= 30  group by t.tnr, t.farbe having Count(distinct ltp.lnr) > 1; 

-- Aufg 7:
select p.pnr, p.pname, (select Count(distinct ltp.tnr) from ltp where(ltp.pnr = p.pnr)) as "Anz. unter. Teile" from p left join ltp on ltp.pnr = p.pnr group by ltp.pnr having Count(distinct ltp.lnr) <= 2 order by pnr;