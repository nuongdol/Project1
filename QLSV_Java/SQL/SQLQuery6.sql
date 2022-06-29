create table ngươi_dung
(
	STT int,
	ID_nguoi_dung nvarchar(50),
	Ten_dang_nhap nvarchar(100),
	Matkhau nvarchar(10),
	Ngay_thang_nam_sinh nvarchar(20),
	Chuc_vu nvarchar(50),
	Khoa_vien nvarchar(50),
	Emai nvarchar(50),
	SDT int 
);
go 
create table Bai_giang_tai_lieu
(
	STT int ,
	Ma_bai_giang_tai_lieu nvarchar(50),
	Ten_bai_giang_tai_lieu nvarchar(100)

);
go 
create table khoa_hoc
(
	STT int,
	Ma_khoa_hoc nvarchar(50),
	Ten_khoa_hoc nvarchar(50),
	Ma_bai_giang_tai_lieu nvarchar(50),
	
);
go 
create table chi_tiet_khoa_hoc
(
	Ma_khoa_hoc nvarchar(50),
	Ma_bai_giang_tai_lieu nvarchar(50),
	Thoi_khoa_bieu nvarchar(50),
	Giang_vien nvarchar(50),
	Tien_do_hoc_tap nvarchar(50),
	Tinh_trang_khoa_hoc nvarchar(50)
);
go 
create table chi_tiet_bai_giang_tai_lieu
(
	Ma_bai_giang_tai_tai_lieu nvarchar(50),
	Tinh_trang nchar(10),
	nguoi_tao nvarchar(100)

);


