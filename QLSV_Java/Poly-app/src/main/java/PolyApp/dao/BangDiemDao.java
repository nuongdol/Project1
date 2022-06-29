/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PolyApp.dao;

import PolyApp.helper.DatabaseHelper;
import PolyApp.model.BangDiem;
import PolyApp.model.SinhVien;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.sql.rowset.serial.SerialBlob;

/**
 *
 * @author Admin-PC
 */
public class BangDiemDao {
    //các phương thức trong class này sẽ cho thực hiện các nút thêm xóa sửa cập nhât đối với 
    //bảng điểm 
    //nội dung của phương thức chèn bảng điểm vào trong csdl
     public boolean insert(BangDiem bd)
             throws Exception{
        //kiem tra va lay thong tin ten dang nhap mat khau 
        String sql = " INSERT INTO   dbo  .  BangDiem  ( MaSinhVien  ,  TiengAnh  ,  TinHoc ,  GDTC ) " + "values(?,?,?,?)";
       //riêng trường mã không cần chèn dữ liệu vì nó là trường tự tăng trong csdl
       //nên trong câu lệnh insert into không thiết lập giá trị cho trường này 
        try(
            Connection con = DatabaseHelper.openConnection(); 
            PreparedStatement pstmt = con.prepareStatement(sql);
           ){
            //thiết lập các trường trong bảng dữ liệu
           //lỗi xung đột trong sql server là khi một khóa phụ tham chiếu đến một khóa chính trong bảng nhé ma trong bảng của khóa chính 
           //không có giá trị đó thì tức nhiên sẽ làm cho khóa phụ không thể hiện được dữ liệu của khóa chính nên ta bắt buộc phải nhập một dữ liệu 
           //mà khóa chính đã có rồi lúc đó khóa phụ mới thực hiên được 
            pstmt.setString(1, bd.getMaSinhVien());
            pstmt.setFloat(2, bd.getTiengAnh());
            pstmt.setFloat(3, bd.getTinHoc());
            pstmt.setFloat(4, bd.getGDTC());
            
            return pstmt.executeUpdate()>0;
        }
    }   
     public boolean update(BangDiem bd)
             throws Exception{
        //kiem tra va lay thong tin ten dang nhap mat khau 
        String sql = "update  dbo . BangDiem SET TiengAnh= ?, TinHoc = ?,GDTC= ?" + " where MaSinhVien = ?";
        //update điều kiện là mã sinh viên 
       //riêng trường mã không cần chèn dữ liệu vì nó là trường tự tăng trong csdl
       //nên trong câu lệnh insert into không thiết lập giá trị cho trường này 
        try(
            Connection con = DatabaseHelper.openConnection(); 
            PreparedStatement pstmt = con.prepareStatement(sql);
           ){
            //thiết lập các trường trong bảng dữ liệu
           //lỗi xung đột trong sql server là khi một khóa phụ tham chiếu đến một khóa chính trong bảng nhé ma trong bảng của khóa chính 
           //không có giá trị đó thì tức nhiên sẽ làm cho khóa phụ không thể hiện được dữ liệu của khóa chính nên ta bắt buộc phải nhập một dữ liệu 
           //mà khóa chính đã có rồi lúc đó khóa phụ mới thực hiên được 
            pstmt.setString(4, bd.getMaSinhVien());
            pstmt.setFloat(1, bd.getTiengAnh());
            pstmt.setFloat(2, bd.getTinHoc());
            pstmt.setFloat(3, bd.getGDTC());
            
            return pstmt.executeUpdate()>0;
        }
    }   
     public boolean deleteByMaSinhVien(String maSinhVien)
             throws Exception{
        //kiem tra va lay thong tin ten dang nhap mat khau 
        String sql = "delete dbo . BangDiem "+ " where MaSinhVien = ?";
        //update điều kiện là mã sinh viên 
       //riêng trường mã không cần chèn dữ liệu vì nó là trường tự tăng trong csdl
       //nên trong câu lệnh insert into không thiết lập giá trị cho trường này 
        try(
            Connection con = DatabaseHelper.openConnection(); 
            PreparedStatement pstmt = con.prepareStatement(sql);
           ){
            //thiết lập các trường trong bảng dữ liệu
           //lỗi xung đột trong sql server là khi một khóa phụ tham chiếu đến một khóa chính trong bảng nhé ma trong bảng của khóa chính 
           //không có giá trị đó thì tức nhiên sẽ làm cho khóa phụ không thể hiện được dữ liệu của khóa chính nên ta bắt buộc phải nhập một dữ liệu 
           //mà khóa chính đã có rồi lúc đó khóa phụ mới thực hiên được 
            pstmt.setString(1, maSinhVien);
           //đưa masinhvien vào để thực hiện xóa 
            
            return pstmt.executeUpdate()>0;//thực hiện câu lệnh update 
        }
    }   
     //phương thức tìm mã số sinh viên 
      public BangDiem findByMaSinhVien(String maSinhVien)
             throws Exception{
        //kiem tra va lay thong tin ten dang nhap mat khau 
        String sql = "select* from dbo . BangDiem "+ " where MaSinhVien = ?";
        //update điều kiện là mã sinh viên 
       //riêng trường mã không cần chèn dữ liệu vì nó là trường tự tăng trong csdl
       //nên trong câu lệnh insert into không thiết lập giá trị cho trường này 
        try(
            Connection con = DatabaseHelper.openConnection(); 
            PreparedStatement pstmt = con.prepareStatement(sql);
           ){
            //thiết lập các trường trong bảng dữ liệu
           //lỗi xung đột trong sql server là khi một khóa phụ tham chiếu đến một khóa chính trong bảng nhé ma trong bảng của khóa chính 
           //không có giá trị đó thì tức nhiên sẽ làm cho khóa phụ không thể hiện được dữ liệu của khóa chính nên ta bắt buộc phải nhập một dữ liệu 
           //mà khóa chính đã có rồi lúc đó khóa phụ mới thực hiên được 
            pstmt.setString(1, maSinhVien);
           //đưa masinhvien vào để thực hiện xóa 
            try(ResultSet rs = pstmt.executeQuery();){
                if(rs.next()){
                BangDiem bd = createBangDiem(rs);
      
                return bd;
                }
            }
             return null;
        }
    }   
      //trả về tất cả các dữ liệu của bảng ghi có trong bảng điểm và sử dụng vòng lặp while
      public List <BangDiem> findAll()
             throws Exception{
        
        String sql = "select* from dbo . BangDiem ";
       
        try(
            Connection con = DatabaseHelper.openConnection(); 
            PreparedStatement pstmt = con.prepareStatement(sql);
           ){
             
           
            try(ResultSet rs = pstmt.executeQuery();){
                List <BangDiem> list = new ArrayList<>();
                while(rs.next()){
                BangDiem bd = createBangDiem(rs);
      
                list.add(bd);//thêm đối tượng dó vào trong danh sách
                }
                return list;//trả danh sách lời gọi của phương thức
            }
        }
    }   
      //tìm 3 sinh viên có điểm cao nhất trong bảng điểm 
       public List <BangDiem> findTop(int top)
             throws Exception{
        
        String sql = " select top " + top + "*,(TiengAnh + TinHoc +GDTC)/3 as DTB" +" from BangDiem order by dtb desc ";
        try(
            Connection con = DatabaseHelper.openConnection(); 
            PreparedStatement pstmt = con.prepareStatement(sql);
           ){
             
           
            try(ResultSet rs = pstmt.executeQuery();){
                List <BangDiem> list = new ArrayList<>();
                while(rs.next()){
                BangDiem bd = createBangDiem(rs);
      
                list.add(bd);//thêm đối tượng dó vào trong danh sách
                }
                return list;//trả danh sách lời gọi của phương thức
            }
        }
    }   

    private BangDiem createBangDiem(final ResultSet rs) throws SQLException {
        BangDiem bd = new BangDiem();
        bd.setMa(rs.getInt("Ma"));
        bd.setMaSinhVien(rs.getString("maSinhVien"));
        bd.setTiengAnh(rs.getFloat("TiengAnh"));
        bd.setTinHoc(rs.getFloat("TinHoc"));
        bd.setGDTC(rs.getFloat("GDTC"));
        return bd;
    }
}
