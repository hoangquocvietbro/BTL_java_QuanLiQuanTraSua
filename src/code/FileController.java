/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package code;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import static code.LoginForm.status;
/**
 *
 * @author IT Supporter
 */
public class FileController {
    
    //ghi thong tin phan hoi vao file
    public static void UpdateHoaDon(List<ThongTinHoaDon> thongTins){
        FileWriter fw= null;
        BufferedWriter bw= null;
        try {
            fw = new FileWriter("thongtindatphong.txt", false);
            bw= new BufferedWriter(fw);
            for(ThongTinHoaDon tt: thongTins){
                bw.write(tt.getMaHD()+";"+tt.getTenKH()+";"+tt.getSdt()+";"+tt.getdouong()+";"+tt.getdoan()+";"+tt.getSoTienDuKien()+"\n");
            }
        } catch (IOException ex) {
            System.out.println("Loi ghi");
        } finally {
            try {
                bw.close();
                fw.close();
            } catch (IOException ex) {
                System.out.println("Loi dong file");
            }
        }
    }
    
    public static void UpdateNhanVien(List<NguoiDung> thongTins){
        FileWriter fw= null;
        BufferedWriter bw= null;
        try {
            fw = new FileWriter("Nhanvien.txt", false);
            bw= new BufferedWriter(fw);
            for(NguoiDung tt: thongTins){
                bw.write(tt.getMaNhanVien()+";"+tt.getTenNhanVien()+";"+tt.getSdt()+";"+tt.getChucVu()+";"+tt.getSoNgayLuong()+";"+tt.getLuong()+"\n");
            }
        } catch (IOException ex) {
            System.out.println("Loi ghi");
        } finally {
            try {
                bw.close();
                fw.close();
            } catch (IOException ex) {
                System.out.println("Loi dong file");
            }
        }
    }
    
    public static void UpdateSanPham(List<SanPham> thongTins){
        FileWriter fw= null;
        BufferedWriter bw= null;
        try {
            fw = new FileWriter("SanPham.txt", false);
            bw= new BufferedWriter(fw);
            for(SanPham tt: thongTins){
                bw.write(tt.getMaSP()+";"+tt.getTenSP()+";"+tt.getGiaTienM()+";"+tt.getGiaTienL()+";"+tt.getDonvi()+";"+tt.getMota()+"\n");
            }
        } catch (IOException ex) {
            System.out.println("Loi ghi");
        } finally {
            try {
                bw.close();
                fw.close();
            } catch (IOException ex) {
                System.out.println("Loi dong file");
            }
        }
    }
    
    public static void UpdateTaiKhoan(List<TaiKhoan> thongTins){
        DeleteTaiKhoan();
        FileWriter fw= null;
        BufferedWriter bw= null;
        try {
            fw = new FileWriter("TaiKhoan.txt", true);
            bw= new BufferedWriter(fw);
            for(TaiKhoan tt: thongTins){
                bw.write(tt.getHoten()+";"+tt.getUsername()+";"+tt.getPassword()+"\n");
            }
        } catch (IOException ex) {
            System.out.println("Loi ghi");
        } finally {
            try {
                bw.close();
                fw.close();
            } catch (IOException ex) {
                System.out.println("Loi dong file");
            }
        }
    }
    
    public static void UpdateBan(List<Ban> thongTins){
        FileWriter fw= null;
        BufferedWriter bw= null;
        try {
            fw = new FileWriter("DatBan.txt", false);
            bw= new BufferedWriter(fw);
            for(Ban tt: thongTins){
                bw.write(tt.getTenBan()+";"+tt.getTinhTrang()+";"+tt.getSoKhach()+";"+tt.getLoaiDoUong()+";"+tt.getLoaiDoAn()+";"+tt.getTongTien()+"\n");
            }
        } catch (IOException ex) {
            System.out.println("Loi ghi");
        } finally {
            try {
                bw.close();
                fw.close();
            } catch (IOException ex) {
                System.out.println("Loi dong file");
            }
        }
    }
    
