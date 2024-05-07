package OOPJava.Exercise3;


 class PhuongTien {
    private String id;
    private String hangSanXuat;
    private int namSanXuat;
    private double giaBan;
    private String mauXe;


    PhuongTien(String id, String hangSanXuat, int namSanXuat, double giaBan, String mauXe) {
        this.id = id;
        this.hangSanXuat = hangSanXuat;
        this.namSanXuat = namSanXuat;
        this.giaBan = giaBan;
        this.mauXe = mauXe;
    }
    public String getId() {
        return id;
    }

    public String getHangSanXuat() {
        return hangSanXuat;
    }

    public String getMauXe() {
        return mauXe;
    }

    @Override
    public String toString() {
        return "ID: " + id +
                ", Hãng sản xuất: " + hangSanXuat +
                ", Năm sản xuất: " + namSanXuat +
                ", Giá bán: " + giaBan +
                ", Màu xe: " + mauXe;
    }
   
}
