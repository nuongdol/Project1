/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PolyApp.dao;

import PolyApp.helper.DatabaseHelper;
import PolyApp.model.NguoiDung;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import static javax.swing.UIManager.getString;

/**
 *
 * @author Admin-PC
 */
public class NguoiDungDao {
    public NguoiDung checkLogin(String tenDangNhap, String matKhau)throws Exception{
        //kiem tra va lay thong tin ten dang nhap mat khau 
        String sql = "select * from NguoiDung"
                + " where tendangnhap = ? and matKhau = ?";
        try(
            Connection con = DatabaseHelper.openConnection(); 
            PreparedStatement pstmt = con.prepareStatement(sql);
           ){
            pstmt.setString(1, tenDangNhap);
            pstmt.setString(2,matKhau);
            
            try(ResultSet rs = pstmt.executeQuery();){//thuc hien cau lenh truy van den du lieu nguoi dung 
                if(rs.next()){
                    NguoiDung nd = new NguoiDung();
                    nd.setTenDangNhap(tenDangNhap);
                    nd.setVaiTro(getString("vaitro"));
                    return nd;//dang nhap thanh cong thi tra ve gia tri nd
                }
            }
        }
        return null;//neu dang nhap khong thanh cong thi se tra ve gia tri null
    }
}
