package canhan;

import java.util.Date;
import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.text.ParseException;

public abstract class SINHVIEN {
    // Thuoc tinh
    protected Scanner scanner = new Scanner(System.in);
    protected String maSV;
    protected String hoTen;
    protected Date ngaySinh;
    protected String email;
    protected HOSO hoSo;
    protected String maLop;
    protected String tenLop;
    
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy");

    // Constructor
    public SINHVIEN(String maSV, String hoTen, Date ngaySinh, String email, HOSO hoSo, String maLop, String tenLop) {
        this.maSV = maSV;
        this.hoTen = hoTen;
        this.ngaySinh = ngaySinh;
        this.email = email;
        this.hoSo = hoSo;
        this.maLop = maLop;
        this.tenLop = tenLop;
    }

    public SINHVIEN() {
        this.hoSo = new HOSO();
    }

    // Getters va Setters
    public String getMaSV() {
        return maSV;
    }

    public String getHoTen() {
        return hoTen;
    }
    
    public String getEmail() {
        return email;
    }
    
    // Phuong thuc nhap thong tin
    public void nhap() {
        System.out.print("Nhap ma SV: ");
        this.maSV = scanner.nextLine();
        System.out.print("Nhap ho ten: ");
        this.hoTen = scanner.nextLine();
        System.out.print("Nhap ngay sinh (dd/MM/yyyy): ");
        try {
            this.ngaySinh = DATE_FORMAT.parse(scanner.nextLine());
        } catch (ParseException e) {
            System.out.println("Ngay sinh khong dung dinh dang. Dat mac dinh la ngay hien tai.");
            this.ngaySinh = new Date();
        }
        System.out.print("Nhap email: ");
        this.email = scanner.nextLine();
        System.out.print("Nhap ma lop: ");
        this.maLop = scanner.nextLine();
        System.out.print("Nhap ten lop: ");
        this.tenLop = scanner.nextLine();

        // Nhap thong tin Ho So
        System.out.println("--- Nhap thong tin Ho So ---");
        System.out.print("Dia chi thuong tru: ");
        this.hoSo.setDiaChiThuongTru(scanner.nextLine());
        System.out.print("Que quan: ");
        this.hoSo.setQueQuan(scanner.nextLine());
        System.out.print("So dien thoai: ");
        this.hoSo.setSdt(scanner.nextLine());
    }

    // Phuong thuc xuat thong tin
    public void xuat() {
        System.out.println("--- Thong tin Sinh Vien ---");
        System.out.println("Ma SV: " + maSV);
        System.out.println("Ho Ten: " + hoTen);
        System.out.println("Ngay Sinh: " + (ngaySinh != null ? DATE_FORMAT.format(ngaySinh) : "N/A"));
        System.out.println("Email: " + email);
        System.out.println("Ma Lop: " + maLop);
        System.out.println("Ten Lop: " + tenLop);
        System.out.println("Ho So: " + hoSo.toString());
    }
    
    // Phuong thuc tru tuong tinh hoc bong
    public abstract int tinhHB(); 

    @Override
    public String toString() {
        return "SINHVIEN{" +
               "maSV='" + maSV + '\'' +
               ", hoTen='" + hoTen + '\'' +
               ", ngaySinh=" + (ngaySinh != null ? DATE_FORMAT.format(ngaySinh) : "N/A") +
               ", email='" + email + '\'' +
               ", maLop='" + maLop + '\'' +
               ", tenLop='" + tenLop + '\'' +
               ", hoSo=[" + hoSo.toString() + "]" +
               '}';
    }

}
