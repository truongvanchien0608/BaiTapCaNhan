package canhan;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class QuanLyLop implements IQuanLyLop {
    // Thuoc tinh
    private List<SINHVIEN> danhSachSV;
    private String tenLop; // Thuoc tinh private de bao dam tinh dong goi

    // Constructor
    public QuanLyLop(String tenLop) {
        this.tenLop = tenLop;
        this.danhSachSV = new ArrayList<>();
    }
    
    // PHUONG THUC GETTER KHAC PHUC LOI "IS NOT VISIBLE"
    public String getTenLop() {
        return tenLop;
    }
    
    // Phuong thuc them sinh vien
    @Override
    public void themSinhVien(SINHVIEN sv) {
        danhSachSV.add(sv);
        System.out.println("Da them sinh vien " + sv.getHoTen() + " vao lop " + tenLop);
    }

    // Phuong thuc xoa sinh vien theo ma
    @Override
    public boolean xoaSinhVien(String maSV) {
        return danhSachSV.removeIf(sv -> sv.getMaSV().equalsIgnoreCase(maSV));
    }

    // Phuong thuc tim kiem theo tu khoa
    @Override
    public List<SINHVIEN> timKiem(String keyword) {
        List<SINHVIEN> ketQua = new ArrayList<>();
        String kwLower = keyword.toLowerCase();
        for (SINHVIEN sv : danhSachSV) {
            if (sv.getMaSV().toLowerCase().contains(kwLower) || 
                sv.getHoTen().toLowerCase().contains(kwLower) ||
                sv.getEmail().toLowerCase().contains(kwLower)) {
                ketQua.add(sv);
            }
        }
        return ketQua;
    }

    // Phuong thuc sap xep theo ho ten (tang dan)
    @Override
    public void sapXepTheoHoTen() {
        Collections.sort(danhSachSV, new Comparator<SINHVIEN>() {
            @Override
            public int compare(SINHVIEN sv1, SINHVIEN sv2) {
                // So sánh theo tên cuối cùng
                String ten1 = sv1.getHoTen().substring(sv1.getHoTen().lastIndexOf(' ') + 1);
                String ten2 = sv2.getHoTen().substring(sv2.getHoTen().lastIndexOf(' ') + 1);
                return ten1.compareToIgnoreCase(ten2);
            }
        });
        System.out.println("Da sap xep danh sach theo ho ten.");
    }

    // Phuong thuc xuat danh sach
    @Override
    public void xuatDanhSach() {
        if (danhSachSV.isEmpty()) {
            System.out.println(" Danh sach sinh vien trong.");
            return;
        }
        System.out.println("\n--- DANH SACH SINH VIEN LOP " + tenLop.toUpperCase() + " ---");
        for (SINHVIEN sv : danhSachSV) {
            sv.xuat();
            System.out.println("-------------------------------------");
        }
    }
    
    // Phuong thuc tinh diem trung binh chung (gia dinh)
    public double tinhDiemTBChung() {
        System.out.println("Thong bao: Chuc nang nay can bo sung them thong tin diem de tinh DTB chinh xac.");
        return 0.0;
    }
    
    // Phuong thuc tim sinh vien chinh quy nhan hoc bong (HB > 0)
    public List<SinhVienChinhQuy> locSinhVienChinhQuyQuyetHB() {
        List<SinhVienChinhQuy> svHB = new ArrayList<>();
        for (SINHVIEN sv : danhSachSV) {
            if (sv instanceof SinhVienChinhQuy) {
                SinhVienChinhQuy svcq = (SinhVienChinhQuy) sv;
                if (svcq.tinhHB() > 0) {
                    svHB.add(svcq);
                }
            }
        }
        return svHB;
    }
}
