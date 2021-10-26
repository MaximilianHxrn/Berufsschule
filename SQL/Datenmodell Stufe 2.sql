-- Seite 85 Aufg 1:
SELECT S_ID, M_ID, Name, Vorname, Geschlecht, Gehalt_Monatl from Spieler;

-- Seite 85 Aufg 2:
SELECT Name, Vorname, GebDat  from Spieler ORDER BY Name ASC;

-- Seite 85 Aufg 3:
SELECT CONCAT(Spieler.Vorname, " ", Spieler.Name) as Name, GebDat from SPieler order by Name;

-- Seite 85 Aufg 4:
select length(Spieler.Name) from Spieler;

-- Seite 85 Aufg 5:
SELECT * from Ort where(PLZ like '8%');

-- Seite 85 Aufg 6:
SELECT * from Ort where(Ort like "M%" or Ort like "L%" or Ort like "N%" or Ort like "K%") ORDER BY Ort DESC; 

-- Seite 85 Aufg 7:
select Name, Vorname, Gehalt_Monatl from Spieler where(gehalt_monatl> 600000);

-- Seite 85 Aufg 8:
select Name, Vorname, Ruecken_nr from spieler where(ruecken_nr=1);

-- Seite 85 Aufg 9:
select Name from Mannschaft where(MannschName like "FC%");

-- Seite 86 Aufg 1:
SELECT COUNT(*) as Anzahl from Verein;

-- Seite 86 Aufg 2:
SELECT COUNT(*) as Anzahl from Spieler WHERE(Ruecken_Nr=1);

-- Seite 86 Aufg 3:
SELECT SUM(Gehalt_Monatl) as Summe_Gehalt from Spieler;

-- Seite 86 Aufg 4:
SELECT SUM(Gehalt_Monatl) as Summe_Gehalt from Spieler where(Ruecken_Nr=1);

-- Seite 86 Aufg 5:
SELECT MAX(Gehalt_Monatl) as Max_Gehalt, MIN(Gehalt_Monatl) as Min_Gehalt, Cast(AVG(Gehalt_Monatl) as Decimal(18,2)) as Avg_Gehalt from Spieler;

-- Seite 87 Aufg 1:
Select Kategorie.Beschreibung, Kategorie.Spielerzahl, Kategorie.Torgroesse from Kategorie LEFT JOIN Groesse_Spielfeld on Kategorie.GR_ID = Groesse_Spielfeld.Gr_ID UNION ALL select Groesse_Spielfeld.Beschreibung, Groesse_Spielfeld.Laenge, Groesse_Spielfeld.Breite from Groesse_Spielfeld right join Kategorie on Kategorie.Gr_ID = Groesse_SPielfeld.Gr_ID;

-- Seite 87 Aufg 5:
select * from Spieler where(M_ID="");

-- Seite 87 Aufg 7:
select Beschreibung, Spielerzahl from Kategorie where(Spielerzahl=7);

-- Seite 87 Aufg 8:
Select * from Verein where (GF_ID=1);

-- Seite 87 Aufg 9:
select MannschName from Mannschaft where(M_ID in (select M_ID from ZT_Spiel_Mannschaft where(Heimmannschaft=1 AND SP_ID in (Select SP_ID from Spiel where(Ergebnis="2:1")))));

-- Seite 88 Aufg 1:
select Mannschaft.MannschName, Count(S_ID) as Anzahl from Spieler left join Mannschaft on Spieler.M_ID = Mannschaft.M_ID group by MannschName;

-- Seite 88 Aufg 2:
select Mannschaft.MannschName, Count(S_ID) as Anzahl from Spieler left join Mannschaft on Spieler.M_ID = Mannschaft.M_ID where(NAT="BRA") group by MannschName;

-- Seite 88 Aufg 3:
select Gesellschaftsform.Bezeichnung, Count(V_ID) as Anzahl from Verein left join Gesellschaftsform on Verein.GF_ID = Gesellschaftsform.GF_ID group by Bezeichnung;

-- Seite 89 Aufg 1:
select S_ID, Name, Vorname, Ruecken_Nr from Spieler where(Ruecken_Nr = (select Count(S_ID) from Spieler where(NAT="AUT" AND M_ID in (select M_ID from Mannschaft where(MannschName="Mainz 05 Profis Herren")))));

