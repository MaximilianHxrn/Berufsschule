Drop Database if exists MySocialNetwork;
Create Database MySocialNetwork;

use MySocialNetwork;

Create Table Mitglied (id int primary key, name varchar(50), vorname varchar(50));
Create Table Mitglied_Abonniert (M_id int, Abonniert_id int, primary key(M_id,Abonniert_id));
Alter Table Mitglied_Abonniert Add Foreign Key (M_id) references Mitglied(id);
Alter Table Mitglied_Abonniert Add Foreign Key (Abonniert_id) references Mitglied(id);

Insert Into Mitglied values (1, 'Meier', 'Hubert');
Insert Into Mitglied values (2, 'Richter', 'Thomas');
Insert Into Mitglied values (3, 'Becker', 'Thomas');
Insert Into Mitglied values (4, 'Ritter', 'Franz');

Insert Into Mitglied_Abonniert values (1,2);
Insert Into Mitglied_Abonniert values (1,3);
Insert Into Mitglied_Abonniert values (1,4);
Insert Into Mitglied_Abonniert values (2,3);
Insert Into Mitglied_Abonniert values (3,2);
Insert Into Mitglied_Abonniert values (4,1);


 