/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PolyApp.model;

/**
 *
 * @author Admin-PC
 */
//nội dung sơ bộ của bảng điểm 
public class BangDiem {
    //phải trùng khớp với bảng điểm trong cơ sơ dữ liệu
           private int Ma;
           private String MaSinhVien;  
           private float  TiengAnh  , TinHoc   , GDTC  ;

    public BangDiem() {
    }

    public BangDiem(int Ma, String MaSinhVien, float TiengAnh, float TinHoc, float GDTC) {
        this.Ma = Ma;
        this.MaSinhVien = MaSinhVien;
        this.TiengAnh = TiengAnh;
        this.TinHoc = TinHoc;
        this.GDTC = GDTC;
    }

    public int getMa() {
        return Ma;
    }

    public void setMa(int Ma) {
        this.Ma = Ma;
    }

    public String getMaSinhVien() {
        return MaSinhVien;
    }

    public void setMaSinhVien(String MaSinhVien) {
        this.MaSinhVien = MaSinhVien;
    }

    public float getTiengAnh() {
        return TiengAnh;
    }

    public void setTiengAnh(float TiengAnh) {
        this.TiengAnh = TiengAnh;
    }

    public float getTinHoc() {
        return TinHoc;
    }

    public void setTinHoc(float TinHoc) {
        this.TinHoc = TinHoc;
    }

    public float getGDTC() {
        return GDTC;
    }

    public void setGDTC(float GDTC) {
        this.GDTC = GDTC;
    }
            
         
}
