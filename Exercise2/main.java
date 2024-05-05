package OOPJava.Exercise2;

import java.util.Scanner;


class SoPhuc {
   
    private double phanThuc;
    private double phanAo;


     SoPhuc(double phanThuc, double phanAo) {
        this.phanThuc = phanThuc;
        this.phanAo = phanAo;
    }

   
    public static SoPhuc nhapSoPhuc() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap phan thuc: ");
        double phanThuc = scanner.nextDouble();
        System.out.print("Nhap phan ao: ");
        double phanAo = scanner.nextDouble();
        return new SoPhuc(phanThuc, phanAo);
    }

   
    void hienThi() {
        System.out.println(phanThuc + " + " + phanAo + "i");
    }

    SoPhuc cong(SoPhuc soPhucKhac) {
        double phanThucMoi = this.phanThuc + soPhucKhac.phanThuc;
        double phanAoMoi = this.phanAo + soPhucKhac.phanAo;
        return new SoPhuc(phanThucMoi, phanAoMoi);
    }


     SoPhuc nhan(SoPhuc soPhucKhac) {
        double phanThucMoi = this.phanThuc * soPhucKhac.phanThuc - this.phanAo * soPhucKhac.phanAo;
        double phanAoMoi = this.phanThuc * soPhucKhac.phanAo + this.phanAo * soPhucKhac.phanThuc;
        return new SoPhuc(phanThucMoi, phanAoMoi);
    }
}


public class main {
    public static void main (String[] args) {
      
        System.out.println("Nhap so phuc thu nhat:");
        SoPhuc soPhuc1 = SoPhuc.nhapSoPhuc();
        System.out.println("So phuc thu nhat la:");
        soPhuc1.hienThi();

      
        System.out.println("Nhap so phuc thu hai:");
        SoPhuc soPhuc2 = SoPhuc.nhapSoPhuc();
        System.out.println("So phuc thu hai :");
        soPhuc2.hienThi();

     
        SoPhuc tong = soPhuc1.cong(soPhuc2);
        System.out.println("Tong cua hai so phuc :");
        tong.hienThi();

        SoPhuc tich = soPhuc1.nhan(soPhuc2);
        System.out.println("Tich cua hai so phuc:");
        tich.hienThi();
    }
}

