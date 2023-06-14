import java.util.Scanner;
import java.util.ArrayList;
import java.util.Comparator;

public class DemTien {
  ArrayList<Integer> menhGiaList;
  int soTien;

  DemTien() {
    this.soTien = 0;
    this.menhGiaList = new ArrayList<Integer>();
  }

  DemTien(ArrayList<Integer> menhGiaList, int soTien) {
    this.menhGiaList = menhGiaList;
    this.soTien = soTien;
  }

  public void nhapDSMenhGia() {
    try (Scanner sc = new Scanner(System.in)) {
      int soMenhGia = 0;

      try {
        System.out.println("Nhap so menh gia: ");
        soMenhGia = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < soMenhGia; i++) {
          System.out.println("Nhap menh gia: ");
          int menhGia = Integer.parseInt(sc.nextLine());
          this.menhGiaList.add(menhGia);
        }
      } catch (NumberFormatException e) {
        System.err.println("Nhap sai kieu du lieu!!!");
        return;
      }
    }
  }

  public void xuatDSMenhGia() {
    if (this.menhGiaList != null) {
      System.out.print("DS menh gia la: ");
      for (Integer menhGia : menhGiaList) {
        System.out.print(" " + menhGia);
      }
      System.out.println();
    } else {
      System.out.println("DS trong (null)");
    }
  }

  public int demTien(int soTien) {
    this.menhGiaList.sort(Comparator.reverseOrder());
    int cnt = 0;
    for (Integer menhGia : menhGiaList) {
      int soTo = soTien / menhGia;
      cnt += soTo;
      if (soTo != 0) {
        System.out.println("Menh gia [" + menhGia + "] co : " + soTo + " to tien");
      }
      soTien %= menhGia;
    }
    return cnt;
  }

  // 525
  // 500: 1
  // 200: 0
  // 100: 0
  // 50: 0
  // 20: 1
  // 10: 0
  // 5: 1
  // 2: 0
  // 1: 0

  // 500 200 100 50 20 10 5 2 12

}