    public static List<TaiKhoan> layTatCaNguoiDung(){
        List<TaiKhoan> TaiKhoan= new ArrayList<>();
        FileReader fr= null;
        BufferedReader br= null;
        try {
            fr = new FileReader("taikhoan.txt");
            br= new BufferedReader(fr);
            String line="";
            while((line=br.readLine())!=null){
                String str[]= line.split(";");
                TaiKhoan nd= new TaiKhoan(str[0], str[1], str[2]);
                TaiKhoan.add(nd);
            }
        } catch (IOException ex) {
            System.out.println("Loi doc ");
        } finally {
            try {
                br.close();
                fr.close();
            } catch (IOException ex) {
                System.out.println("Loi dong file");
            }
        }
        return TaiKhoan;
    }
    
    public static List<ThongTinHoaDon> layTatCaThongTinDatPhong(){
        List<ThongTinHoaDon> thongTinDatPhongs= new ArrayList<>();
        FileReader fr= null;
        BufferedReader br= null;
        try {
            fr = new FileReader("thongtindatphong.txt");
            br= new BufferedReader(fr);
            String line="";
            while((line=br.readLine())!=null){
                String str[]= line.split(";");
                ThongTinHoaDon tt= new ThongTinHoaDon(str[0], str[1], str[2], str[3], str[4], str[5]);
                thongTinDatPhongs.add(tt);
            }
        } catch (IOException ex) {
            System.out.println("Loi doc");
        } finally {
            try {
                br.close();
                fr.close();
            } catch (IOException ex) {
                System.out.println("Loi dong file");
            }
        }
        return thongTinDatPhongs;
    }
    
    public static List<NguoiDung> LayThonTinNhanVien(){
        List<NguoiDung> NhanVien= new ArrayList<>();
        FileReader fr= null;
        BufferedReader br= null;
        try {
            fr = new FileReader("Nhanvien.txt");
            br= new BufferedReader(fr);
            String line="";
            while((line=br.readLine())!=null){
                String str[]= line.split(";");
                NguoiDung tt= new NguoiDung(str[0], str[1], str[2], str[3], str[4], str[5]);
                NhanVien.add(tt);
            }
        } catch (IOException ex) {
            System.out.println("Loi doc");
        } finally {
            try {
                br.close();
                fr.close();
            } catch (IOException ex) {
                System.out.println("Loi dong file");
            }
        }
        return NhanVien;
    }

    public static void AddNew(String result, String directory){
        FileWriter fw= null;
        BufferedWriter bw= null;
            try {
                fw = new FileWriter(directory, true);
                bw= new BufferedWriter(fw);
                bw.write(result);
            } catch (IOException ex) {
                System.out.println("Loi ghi");
            } finally {
                try {
                    bw.close();
                    fw.close();
                } catch (IOException ex) {
                    System.out.println("Loi dong file");
                }
            }
    }
        
    public static void Delete(DefaultTableModel model, String directory, String ID){
        FileWriter fw= null;
        BufferedWriter bw= null;
        int row = model.getRowCount();
        int col = model.getColumnCount();
        for(int i=0; i<row; i++){
            String result = "";
            for(int j=0; j<col; j++){
                // neu ma dang xet trung voi ma id thi bo qua lan lap hien tai, nguoc lai thi tiep tuc ghi file
                if(model.getValueAt(i, 0).equals(ID))
                    break;
                result += model.getValueAt(i, j);
                if(i!=row-1)
                    result += ";";
                try {
                    fw = new FileWriter(directory, true);
                    bw= new BufferedWriter(fw);
                    bw.write(result);
                } catch (IOException ex) {
                    System.out.println("Loi ghi");
                } finally {
                    try {
                        bw.close();
                        fw.close();
                    } catch (IOException ex) {
                        System.out.println("Loi dong file");
                    }
                }
            }
        }
    }

    public static void DeleteHoaDon(){
        FileWriter f= null;
        BufferedWriter b= null;
        try {
            f = new FileWriter("thongtindatphong.txt", false);
            b= new BufferedWriter(f);
          
        } catch (IOException ex) {
            System.out.println("Loi ghi");
        } finally {
            try {
                b.close();
                f.close();
            } catch (IOException ex) {
                System.out.println("Loi dong file");
            }
        }
    }
    
