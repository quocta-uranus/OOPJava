package OOPJava.Exercise3;

import java.util.ArrayList;
import java.util.List;

public class QLPTGT {
    private List<PhuongTien> danhSachPhuongTien;

    public QLPTGT() {
        danhSachPhuongTien = new ArrayList<>();
    }


    public void themPhuongTien(PhuongTien phuongTien) {
        danhSachPhuongTien.add(phuongTien);
    }


    public void xoaPhuongTien(String id) {
        danhSachPhuongTien.removeIf(phuongTien -> phuongTien.getId().equals(id));
    }

   
    public void timTheoHangSanXuat(String hangSanXuat) {
        danhSachPhuongTien.stream()
                .filter(phuongTien -> phuongTien.getHangSanXuat().equals(hangSanXuat))
                .forEach(System.out::println);
    }

 
    public void timTheoMauXe(String mauXe) {
        danhSachPhuongTien.stream()
                .filter(phuongTien -> phuongTien.getMauXe().equals(mauXe))
                .forEach(System.out::println);
    }
}
