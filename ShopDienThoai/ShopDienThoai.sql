CREATE DATABASE ShopDienThoai
GO
USE ShopDienThoai
GO

CREATE TABLE KhachHang
(
	MaKH			VARCHAR(10)		PRIMARY KEY,
	HoKH			NVARCHAR(25)	NOT NULL,
	TenKH			NVARCHAR(10)	NOT NULL,
	GioiTinh		BIT				NULL DEFAULT(1),
	CMND			VARCHAR(15)		NULL,
	DienThoai		VARCHAR(11)		NULL,
	DiaChi			NVARCHAR(100)	NULL,
	GhiChu			NVARCHAR(50)	NULL
)

INSERT INTO KhachHang (MaKH, HoKH, TenKH, GioiTinh, CMND, DienThoai, DiaChi, GhiChu) VALUES  
('KH001', N'Nguyễn', N'Sơn Tùng', 1, '012345678', '0909123456', N'123 Đường 1, Quận 1, TP.HCM', NULL),
('KH002', N'Trần', N'Thanh Bình', 1, '012345679', '0909123457', N'456 Đường 2, Quận 2, TP.HCM', NULL),
('KH003', N'Lê', N'Hùng Cường', 1, '012345680', '0909123458', N'789 Đường 3, Quận 3, TP.HCM', NULL),
('KH004', N'Huyền', N'Ngọc Dung', 0, '012345681', '0909123459', N'123 Đường 4, Quận 4, TP.HCM', NULL),
('KH005', N'Đoàn', N'Thị Nở', 0, '012345682', '0909123460', N'456 Đường 5, Quận 5, TP.HCM', NULL),
('KH006', N'Phan', N'Tấn Trung', 1, '012345683', '0909123461', N'789 Đường 6, Quận 6, TP.HCM', NULL),
('KH007', N'Võ', N'Mạnh Hoàng', 1, '012345684', '0909123462', N'123 Đường 7, Quận 7, TP.HCM', NULL),
('KH008', N'Đỗ', N'Nhật Linh', 0, '012345685', '0909123463', N'456 Đường 8, Quận 8, TP.HCM', NULL),
('KH009', N'Đào', N'Như Ý', 0, '012345686', '0909123464', N'789 Đường 9, Quận 9, TP.HCM', NULL),
('KH010', N'Nguyễn', N'Quỳnh Anh', 1, '012345687', N'0909123465', N'123 Đường 10, Quận 10, TP.HCM', NULL);
SELECT * FROM KhachHang
GO
CREATE TABLE LoaiHang
(
	MaLoaiHang		INT IDENTITY(1,1)	PRIMARY KEY,
	TenLoaiHang		NVARCHAR(20)		NOT NULL
)

INSERT INTO LoaiHang (TenLoaiHang) VALUES ('Apple');
INSERT INTO LoaiHang (TenLoaiHang) VALUES ('Samsung');
INSERT INTO LoaiHang (TenLoaiHang) VALUES ('Xiaomi');
INSERT INTO LoaiHang (TenLoaiHang) VALUES ('Vivo');
INSERT INTO LoaiHang (TenLoaiHang) VALUES ('Oppo');
INSERT INTO LoaiHang (TenLoaiHang) VALUES ('Huawei');
INSERT INTO LoaiHang (TenLoaiHang) VALUES ('Realme');
INSERT INTO LoaiHang (TenLoaiHang) VALUES ('Lenovo');
INSERT INTO LoaiHang (TenLoaiHang) VALUES ('Sony');
INSERT INTO LoaiHang (TenLoaiHang) VALUES ('Asus');
INSERT INTO LoaiHang (TenLoaiHang) VALUES ('Vsmart');