-- Seite 89 Aufg 2:
select * from Spieler where ((select TimeStampDiff (Year, GebDat, CurDate())) in (select Laenge from Groesse_Spielfeld where(Beschreibung="Minispielfeld")));

-- Seite 89 Aufg 3:
select S_ID, Name, Vorname, Ruecken_Nr from Spieler where(Ruecken_Nr = (select Count(S_ID) from Spieler where(NAT="BRA" AND M_ID in (select M_ID from Mannschaft where(MannschName="VfL Woflsburg Profis Herren")))) and (select TimeStampDiff (Year, GebDat, CurDate())) >= (select Laenge from Groesse_Spielfeld where(Beschreibung="Minispielfeld")));

-- Seite 90 Aufg 1:
Create view BLMannschaft as select * from Mannschaft where(L_ID=1);
select * from BLMannschaft;

-- Seite 90 Aufg 2:
create view Spieler_MLN as select S_ID, Name, Vorname, Liga.Beschreibung, Nationalitaet.Bezeichnung from Spieler left join Liga on Liga.L_ID=(select L_ID from Mannschaft where(M_ID=Spieler.M_ID)) left join Nationalitaet on Spieler.NAT=Nationalitaet.NAT;
select * from Spieler_MLN where(Beschreibung="1. Bundesliga Herren" and Bezeichnung="Österreich");

-- Seite 92 Aufg 1:
select MannschName as Mannschaft, (select Sum(Punkte) from ZT_Spiel_Mannschaft where(M_ID=BLMannschaft.M_ID)) as Punkte from BLMannschaft order by Punkte desc;
select MannschName as Mannschaft, (select Sum(Punkte) from ZT_Spiel_Mannschaft where(M_ID=BLMannschaft.M_ID)) as Punkte, (select Count(Spieltag) from Spiel where(SP_ID in (select SP_ID from ZT_SPiel_Mannschaft where(M_ID=BLMannschaft.M_ID)))) as Spiele from BLMannschaft order by Punkte desc;
    
select 
    MannschName as Mannschaft, 
    (select Count(Spieltag) from Spiel 
        where(SP_ID in 
            (select SP_ID from ZT_SPiel_Mannschaft 
                where(M_ID=BLMannschaft.M_ID)))) as Spiele, 
    (select Sum(Tore) from ZT_Spiel_Mannschaft 
        where(M_ID=BLMannschaft.M_ID)) as Tore, 
    (select Sum(Punkte) from ZT_Spiel_Mannschaft 
        where(M_ID=BLMannschaft.M_ID)) as Punkte 
from BLMannschaft 
order by Punkte desc;

-- Seite 92 Aufg 2:

drop view BLMannschaft; 
Create view BLMannschaft as 
    select * from Mannschaft
        where(L_ID=1) order by 
            (select Sum(Punkte) from ZT_Spiel_Mannschaft 
                where(M_ID=Mannschaft.M_ID)) desc;

select 
    (@CurRow := @CurRow + 1) as Rang, 
    MannschName as Mannschaft, 
    (select Count(Spieltag) from Spiel 
        where(SP_ID in 
            (select SP_ID from ZT_SPiel_Mannschaft 
                where(M_ID=BLMannschaft.M_ID)))) as Spiele, 
    (select Sum(Tore) from ZT_Spiel_Mannschaft 
        where(M_ID=BLMannschaft.M_ID)) as Tore, 
    (select Sum(Punkte) from ZT_Spiel_Mannschaft 
        where(M_ID=BLMannschaft.M_ID)) as Punkte 
from BLMannschaft, 
(select @CurRow := 0) as temp;

-- Seite 92 Aufg 3:
Delimiter //
CREATE function TorDiff (id int, ma_id INT)
    returns int
    Deterministic
    begin
        Declare temp1 int;
        Declare temp2 int;
        Select Tore into temp1 from ZT_Spiel_Mannschaft 
            where(SP_ID=id AND M_ID=ma_id);
        Select Tore into temp2 from ZT_Spiel_Mannschaft 
            where(SP_ID=id AND M_ID <> ma_id);
        return temp1 - temp2;
    END;//
Delimiter ;

