select top 3 *,(TiengAnh + TinHoc +GDTC)/3 as DTB
from BangDiem order by dtb desc
/*câu lệnh truy vấn đến điểm trung bình của ba bạn có điểm cao nhất trong bảng*/