GO
CREATE TABLE HangHoa
(
	MaHang			VARCHAR(15)		PRIMARY KEY,
	TenHang			NVARCHAR(40)	NOT NULL UNIQUE,
	MaLoaiHang		INT				NOT NULL FOREIGN KEY REFERENCES LoaiHang(MaLoaiHang),
	SoLuong			INT				NOT NULL,
	DVT				NVARCHAR(10)	NOT NULL,
	BaoHanh			INT				NULL,
	GiaNhap			FLOAT				NOT NULL,
	GhiChu			NVARCHAR(50)	NULL,
	MoTa			NVARCHAR(200)	NULL,
	HinhAnh			varchar(50)
)

-- Apple
INSERT INTO HangHoa (MaHang, TenHang, MaLoaiHang, SoLuong, DVT, BaoHanh, GiaNhap, GhiChu, MoTa, HinhAnh) VALUES 
('IP13P256G', 'iPhone 13 Pro 256GB', 1, 50, N'Chiếc', 12, 2400000, NULL, N'Màn hình 6.1 inch, chip A15 Bionic','iphone1.jpg'),
('IP13P128G', 'iPhone 13 Pro 128GB', 1, 50, N'Chiếc', 12, 2200000, NULL, N'Màn hình 6.1 inch, chip A15 Bionic','iphone2.jpg'),
('IP12P64G', 'iPhone 12 Pro 64GB', 1, 30, N'Chiếc', 12, 1800000, NULL, N'Màn hình 6.1 inch, chip A14 Bionic','iphone3.jpg');

-- Samsung
INSERT INTO HangHoa (MaHang, TenHang, MaLoaiHang, SoLuong, DVT, BaoHanh, GiaNhap, GhiChu, MoTa, HinhAnh) VALUES 
('SSG21U256G', 'Samsung Galaxy S21 Ultra 256GB', 2, 40, N'Chiếc', 12, 2000000, NULL, N'Màn hình 6.8 inch, Exynos 2100','samsung1.jpg'),
('SSG21P128G', 'Samsung Galaxy S21+ 128GB', 2, 40, N'Chiếc', 12, 1800000, NULL, N'Màn hình 6.7 inch, Exynos 2100','samsung2.jpg'),
('SSG20F128G', 'Samsung Galaxy S20 FE 128GB', 2, 60, N'Chiếc', 12, 1500000, NULL, N'Màn hình 6.5 inch, Snapdragon 865','samsung3.jpg');

-- Xiaomi
INSERT INTO HangHoa (MaHang, TenHang, MaLoaiHang, SoLuong, DVT, BaoHanh, GiaNhap, GhiChu, MoTa, HinhAnh) VALUES 
('XMP11P256G', 'Xiaomi Mi 11 Pro 256GB', 3, 50, N'Chiếc', 12, 1700000, NULL, N'Màn hình 6.81 inch, Snapdragon 888','xiaomi1.jpg'),
('XMP11U128G', 'Xiaomi Mi 11 Ultra 128GB', 3, 40, N'Chiếc', 12, 1900000, NULL, N'Màn hình 6.81 inch, Snapdragon 888','xiaomi2.jpg'),
('XMRN10P128G', 'Xiaomi Redmi Note 10 Pro 128GB', 3, 60, N'Chiếc', 12, 800000, NULL, N'Màn hình 6.67 inch, Snapdragon 732G','xiaomi3.jpg');

-- Vivo
INSERT INTO HangHoa (MaHang, TenHang, MaLoaiHang, SoLuong, DVT, BaoHanh, GiaNhap,  GhiChu, MoTa, HinhAnh) VALUES 
('VVX60P256G', 'Vivo X60 Pro 256GB', 4, 40, N'Chiếc', 12, 1400000, NULL, N'Màn hình 6.56 inch, Snapdragon 870','vivo1.jpg'),
('VVX50P128G', 'Vivo X50 Pro 128GB', 4, 50, N'Chiếc', 12, 1200000, NULL, N'Màn hình 6.56 inch, Snapdragon 765G','vivo2.jpg'),
('VVY20S64G', 'Vivo Y20s 64GB', 4, 70, N'Chiếc', 12, 400000, NULL, N'Màn hình 6.51 inch, Snapdragon 460','vivo3.jpg');

