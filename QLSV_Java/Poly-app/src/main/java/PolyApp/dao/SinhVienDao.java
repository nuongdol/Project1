/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PolyApp.dao;
//phương thức thực hiện tất cả các chỉnh sửa update những chức năng 
//thêm xóa sửa tất cả các phương thức trong lớp sinh viên 

import PolyApp.helper.DatabaseHelper;
import PolyApp.model.NguoiDung;
import PolyApp.model.SinhVien;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.sql.rowset.serial.SerialBlob;
import static javax.swing.UIManager.getString;

/**
 *
 * @author Admin-PC
 */
public class SinhVienDao {
     public boolean insert(SinhVien sv)
             throws Exception{
        //kiem tra va lay thong tin ten dang nhap mat khau 
        String sql = "INSERT INTO   dbo .  SinhVien   (MaSinhVien,  HoTen  ,  Email  ,  SoDT  ,  GioiTinh  ,  DiaChi ,  Hinh )" + "values(?,?,?,?,?,?,?)";
        try(
            Connection con = DatabaseHelper.openConnection(); 
            PreparedStatement pstmt = con.prepareStatement(sql);
           ){
            pstmt.setString(1, sv.getMaSinhVien());
            pstmt.setString(2,sv.getHoTen());
            pstmt.setString(3,sv.getEmail());
            pstmt.setString(4,sv.getSoDT());
            pstmt.setInt(5,sv.getGioiTinh());
            pstmt.setString(6,sv.getDiaChi());
            if(sv.getHinh() != null){
                Blob hinh = new SerialBlob(sv.getHinh());
                pstmt.setBlob(7, hinh);
            }else{
                Blob hinh = null;
                pstmt.setBlob(7, hinh);
            }
            return pstmt.executeUpdate()>0;
        }   
            /*try(ResultSet rs = pstmt.executeQuery();){//thuc hien cau lenh truy van den du lieu nguoi dung 
                if(rs.next()){
                    NguoiDung nd = new NguoiDung();
                    nd.setTenDangNhap(tenDangNhap);
                    nd.setVaiTro(getString("vaitro"));
                    return nd;//dang nhap thanh cong thi tra ve gia tri nd
                }
            }
        }*/
       // return null;//neu dang nhap khong thanh cong thi se tra ve gia tri null
    }
     public boolean update(SinhVien sv) 
             throws Exception{
          String sql = "update dbo.SinhVien SET HoTen= ?,Email= ?,SoDT= ?,GioiTinh= ?,DiaChi = ? ,Hinh = ?" + " where MaSinhVien = ?";//chú ý là phải có khoảng cách giữa where và dấu "
           
        try(
            Connection con = DatabaseHelper.openConnection(); 
            PreparedStatement pstmt = con.prepareStatement(sql);
           ){
            pstmt.setString(7, sv.getMaSinhVien());//điều kiện để cập nhật 
            pstmt.setString(1,sv.getHoTen());
            pstmt.setString(2,sv.getEmail());
            pstmt.setString(3,sv.getSoDT());
            pstmt.setInt(4,sv.getGioiTinh());
            pstmt.setString(5,sv.getDiaChi());
            if(sv.getHinh() != null){
                Blob hinh = new SerialBlob(sv.getHinh());
                pstmt.setBlob(6, hinh);
            }else{
                Blob hinh = null;
                pstmt.setBlob(6, hinh);
            }
            return pstmt.executeUpdate()>0;
    }
  }
     public boolean delete(String maSinhVien ) 
             throws Exception{
          String sql = "delete from dbo.SinhVien"+ " where MaSinhVien = ?";//chú ý là phải có khoảng cách giữa where và dấu "
           
        try(
            Connection con = DatabaseHelper.openConnection(); 
            PreparedStatement pstmt = con.prepareStatement(sql);
           ){
            pstmt.setString(1, maSinhVien);//điều kiện để cập nhật 
            
            return pstmt.executeUpdate()>0;
    }
  }
     //hàm tìm id sinh viên để có thể tìm kiềm một cách dễ dàng hơn 
     public SinhVien findById(String maSinhVien ) 
             throws Exception{
          String sql = "select *from SinhVien where MaSinhVien = ?";//chú ý là phải có khoảng cách giữa where và dấu "
           
        try(
            Connection con = DatabaseHelper.openConnection(); 
            PreparedStatement pstmt = con.prepareStatement(sql);
           ){
            pstmt.setString(1, maSinhVien);//điều kiện để cập nhật 
            try(ResultSet rs = pstmt.executeQuery();){
                if(rs.next()){
                    SinhVien sv = new SinhVien();
                    sv.setMaSinhVien(rs.getString("masinhVien"));
                    sv.setHoTen(rs.getString("Hoten"));
                    sv.setEmail(rs.getString("email"));
                    sv.setSoDT(rs.getString("soDT"));
                    sv.setDiaChi(rs.getString("diachi"));
                    sv.setGioiTinh(rs.getInt("gioiTinh"));
                    Blob blob = rs.getBlob("hinh");
                    if(blob != null){
                        sv.setHinh(blob.getBytes(0, (int) blob.length()));//ép kiểu cho chiều dài cảu length
                        }
                    return sv;    
                }   
            }
            return null;
        }
    }
     
     //trả về tất cả các nội dung danh sách của sinh viên 
     public List <SinhVien> findAll() 
             throws Exception{
          String sql = "select *from SinhVien";//chú ý là phải có khoảng cách giữa where và dấu "
           
        try(
            Connection con = DatabaseHelper.openConnection(); 
            PreparedStatement pstmt = con.prepareStatement(sql);
           ){ 
            try(ResultSet rs = pstmt.executeQuery();){
                List<SinhVien> list = new ArrayList<>();
                while (rs.next()){
                    SinhVien sv = new SinhVien();
                    sv.setMaSinhVien(rs.getString("masinhVien"));
                    sv.setHoTen(rs.getString("Hoten"));
                    sv.setEmail(rs.getString("email"));
                    sv.setSoDT(rs.getString("soDT"));
                    sv.setDiaChi(rs.getString("diachi"));
                    sv.setGioiTinh(rs.getInt("gioiTinh"));
                    Blob blob = rs.getBlob("hinh");
                    if(blob != null){
                    sv.setHinh(blob.getBytes(0, (int) blob.length()));//ép kiểu cho chiều dài cảu length
                    }
                   list.add(sv)  ;
                }   
                 return list;
            }
        }
    }
}