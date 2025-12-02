package canhan;

import java.util.List;

public interface IQuanLyLop {
    void themSinhVien(SINHVIEN sv);
    boolean xoaSinhVien(String maSV);
    List<SINHVIEN> timKiem(String keyword);
    void sapXepTheoHoTen();
    void xuatDanhSach();
}