-- Oppo
INSERT INTO HangHoa (MaHang, TenHang, MaLoaiHang, SoLuong, DVT, BaoHanh, GiaNhap,  GhiChu, MoTa, HinhAnh) VALUES 
('OPR8P256G', 'Oppo Reno8 Pro 256GB', 5, 40, N'Chiếc', 12, 1500000, NULL, N'Màn hình 6.55 inch, Snapdragon 870','oppo1.jpg'),
('OPR7P128G', 'Oppo Reno7 Pro 128GB', 5, 50, N'Chiếc', 12, 1300000, NULL, N'Màn hình 6.55 inch, Snapdragon 765G','oppo2.jpg'),
('OPA74G128G', 'Oppo A74 128GB', 5, 70, N'Chiếc', 12, 500000, NULL, N'Màn hình 6.43 inch, Snapdragon 662','oppo3.jpg');

-- Huawei
INSERT INTO HangHoa (MaHang, TenHang, MaLoaiHang, SoLuong, DVT, BaoHanh, GiaNhap,  GhiChu, MoTa, HinhAnh) VALUES 
('HWP40P256G', 'Huawei P40 Pro 256GB', 6, 30, N'Chiếc', 12, 1700000, NULL, N'Màn hình 6.58 inch, Kirin 990 5G','huawei1.jpg'),
('HWP30P128G', 'Huawei P30 Pro 128GB', 6, 40, N'Chiếc', 12, 1500000, NULL, N'Màn hình 6.47 inch, Kirin 980','huawei2.jpg'),
('HWY9P128G', 'Huawei Y9 Prime 128GB', 6, 60, N'Chiếc', 12, 600000, NULL, N'Màn hình 6.59 inch, Kirin 710F','huawei3.jpg');

-- Realme
INSERT INTO HangHoa (MaHang, TenHang, MaLoaiHang, SoLuong, DVT, BaoHanh, GiaNhap,  GhiChu, MoTa, HinhAnh) VALUES 
('RMLX50P128G', 'Realme X50 Pro 128GB', 7, 50, N'Chiếc', 12, 1300000, NULL, N'Màn hình 6.44 inch, Snapdragon 865','realme1.jpg'),
('RML7P128G', 'Realme 7 Pro 128GB', 7, 50, N'Chiếc', 12, 800000, NULL, N'Màn hình 6.4 inch, Snapdragon 720G','realme2.jpg'),
('RML6I128G', 'Realme 6i 128GB', 7, 70, N'Chiếc', 12, 400000, NULL, N'Màn hình 6.5 inch, Helio G80','realme3.jpg');

-- Lenovo
INSERT INTO HangHoa (MaHang, TenHang, MaLoaiHang, SoLuong, DVT, BaoHanh, GiaNhap,  GhiChu, MoTa, HinhAnh) VALUES 
('LNLZ5P256G', 'Lenovo Z5 Pro 256GB', 8, 30, N'Chiếc', 12, 1200000, NULL, N'Màn hình 6.39 inch, Snapdragon 710','lenovo1.jpg'),
('LNLZ6P128G', 'Lenovo Z6 Pro 128GB', 8, 40, N'Chiếc', 12, 1300000, NULL, N'Màn hình 6.39 inch, Snapdragon 855','lenovo2.jpg'),
('LNLP2P64G', 'Lenovo P2 64GB', 8, 50, N'Chiếc', 12, 700000, NULL, N'Màn hình 5.5 inch, Snapdragon 625','lenovo3.jpg');

