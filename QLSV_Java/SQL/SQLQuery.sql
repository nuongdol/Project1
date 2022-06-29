select TenVT,ChungLoai,DVT,Sum(Soluong)from example11 where Chungloai='Xi mang'
group by TenVT,Chungloai,DVT having sum(Soluong)>50