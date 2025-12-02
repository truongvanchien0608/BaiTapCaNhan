package canhan;

public class HOSO {
    // Thuoc tinh
    private String diaChiThuongTru;
    private String queQuan;
    private String sdt;

    // Constructor
    public HOSO(String diaChiThuongTru, String queQuan, String sdt) {
        this.diaChiThuongTru = diaChiThuongTru;
        this.queQuan = queQuan;
        this.sdt = sdt;
    }

    public HOSO() {
    }

    // Getters va Setters
    public String getDiaChiThuongTru() {
        return diaChiThuongTru;
    }

    public void setDiaChiThuongTru(String diaChiThuongTru) {
        this.diaChiThuongTru = diaChiThuongTru;
    }

    public String getQueQuan() {
        return queQuan;
    }

    public void setQueQuan(String queQuan) {
        this.queQuan = queQuan;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    // Phuong thuc
    public void inHoSo() {
        System.out.println("Dia chi thuong tru: " + diaChiThuongTru);
        System.out.println("Que quan: " + queQuan);
        System.out.println("So dien thoai: " + sdt);
    }
    
    @Override
    public String toString() {
        return "Dia chi thuong tru: " + diaChiThuongTru +
               ", Que quan: " + queQuan +
               ", SDT: " + sdt;
    }

}
