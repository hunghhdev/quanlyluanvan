
--
-- Database: `qlLuanVan`
--

-- --------------------------------------------------------

--
-- Table structure for table `tDeTai`
--

CREATE TABLE `tDeTai` (
  `STTDeTai` int(11) NOT NULL,
  `TenDeTai` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `YeuCauDeTai` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `GhiChu` varchar(255) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `tDeTai`
--

INSERT INTO `tDeTai` (`STTDeTai`, `TenDeTai`, `YeuCauDeTai`, `GhiChu`) VALUES
(1, '1 De Tai', 'lam de tai', 'nothing'),
(2, 'làm gái', '12', 'ád'),
(5, 'thích thích', 'ád', 'ads');

-- --------------------------------------------------------

--
-- Table structure for table `tGiaoVien`
--

CREATE TABLE `tGiaoVien` (
  `MaGiaoVien` varchar(11) COLLATE utf8_unicode_ci NOT NULL,
  `TenGiaoVien` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `HocVi` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `SoDT` varchar(11) COLLATE utf8_unicode_ci NOT NULL,
  `MaKhoa` varchar(11) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `tGiaoVien`
--

INSERT INTO `tGiaoVien` (`MaGiaoVien`, `TenGiaoVien`, `HocVi`, `SoDT`, `MaKhoa`) VALUES
('1', 'asd', 'asd', '123', '3'),
('2', 'asd', 'asd', '123', '2'),
('jav11', 'Chuyên JAV', 'thạc tiến', '123123', '3'),
('py2', 'deo thich py3', 'thac sy', '123', 'py3'),
('x12c', 'Nguyen van thu', 'giao su', '123456643', '2');

-- --------------------------------------------------------

--
-- Table structure for table `tKhoa`
--

CREATE TABLE `tKhoa` (
  `MaKhoa` varchar(11) COLLATE utf8_unicode_ci NOT NULL,
  `TenKhoa` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `DiaChi` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `SoDT` varchar(11) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `tKhoa`
--

INSERT INTO `tKhoa` (`MaKhoa`, `TenKhoa`, `DiaChi`, `SoDT`) VALUES
('1', 'Tâm Trạng ', 'asd', '123'),
('2', 'Tâm Thần', 'ổ x', 'asd'),
('3', 'Tâm Lý ', 'ád', 'ád'),
('py3', 'Python 3', 'python', '123'),
('ru', 'khoa ruby', 'van phòng', '123'),
('x12n', 'java 12', 'o c', '1234');

-- --------------------------------------------------------

--
-- Table structure for table `tPhanCong`
--

CREATE TABLE `tPhanCong` (
  `MaSinhVien` varchar(11) COLLATE utf8_unicode_ci NOT NULL,
  `STTDeTai` int(11) NOT NULL,
  `MaGVHuongDan` varchar(11) COLLATE utf8_unicode_ci NOT NULL,
  `MaGVPhanBien` varchar(11) COLLATE utf8_unicode_ci NOT NULL,
  `DiemGVHuongDan` int(11) NOT NULL,
  `DiemGVPhanBien` int(11) NOT NULL,
  `NhanXetGVHuongDan` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `NhanXetGVPhanBien` varchar(255) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `tPhanCong`
--

INSERT INTO `tPhanCong` (`MaSinhVien`, `STTDeTai`, `MaGVHuongDan`, `MaGVPhanBien`, `DiemGVHuongDan`, `DiemGVPhanBien`, `NhanXetGVHuongDan`, `NhanXetGVPhanBien`) VALUES
('1', 1, '1', '1', 100, 100, '100 này', 'ừa biết mà');

-- --------------------------------------------------------

--
-- Table structure for table `tSinhVien`
--

CREATE TABLE `tSinhVien` (
  `MaSV` varchar(11) COLLATE utf8_unicode_ci NOT NULL,
  `HoTenSV` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `Phai` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `NgaySinh` date NOT NULL,
  `SoDT` varchar(11) COLLATE utf8_unicode_ci NOT NULL,
  `DiaChi` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `MaKhoa` varchar(11) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `tSinhVien`
--

INSERT INTO `tSinhVien` (`MaSV`, `HoTenSV`, `Phai`, `NgaySinh`, `SoDT`, `DiaChi`, `MaKhoa`) VALUES
('1', 'Nguyen Van Tét', 'Nga My', '2018-06-07', '12345', 'Hàng xóm', '1'),
('2', 'cuc cut cute', 'Nga My', '2000-06-07', '12345', 'Hàng xóm', 'x12n'),
('c12', 'nguyen van tien', 'ads', '1999-01-03', '123', 'ad', 'py3'),
('x12', 'To tan tien', 'Cái Bang', '1999-02-03', '1231243', 'ngũ hành', 'x12n');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tDeTai`
--
ALTER TABLE `tDeTai`
  ADD PRIMARY KEY (`STTDeTai`);

--
-- Indexes for table `tGiaoVien`
--
ALTER TABLE `tGiaoVien`
  ADD PRIMARY KEY (`MaGiaoVien`),
  ADD KEY `MaKhoa` (`MaKhoa`);

--
-- Indexes for table `tKhoa`
--
ALTER TABLE `tKhoa`
  ADD PRIMARY KEY (`MaKhoa`);

--
-- Indexes for table `tPhanCong`
--
ALTER TABLE `tPhanCong`
  ADD KEY `DeTai` (`STTDeTai`),
  ADD KEY `MaSinhVien` (`MaSinhVien`);

--
-- Indexes for table `tSinhVien`
--
ALTER TABLE `tSinhVien`
  ADD PRIMARY KEY (`MaSV`),
  ADD KEY `MaKhoa` (`MaKhoa`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `tDeTai`
--
ALTER TABLE `tDeTai`
  MODIFY `STTDeTai` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `tGiaoVien`
--
ALTER TABLE `tGiaoVien`
  ADD CONSTRAINT `tGiaoVien_ibfk_1` FOREIGN KEY (`MaKhoa`) REFERENCES `tKhoa` (`MaKhoa`);

--
-- Constraints for table `tPhanCong`
--
ALTER TABLE `tPhanCong`
  ADD CONSTRAINT `DeTai` FOREIGN KEY (`STTDeTai`) REFERENCES `tDeTai` (`STTDeTai`),
  ADD CONSTRAINT `tPhanCong_ibfk_1` FOREIGN KEY (`MaSinhVien`) REFERENCES `tSinhVien` (`MaSV`);

--
-- Constraints for table `tSinhVien`
--
ALTER TABLE `tSinhVien`
  ADD CONSTRAINT `tSinhVien_ibfk_1` FOREIGN KEY (`MaKhoa`) REFERENCES `tKhoa` (`MaKhoa`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
