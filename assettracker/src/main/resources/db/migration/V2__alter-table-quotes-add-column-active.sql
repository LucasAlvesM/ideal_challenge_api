alter table quotes add active tinyint;
update quotes set active = 1;
