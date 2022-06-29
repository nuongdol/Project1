use Tu_hoc_di
insert into sinh_vien (MSSV,TENSV,KHOA,NGAYSINH) values(1,'dang thi nuong','k64','18/04/1999')
insert into sinh_vien (MSSV,TENSV,KHOA,NGAYSINH) values(1,'dang thi ngoc','k64','20/04/1999')
insert into sinh_vien (MSSV,TENSV,KHOA,NGAYSINH) values(1,'dang thi thu huyen','k64','9/02/1999')
-- truy xuat bang--
--select MSSV,TENSV,KHOA,NGAYSINH from sinh_vien
delete from sinh_vien where TENSV='dang thi nuong'
select *from sinh_vien
--tim kiem trong bang sinh vien cac cot co ten sinh vien la dang thi thu huyen
select * from sinh_vien where TENSV='dang thi thu huyen'
--sap xep lai du lieu theo mot trat tu nhat dinh 
select * from sinh_vien order by TENSV, NGAYSINH
--menh de order by  se mac dinh sap xep theo chieu tang dan(ASC) neu muon sap xep theo chieu giam dan phai them cu phap DESC sau menh de order by
select *from sinh_vien order by TENSV desc
-- neu trong cau lenh select cung su dung menh de where vaf menh de order by thi menh de where phai nam truoc menh de order by 
select *from sinh_vien where NGAYSINH='20/04/1999' order by TENSV
-- loc du lieu theo mot dieu kien nao do thi su dung toan tu de loc du lieu--
--toan tu like
--tim cau cum tu dau
select *from sinh_vien where TENSV like'h%'
select *from sinh_vien where NGAYSINH like '2%'
--tim cac cum tu cuoi--
select *from sinh_vien where TENSV like '%n'
--tim theo cum tu ky tu 
select *from sinh_vien where TENSV like '%thu%'
--ki tu (_) duoc dung giong nhu ky tu dai dien % 
select *from sinh_vien where TENSV like '('