select 
    (@CurRow := @CurRow + 1) as Rang, 
    MannschName as Mannschaft, 
    (select Count(Spieltag) from Spiel 
        where(SP_ID in 
            (select SP_ID from ZT_SPiel_Mannschaft 
                where(M_ID=BLMannschaft.M_ID)))) as Spiele, 
    (select Sum(TorDiff(SP_ID, M_ID)) from ZT_Spiel_Mannschaft 
        where(M_ID=BLMannschaft.M_ID)) as Tore, 
    (select Sum(Punkte) from ZT_Spiel_Mannschaft 
        where(M_ID=BLMannschaft.M_ID)) as Punkte 
from BLMannschaft, 
(select @CurRow := 0) as temp;


delimiter //
create procedure Spielstand()
BEGIN
select 
    (@CurRow := @CurRow + 1) as Rang, 
    MannschName as Mannschaft, 
    (select Count(Spieltag) from Spiel 
        where(SP_ID in 
            (select SP_ID from ZT_SPiel_Mannschaft 
                where(M_ID=BLMannschaft.M_ID)))) as Spiele, 
    (select Sum(TorDiff(SP_ID, M_ID)) from ZT_Spiel_Mannschaft 
        where(M_ID=BLMannschaft.M_ID)) as Tore, 
    (select Sum(Punkte) from ZT_Spiel_Mannschaft 
        where(M_ID=BLMannschaft.M_ID)) as Punkte 
from BLMannschaft, 
(select @CurRow := 0) as temp;
end;//
delimiter ;


select (@CurRow := @CurRow + 1) as Rang, MannschName as Mannschaft, (select Count(Spieltag) from Spiel where(SP_ID in (select SP_ID from ZT_SPiel_Mannschaft where(M_ID=BLMannschaft.M_ID)))) as Spiele, (select Sum(TorDiff(SP_ID, M_ID)) from ZT_Spiel_Mannschaft where(M_ID=BLMannschaft.M_ID)) as Tore, (select Sum(Punkte) from ZT_Spiel_Mannschaft where(M_ID=BLMannschaft.M_ID)) as Punkte from BLMannschaft, (select @CurRow := 0) as temp;

-- Seite 58 Aufg 8:
select 
    s.SP_ID, 
    s.Tag, 
    s.Uhrzeit, 
    (select MannschName from Mannschaft 
        where(M_ID=
                (select M_ID from ZT_Spiel_Mannschaft 
                    where(SP_ID=s.SP_ID AND Heimmannschaft=1) 
                )
            )
    ), 
    (select MannschName from Mannschaft 
        where(M_ID=
                (select M_ID from ZT_Spiel_Mannschaft 
                    where(SP_ID=s.SP_ID AND Heimmannschaft=0)
                )
            )
    ) 
from Spiel s;


-- Game Spielstand
delimiter //
create procedure Spielstand()
BEGIN
select 
    (@CurRow := @CurRow + 1) as Rang,
    Name, 
    (select Count(*) from Game 
        where(Sieger=Punktestand.id)) 
        as Punkte from Punktestand , 
    (select @CurRow := 0) as temp;
    end;//
delimiter ;

-- Aktuelles Game
Delimiter //
CREATE procedure Aktuell ()
    begin
        select * from game where(Sieger is null) order by id desc limit 1;
    END;//
Delimiter ;

-- Game Neue Einträge
Delimiter //
CREATE procedure NewGame (newmax int, newphilipp int, newrobert int, newmatthias int, newmarkus int)
    begin
        insert into game(id, max,philipp,robert,matthias,markus) values(((select id from (select * from baum.game) as sth order by id desc limit 1) + 1),newmax,newphilipp,newrobert,newmatthias,newmarkus);
    END;//
Delimiter ;

Delimiter //
CREATE procedure Sieger (newsieger int)
    begin
        update game set sieger=newsieger, Endzeit=now() where (id=(select id from (select * from baum.game) as sth order by id desc limit 1));
    END;//
Delimiter ;

Spielstand();
Aktuell();
NewGame(,,,,);
Sieger(id);

select Name, 
    (select Avg((floor(
            datediff(current_date(), gebdat)/365))) 
        from Spieler 
            where(M_ID=Mannschaft.M_ID)) 
    as "Alter" 
from Mannschaft 
where(V_ID=v.V_ID) from Verein v;