-- Sony
INSERT INTO HangHoa (MaHang, TenHang, MaLoaiHang, SoLuong, DVT, BaoHanh, GiaNhap,  GhiChu, MoTa, HinhAnh) VALUES 
('SNY1II256G', 'Sony Xperia 1 II 256GB', 9, 30, N'Chiếc', 12, 1800000, NULL, N'Màn hình 6.5 inch, Snapdragon 865','sony1.jpg'),
('SNY5II128G', 'Sony Xperia 5 II 128GB', 9, 40, N'Chiếc', 12, 1600000, NULL, N'Màn hình 6.1 inch, Snapdragon 865','sony2.jpg'),
('SNY10II64G', 'Sony Xperia 10 II 64GB', 9, 60, N'Chiếc', 12, 700000, NULL, N'Màn hình 6.0 inch, Snapdragon 665','sony3.jpg');

-- Asus
INSERT INTO HangHoa (MaHang, TenHang, MaLoaiHang, SoLuong, DVT, BaoHanh, GiaNhap,  GhiChu, MoTa, HinhAnh) VALUES 
('ASSRG3P256G', 'Asus ROG Phone 3 256GB', 10, 30, N'Chiếc', 12, 1600000, NULL, N'Màn hình 6.59 inch, Snapdragon 865+','asus1.jpg'),
('ASSZF7P128G', 'Asus Zenfone 7 Pro 128GB', 10, 40, N'Chiếc', 12, 1500000, NULL, N'Màn hình 6.67 inch, Snapdragon 865','asus2.jpg'),
('ASSZ6P64G', 'Asus Zenfone 6 64GB', 10, 50, N'Chiếc', 12, 1000000, NULL, N'Màn hình 6.4 inch, Snapdragon 855','asus3.jpg');

-- Vsmart
INSERT INTO HangHoa (MaHang, TenHang, MaLoaiHang, SoLuong, DVT, BaoHanh, GiaNhap,  GhiChu, MoTa, HinhAnh) VALUES 
('VSARIS128G', 'Vsmart Aris 128GB', 11, 50, N'Chiếc', 12, 600000, NULL, N'Màn hình 6.39 inch, Snapdragon 730','vsmart1.jpg'),
('VSALIVE64G', 'Vsmart Live 64GB', 11, 60, N'Chiếc', 12, 400000, NULL, N'Màn hình 6.2 inch, Snapdragon 675','vsmart2.jpg'),
('VSJOY32G', 'Vsmart Joy 3 32GB', 11, 70, N'Chiếc', 12, 200000, NULL, N'Màn hình 6.5 inch, Snapdragon 632','vsmart3.jpg');


GO
CREATE TABLE NhomNV
(
	MaNhomNV		VARCHAR(5)		PRIMARY KEY,
	TenNhomNV		NVARCHAR(20)	NOT NULL
)

INSERT INTO NhomNV (MaNhomNV, TenNhomNV) VALUES ('01', 'Admin');
INSERT INTO NhomNV (MaNhomNV, TenNhomNV) VALUES ('02', 'Sales');
INSERT INTO NhomNV (MaNhomNV, TenNhomNV) VALUES ('03', 'Kho');

GO
CREATE TABLE NhanVien
(
	MaNV			VARCHAR(5)		PRIMARY KEY,
	HoNV			NVARCHAR(30)	NOT NULL,
	TenNV			NVARCHAR(30)	NOT NULL,
	GioiTinh		BIT				NOT NULL DEFAULT(1),
	NgaySinh		VARCHAR(15)			NOT NULL,
	CMND			VARCHAR(13)		NOT NULL,
	Email			VARCHAR(40)		NULL,
	DienThoai		VARCHAR(11)		NOT NULL,
	DiaChi			NVARCHAR(100)	NULL,
	GhiChu			NVARCHAR(50)	NULL,
	MaNhomNV		VARCHAR(5)		NOT NULL FOREIGN KEY REFERENCES NhomNV(MaNhomNV)
)