    public static void DeleteNhanVien(){
        FileWriter f= null;
        BufferedWriter b= null;
        try {
            f = new FileWriter("Nhanvien.txt", false);
            b= new BufferedWriter(f);
          
        } catch (IOException ex) {
            System.out.println("Loi ghi");
        } finally {
            try {
                b.close();
                f.close();
            } catch (IOException ex) {
                System.out.println("Loi dong file");
            }
        }
    }
    
    public static void DeleteSanPham(){
        FileWriter f= null;
        BufferedWriter b= null;
        try {
            f = new FileWriter("SanPham.txt", false);
            b= new BufferedWriter(f);
          
        } catch (IOException ex) {
            System.out.println("Loi ghi");
        } finally {
            try {
                b.close();
                f.close();
            } catch (IOException ex) {
                System.out.println("Loi dong file");
            }
        }
    }
    
    public static void DeleteTaiKhoan(){
        FileWriter f= null;
        BufferedWriter b= null;
        try {
            f = new FileWriter("TaiKhoan.txt", false);
            b= new BufferedWriter(f);
          
        } catch (IOException ex) {
            System.out.println("Loi ghi");
        } finally {
            try {
                b.close();
                f.close();
            } catch (IOException ex) {
                System.out.println("Loi dong file");
            }
        }
    }
    
    public static void DeleteBan(){
        FileWriter f= null;
        BufferedWriter b= null;
        try {
            f = new FileWriter("DatBan.txt", false);
            b= new BufferedWriter(f);
          
        } catch (IOException ex) {
            System.out.println("Loi ghi");
        } finally {
            try {
                b.close();
                f.close();
            } catch (IOException ex) {
                System.out.println("Loi dong file");
            }
        }
    }
    
    public static List<SanPham> LayThongTinSanPham(){
        List<SanPham> sp= new ArrayList<>();
        FileReader fr= null;
        BufferedReader br= null;
        try {
            fr = new FileReader("SanPham.txt");
            br= new BufferedReader(fr);
            String line="";
            while((line=br.readLine())!=null){
                String str[]= line.split(";");
                if (str.length==6){
                    SanPham tt= new SanPham(str[0], str[1], str[2], str[3], str[4], str[5]);
                    sp.add(tt);
                }
                
            }
        } catch (IOException ex) {
            System.out.println("Loi doc");
        } finally {
            try {
                br.close();
                fr.close();
            } catch (IOException ex) {
                System.out.println("Loi dong file");
            }
        }
        return sp;
    }
    
    public static List<TaiKhoan> LayThongTinTaiKhoan(){
        List<TaiKhoan> tk= new ArrayList<>();
        FileReader fr= null;
        BufferedReader br= null;
        try {
            fr = new FileReader("TaiKhoan.txt");
            br= new BufferedReader(fr);
            String line="";
            while((line=br.readLine())!=null){
                String str[]= line.split(";");
                TaiKhoan tt= new TaiKhoan(str[0], str[1], str[2]);
                tk.add(tt);
            }
        } catch (IOException ex) {
            System.out.println("Loi doc");
        } finally {
            try {
                br.close();
                fr.close();
            } catch (IOException ex) {
                System.out.println("Loi dong file");
            }
        }
        return tk;
    }

    public static List<Ban> LayThongTinBan(){
        List<Ban> ban= new ArrayList<>();
        FileReader fr= null;
        BufferedReader br= null;
        try {
            fr = new FileReader("DatBan.txt");
            br= new BufferedReader(fr);
            String line="";
            while((line=br.readLine())!=null){
                String str[]= line.split(";");
                Ban tt= new Ban(str[0], str[1], str[2], str[3], str[4], str[5]);
                ban.add(tt);
            }
        } catch (IOException ex) {
            System.out.println("Loi doc");
        } finally {
            try {
                br.close();
                fr.close();
            } catch (IOException ex) {
                System.out.println("Loi dong file");
            }
        }
        return ban;
    }
    
    public static boolean CheckStatus(){
        return status;
    }
}
