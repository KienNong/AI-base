public class Test {

  public static void main(String[] args) {
    System.out.println("Dem Tien");
    DemTien dt = new DemTien();
    dt.nhapDSMenhGia();
    dt.xuatDSMenhGia();
    System.out.println("Tong so to: " + dt.demTien(524));
  }
}
