package OOPJava.Exercise3;


class XeTai extends PhuongTien {
    
    private double trongTai;


   XeTai(String id, String hangSanXuat, int namSanXuat, double giaBan, String mauXe, double trongTai) {
        super(id, hangSanXuat, namSanXuat, giaBan, mauXe);
        this.trongTai = trongTai;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", Trọng tải: " + trongTai;
    }
}
