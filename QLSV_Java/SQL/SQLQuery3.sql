use truong 
create table giang_vien
(
	MaGV nchar(10),
	TenGV nvarchar(50),
	Khoa nvarchar(50)
);

alter table dbo.giang_vien
	alter column MaGV char(5)