INSERT INTO NhanVien (MaNV, HoNV,TenNV, GioiTinh, NgaySinh, CMND, Email, DienThoai, DiaChi, GhiChu, MaNhomNV) 
VALUES ('NV001', N'Nguyễn',N'Võ Quốc Đại', 1, '01/01/1980', '123456789', 'a@example.com', '0901234567', '123 Main St', N'Nhân viên quản trị', '01');
INSERT INTO NhanVien (MaNV, HoNV, TenNV, GioiTinh, NgaySinh, CMND, Email, DienThoai, DiaChi, GhiChu, MaNhomNV) 
VALUES ('NV002', N'Nguyễn',N'Thanh Tùng', 0, '02/02.1986', '987654321', 'b@example.com', '0902345678', '456 Main St', N'Nhân viên bán hàng', '02');
INSERT INTO NhanVien (MaNV, HoNV,TenNV, GioiTinh, NgaySinh, CMND, Email, DienThoai, DiaChi, GhiChu, MaNhomNV) 
VALUES ('NV003',N'Bùi',N'Hoàng Khôi', 1, '03/03/1999', '456789123', 'c@example.com', '0903456789', '789 Main St', N'Nhân viên thủ kho', '03');

CREATE TABLE Account
(
	Username		VARCHAR(20)		PRIMARY KEY,
	Pass			VARCHAR(32)		NOT NULL,
	MaNV			VARCHAR(5)		NOT NULL FOREIGN KEY REFERENCES NhanVien(MaNV)	
)
GO

INSERT INTO Account (Username, Pass, MaNV) VALUES ('admin', 'admin', 'NV001');
INSERT INTO Account (Username, Pass, MaNV) VALUES ('sales', 'sales', 'NV002');
INSERT INTO Account (Username, Pass, MaNV) VALUES ('kho', 'kho', 'NV003');

CREATE TABLE BaoHanh
(
	MaKH			VARCHAR(10)		NOT NULL FOREIGN KEY REFERENCES KhachHang(MaKH),
	TenHang			NVARCHAR(40)	NOT NULL,
	SoIMEI			VARCHAR(15)		NOT NULL,
	MoTaLoi			NVARCHAR(100)	NOT NULL,
	ChiPhi			FLOAT				NULL,
	NgayHenTra		VARCHAR(15)			NULL,
	GhiChu			NVARCHAR(50)	NULL,
	CONSTRAINT PK_BaoHanh PRIMARY KEY (MaKH,SoIMEI)
)
GO
CREATE TABLE HoaDon
(
	MaHD			VARCHAR(15)		PRIMARY KEY,
	MaKH			VARCHAR(10)		NOT NULL FOREIGN KEY REFERENCES KhachHang(MaKH),
	NgayMua			VARCHAR(15)		NOT NULL,
	MaNV			VARCHAR(5)		NOT NULL FOREIGN KEY REFERENCES NhanVien(MaNV),
	NgayLap			VARCHAR(15)		NOT NULL,
	GhiChu			NVARCHAR(100)	NULL
)
GO
CREATE TABLE CTHoaDon
(
	MaHD			VARCHAR(15)		NOT NULL FOREIGN KEY REFERENCES HoaDon(MaHD),
	MaHang			VARCHAR(15)		NOT NULL FOREIGN KEY REFERENCES HangHoa(MaHang),
	SoLuong			INT				NOT NULL,
	DonGia			FLOAT			NOT NULL,
	GiamGia			FLOAT			NULL,
	CONSTRAINT PK_CTHoaDon PRIMARY KEY (MaHD,MaHang)
)
GO
CREATE TABLE PhanQuyen
(
	MaNhomNV	VARCHAR(5)	NOT NULL FOREIGN KEY REFERENCES dbo.NhomNV(MaNhomNV),
	BanHang		BIT			NOT NULL DEFAULT(0),
	KhachHang	BIT			NOT NULL DEFAULT(0),
	HangHoa		BIT			NOT NULL DEFAULT(0),
	TonKho		BIT			NOT NULL DEFAULT(0),
	NhanVien	BIT			NOT NULL DEFAULT(0),
	PhanQuyen	BIT			NOT NULL DEFAULT(0),
	DoanhSo		BIT			NOT NULL DEFAULT(0),
	LoiNhuan	BIT			NOT NULL DEFAULT(0),
	CONSTRAINT PK_PhanQuyen	PRIMARY KEY(MaNhomNV)
)
select * from Account
INSERT INTO PhanQuyen (MaNhomNV, BanHang, KhachHang, HangHoa, TonKho, NhanVien, PhanQuyen, DoanhSo, LoiNhuan)
VALUES ('01', 1, 1, 1, 1, 1, 1, 1, 1);  -- Admin có tất cả quyền
INSERT INTO PhanQuyen (MaNhomNV, BanHang, KhachHang, HangHoa, TonKho, NhanVien, PhanQuyen, DoanhSo, LoiNhuan)
VALUES ('02', 1, 1, 0, 0, 0, 0, 1, 1);  -- Sales có quyền liên quan đến bán hàng và khách hàng
INSERT INTO PhanQuyen (MaNhomNV, BanHang, KhachHang, HangHoa, TonKho, NhanVien, PhanQuyen, DoanhSo, LoiNhuan)
VALUES ('03', 0, 0, 1, 1, 0, 0, 0, 0);  -- Kho có quyền liên quan đến hàng hóa và tồn kho

