use Tu_hoc_di
/*create table Danh_sach_sinh_vien_tot_nghiep
(
	STT int ,
	Ho_ten nvarchar(100),
	Gioi_tinh nvarchar(10),
	Ngay_sinh nvarchar(50),
	Noi_sinh nvarchar(50),
	Diem_TBTL_thang_diem_10 float,
	Diem_TBTL_thang_diem_4 float, 
	Ren_luyen nvarchar(10)
);*/
--alter table Danh_sach_sinh_vien_tot_nghiep alter column Gioi_tinh nvarchar(20) null
--alter table Danh_sach_sinh_vien_tot_nghiep add Xep_loai_TN nvarchar(10) null
insert into Danh_sach_sinh_vien_tot_nghiep(STT,Ho_ten,Gioi_tinh,)