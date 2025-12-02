package canhan;

import java.util.Date;

public class SinhVienTaiChuc extends SINHVIEN {
    // Thuoc tinh
    private String noiCongTac;

    // Constructor
    public SinhVienTaiChuc(String maSV, String hoTen, Date ngaySinh, String email, HOSO hoSo, String maLop, String tenLop, String noiCongTac) {
        super(maSV, hoTen, ngaySinh, email, hoSo, maLop, tenLop);
        this.noiCongTac = noiCongTac;
    }

    public SinhVienTaiChuc() {
        super();
    }

    // Phuong thuc nhap (ghi de)
    @Override
    public void nhap() {
        super.nhap();
        System.out.print("Nhap noi cong tac: ");
        this.noiCongTac = scanner.nextLine();
    }

    // Phuong thuc xuat (ghi de)
    @Override
    public void xuat() {
        super.xuat();
        System.out.println("Loai SV: Tai Chuc");
        System.out.println("Noi cong tac: " + noiCongTac);
    }
    
    // Phuong thuc hien thi thong tin cong tac
    public void thongTinCongTac() {
        System.out.println("Thong tin cong tac cua SV Tai Chuc: " + noiCongTac);
    }

    // Phuong thuc tinh hoc bong (ghi de)
    @Override
    public int tinhHB() {
        // Giả định: SV Tại Chức không được xét học bổng
        return 0; 
    }
    
    @Override
    public String toString() {
        return super.toString() + ", NoiCongTac='" + noiCongTac + '\'' + ", LoaiSV=TaiChuc";
    }
}