SELECT * FROM HangHoa
SELECT * FROM KhachHang
SELECT * FROM NhomNV;
select * from PhanQuyen
SELECT * FROM NhanVien
SELECT * FROM HoaDon

-- Thêm dữ liệu cho bảng HoaDon
INSERT INTO HoaDon (MaHD, MaKH, NgayMua, MaNV, NgayLap) VALUES 
('HD001', 'KH001', '01/05/2024', 'NV002', '01/05/2024'),
('HD002', 'KH002', '01/05/2024', 'NV002', '02/05/2024');

-- Thêm dữ liệu cho bảng CTHoaDon
INSERT INTO CTHoaDon (MaHD, MaHang, SoLuong, DonGia, GiamGia) VALUES 
-- Hóa đơn HD001
('HD001', 'IP13P256G', 1, 3000000, 0),
('HD001', 'IP13P128G', 1, 2800000, 0),
-- Hóa đơn HD002
('HD002', 'SSG21U256G', 1, 3500000, 5),
('HD002', 'SSG21P128G', 2, 3200000, 10);
SELECT * FROM CTHoaDon




DROP PROCEDURE IF EXISTS sp_DoanhSo;  
GO
CREATE PROCEDURE sp_DoanhSo
    @MaNV VARCHAR(5),
    @NgayBatDau VARCHAR(15),
    @NgayKetThuc VARCHAR(15)
AS
BEGIN
    -- Đảm bảo không trả về số lượng dòng ảnh hưởng
    SET NOCOUNT ON;
    DECLARE @NgayBatDauDate DATE = CONVERT(DATE, @NgayBatDau, 103);
    DECLARE @NgayKetThucDate DATE = CONVERT(DATE, @NgayKetThuc, 103);

    SELECT 
        CONVERT(DATE, HD.NgayLap, 103) AS Ngay,
        SUM(CT.SoLuong * (CT.DonGia - CT.DonGia * CT.GiamGia/100)) AS TongTien,
        SUM(CT.SoLuong) AS TongSanPham
    FROM HoaDon HD
    JOIN CTHoaDon CT ON HD.MaHD = CT.MaHD
    WHERE HD.MaNV = @MaNV 
      AND CONVERT(DATE, HD.NgayLap, 103) BETWEEN @NgayBatDauDate AND @NgayKetThucDate
    GROUP BY CONVERT(DATE, HD.NgayLap, 103)
    ORDER BY CONVERT(DATE, HD.NgayLap, 103);
END;
EXEC sp_DoanhSo @MaNV = 'NV002', @NgayBatDau = '01/05/2024', @NgayKetThuc = '31/05/2024';
