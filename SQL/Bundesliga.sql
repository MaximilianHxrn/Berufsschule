-- Alle Bundesliga Vereine
Create view BLMannschaft as select * from Mannschaft where(L_ID=1);
select * from BLMannschaft;

-- Seite 92 Aufg 1:
-- BL mit Punkten
select 
    MannschName as Mannschaft, 
    
    (select Sum(Punkte) from ZT_Spiel_Mannschaft 
        where(M_ID=BLMannschaft.M_ID)) 
    as Punkte 

from BLMannschaft 
order by Punkte desc;


-- BL mit Punkten und Spieltagen
select 
    MannschName as Mannschaft, 
    
    (select Sum(Punkte) from ZT_Spiel_Mannschaft 
        where(M_ID=BLMannschaft.M_ID)) 
    as Punkte, 
    
    (select Count(Spieltag) from Spiel 
        where(SP_ID in 
            (select SP_ID from ZT_SPiel_Mannschaft 
                where(M_ID=BLMannschaft.M_ID)))) 
    as Spiele 

from BLMannschaft 
order by Punkte desc;


-- BL mit Punkten, Toren und Spieltagen    
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
-- BL mit Punkten, Rang, Toren und Spieltagen
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
-- Tor Differenz für Mannschaft ausrechnen
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

-- Endergebnis
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

-- Gespeichert als Funktion
delimiter //
create procedure Spielstand()
begin
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

-- Als Einzeiler
select (@CurRow := @CurRow + 1) as Rang, MannschName as Mannschaft, (select Count(Spieltag) from Spiel where(SP_ID in (select SP_ID from ZT_SPiel_Mannschaft where(M_ID=BLMannschaft.M_ID)))) as Spiele, (select Sum(TorDiff(SP_ID, M_ID)) from ZT_Spiel_Mannschaft where(M_ID=BLMannschaft.M_ID)) as Tore, (select Sum(Punkte) from ZT_Spiel_Mannschaft where(M_ID=BLMannschaft.M_ID)) as Punkte from BLMannschaft, (select @CurRow := 0) as temp;