package OOPJava.Exercise3;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        QLPTGT qlptgt = new QLPTGT();
        Scanner scanner = new Scanner(System.in);
        boolean isRunning = true;

        while (isRunning) {
            System.out.println("===== MENU =====");
            System.out.println("1. Thêm phương tiện");
            System.out.println("2. Xoá phương tiện theo ID");
            System.out.println("3. Tìm phương tiện theo hãng sản xuất");
            System.out.println("4. Tìm phương tiện theo màu");
            System.out.println("5. Thoát chương trình");
            System.out.print("Chọn chức năng (1-5): ");
            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    themPhuongTien(qlptgt, scanner);
                    break;
                case 2:
                    xoaPhuongTien(qlptgt, scanner);
                    break;
                case 3:
                    timTheoHangSanXuat(qlptgt, scanner);
                    break;
                case 4:
                    timTheoMauXe(qlptgt, scanner);
                    break;
                case 5:
                    isRunning = false;
                    break;
                default:
                    System.out.println("Chọn không hợp lệ. Vui lòng chọn lại.");
            }
        }
    }

    private static void themPhuongTien(QLPTGT qlptgt, Scanner scanner) {
        System.out.println("Chọn loại phương tiện (1. Ô tô, 2. Xe máy, 3. Xe tải): ");
        int loai = scanner.nextInt();
        scanner.nextLine(); // consume newline

        System.out.print("Nhập ID: ");
        String id = scanner.nextLine();
        System.out.print("Nhập hãng sản xuất: ");
        String hangSanXuat = scanner.nextLine();
        System.out.print("Nhập năm sản xuất: ");
        int namSanXuat = scanner.nextInt();
        System.out.print("Nhập giá bán: ");
        double giaBan = scanner.nextDouble();
        scanner.nextLine(); // consume newline
        System.out.print("Nhập màu xe: ");
        String mauXe = scanner.nextLine();

        switch (loai) {
            case 1:
                System.out.print("Nhập số chỗ ngồi: ");
                int soChoNgoi = scanner.nextInt();
                scanner.nextLine(); // consume newline
                System.out.print("Nhập kiểu động cơ: ");
                String kieuDongCo = scanner.nextLine();
                qlptgt.themPhuongTien(new Oto(id, hangSanXuat, namSanXuat, giaBan, mauXe, soChoNgoi, kieuDongCo));
                break;
            case 2:
                System.out.print("Nhập công xuất: ");
                int congXuat = scanner.nextInt();
                qlptgt.themPhuongTien(new XeMay(id, hangSanXuat, namSanXuat, giaBan, mauXe, congXuat));
                break;
            case 3:
                System.out.print("Nhập trọng tải: ");
                double trongTai = scanner.nextDouble();
                qlptgt.themPhuongTien(new XeTai(id, hangSanXuat, namSanXuat, giaBan, mauXe, trongTai));
                break;
            default:
                System.out.println("Lựa chọn không hợp lệ.");
        }
    }

    private static void xoaPhuongTien(QLPTGT qlptgt, Scanner scanner) {
        System.out.print("Nhập ID phương tiện cần xoá: ");
        String id = scanner.next();
        qlptgt.xoaPhuongTien(id);
    }

    private static void timTheoHangSanXuat(QLPTGT qlptgt, Scanner scanner) {
        System.out.print("Nhập hãng sản xuất cần tìm: ");
        String hangSanXuat = scanner.next();
        qlptgt.timTheoHangSanXuat(hangSanXuat);
    }

    private static void timTheoMauXe(QLPTGT qlptgt, Scanner scanner) {
        System.out.print("Nhập màu xe cần tìm: ");
        String mauXe = scanner.next();
        qlptgt.timTheoMauXe(mauXe);
    }
}
