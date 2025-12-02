package canhan;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        QuanLyLop quanLy = new QuanLyLop("KTPM2025");
        int luaChon = -1;

        // Du lieu mau ban dau
        HOSO hs1 = new HOSO("123 CMT8", "HCM", "0901234567");
        SinhVienChinhQuy sv1 = new SinhVienChinhQuy("CQ001", "Nguyen Van A", null, "nva@dtu.edu.vn", hs1, "K25", "KTPM", 85.5);
        quanLy.themSinhVien(sv1);

        HOSO hs2 = new HOSO("456 Pasteur", "Ha Noi", "0909876543");
        SinhVienTaiChuc sv2 = new SinhVienTaiChuc("TC002", "Tran Thi B", null, "ttb@fpt.vn", hs2, "K20", "CNTT", "FPT Software");
        quanLy.themSinhVien(sv2);
        
        HOSO hs3 = new HOSO("789 Ly Thuong Kiet", "Da Nang", "0911223344");
        SinhVienChinhQuy sv3 = new SinhVienChinhQuy("CQ003", "Le Thu Hang", null, "lth@dtu.edu.vn", hs3, "K25", "KTPM", 95.0);
        quanLy.themSinhVien(sv3);

        do {
            // Dòng này đã được sửa: Thay quanLy.tenLop bằng quanLy.getTenLop()
            System.out.println("\n===== HE THONG QUAN LY SINH VIEN LOP " + quanLy.getTenLop().toUpperCase() + " ====="); 
            System.out.println("1. Them sinh vien moi");
            System.out.println("2. Xoa sinh vien theo ma");
            System.out.println("3. Tim kiem sinh vien");
            System.out.println("4. Sap xep danh sach theo ho ten");
            System.out.println("5. Xuat danh sach sinh vien");
            System.out.println("6. Xem DS sinh vien chinh quy co hoc bong");
            System.out.println("0. Thoat");
            System.out.print("Nhap lua chon cua ban: ");
            
            try {
                luaChon = scanner.nextInt();
                scanner.nextLine(); // Doc bo dong moi
            } catch (Exception e) {
                System.out.println("Loi nhap lieu. Vui long nhap so.");
                scanner.nextLine(); // Xoa dau vao khong hop le
                luaChon = -1;
                continue;
            }

            switch (luaChon) {
                case 1:
                    System.out.println("Chon loai sinh vien (1: Chinh Quy, 2: Tai Chuc): ");
                    int loai;
                    try {
                        loai = scanner.nextInt();
                        scanner.nextLine();
                    } catch (Exception e) {
                         System.out.println("Loi nhap lieu. Vui long nhap 1 hoac 2.");
                         scanner.nextLine();
                         break;
                    }
                    
                    SINHVIEN svMoi;
                    if (loai == 1) {
                        svMoi = new SinhVienChinhQuy();
                    } else if (loai == 2) {
                        svMoi = new SinhVienTaiChuc();
                    } else {
                        System.out.println("Loai khong hop le.");
                        break;
                    }
                    svMoi.nhap();
                    quanLy.themSinhVien(svMoi);
                    break;
                case 2:
                    System.out.print("Nhap ma SV can xoa: ");
                    String maXoa = scanner.nextLine();
                    if (quanLy.xoaSinhVien(maXoa)) {
                        System.out.println("Da xoa SV co ma " + maXoa);
                    } else {
                        System.out.println("Khong tim thay SV co ma " + maXoa);
                    }
                    break;
                case 3:
                    System.out.print("Nhap tu khoa tim kiem: ");
                    String keyword = scanner.nextLine();
                    List<SINHVIEN> ketQua = quanLy.timKiem(keyword);
                    if (ketQua.isEmpty()) {
                        System.out.println("Khong tim thay sinh vien nao khop voi tu khoa.");
                    } else {
                        System.out.println("\n--- KET QUA TIM KIEM ---");
                        for (SINHVIEN sv : ketQua) {
                            sv.xuat();
                            System.out.println("-------------------------");
                        }
                    }
                    break;
                case 4:
                    quanLy.sapXepTheoHoTen();
                    quanLy.xuatDanhSach();
                    break;
                case 5:
                    quanLy.xuatDanhSach();
                    break;
                case 6:
                    List<SinhVienChinhQuy> svCoHB = quanLy.locSinhVienChinhQuyQuyetHB();
                    if (svCoHB.isEmpty()) {
                        System.out.println("Khong co SV Chinh Quy nao nhan hoc bong.");
                    } else {
                        System.out.println("\n--- DANH SACH SINH VIEN CHINH QUY CO HOC BONG ---");
                        for (SinhVienChinhQuy sv : svCoHB) {
                            sv.xuat();
                            System.out.println("Hoc bong: " + sv.tinhHB());
                            System.out.println("-------------------------------------");
                        }
                    }
                    break;
                case 0:
                    System.out.println("Da thoat chuong trinh.");
                    break;
                default:
                    System.out.println("Lua chon khong hop le.");
            }
        } while (luaChon != 0);

        scanner.close();
    }
}
