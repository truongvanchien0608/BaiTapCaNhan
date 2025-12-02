package canhan;

import java.util.Date;

public class SinhVienChinhQuy extends SINHVIEN {
    // Thuoc tinh
    private double diemRenLuyen;

    // Constructor
    public SinhVienChinhQuy(String maSV, String hoTen, Date ngaySinh, String email, HOSO hoSo, String maLop, String tenLop, double diemRenLuyen) {
        super(maSV, hoTen, ngaySinh, email, hoSo, maLop, tenLop);
        this.diemRenLuyen = diemRenLuyen;
    }

    public SinhVienChinhQuy() {
        super();
    }

    // Getters va Setters
    public double getDiemRenLuyen() {
        return diemRenLuyen;
    }

    // Phuong thuc nhap (ghi de)
    @Override
    public void nhap() {
        super.nhap();
        System.out.print("Nhap diem ren luyen: ");
        this.diemRenLuyen = scanner.nextDouble();
        scanner.nextLine();
    }

    // Phuong thuc xuat (ghi de)
    @Override
    public void xuat() {
        super.xuat();
        System.out.println("Loai SV: Chinh Quy");
        System.out.println("Diem ren luyen: " + diemRenLuyen);
        System.out.println("Xep loai RL: " + xepLoaiRL());
    }

    // Phuong thuc xep loai ren luyen
    public String xepLoaiRL() {
        if (diemRenLuyen >= 90) return "Xuat Sac";
        if (diemRenLuyen >= 80) return "Tot";
        if (diemRenLuyen >= 70) return "Kha";
        if (diemRenLuyen >= 60) return "Trung Binh Kha";
        return "Can co gang";
    }

    // Phuong thuc tinh hoc bong (ghi de)
    @Override
    public int tinhHB() {
        // Giả định: SV Chính Quy được xét học bổng nếu điểm rèn luyện từ 80 trở lên
        return (diemRenLuyen >= 80) ? 1000 : 0;
    }

    @Override
    public String toString() {
        return super.toString() + ", DiemRenLuyen=" + diemRenLuyen + ", LoaiSV=ChinhQuy";
    }
}
