connect /as sysdba;

drop tablespace ssmusic including contents and datafiles;

CREATE TABLESPACE ssmusic LOGGING
DATAFILE 'D:\ssmusicBD\SSMUSIC.dbf' size 3M
extent management local segment space management auto; 

drop user user_ssmusic;

create user user_ssmusic profile default 
identified by 1234 
default tablespace ssmusic 
temporary tablespace temp 
account unlock; 

--permisos 

grant connect, resource,dba to user_ssmusic; 

connect user_ssmusic/1234;