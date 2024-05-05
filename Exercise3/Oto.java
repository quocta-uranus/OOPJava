package OOPJava.Exercise3;


class Oto extends PhuongTien {
    private int soChoNgoi;
    private String kieuDongCo;

 
    Oto(String id, String hangSanXuat, int namSanXuat, double giaBan, String mauXe, int soChoNgoi, String kieuDongCo) {
        super(id, hangSanXuat, namSanXuat, giaBan, mauXe);
        this.soChoNgoi = soChoNgoi;
        this.kieuDongCo = kieuDongCo;
    }
}
