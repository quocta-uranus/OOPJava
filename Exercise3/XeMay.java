package OOPJava.Exercise3;


class XeMay extends PhuongTien {
    private int congXuat;

   
   XeMay(String id, String hangSanXuat, int namSanXuat, double giaBan, String mauXe, int congXuat) {
        super(id, hangSanXuat, namSanXuat, giaBan, mauXe);
        this.congXuat = congXuat;
    }
    @Override
    public String toString() {
        return super.toString() +
                ", Công suất: " + congXuat;
    }
}
