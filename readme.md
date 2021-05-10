Giới thiệu Case Study Module 2:  
Phần mềm quản lý học viên.  
1.Mô tả chương trình:  
    Xây dựng ứng dụng quản lý học viên gồm các thông tin:  
        - Tên: Bao gồm họ và tên  
        - Mã học viên: Mã bắt buộc là C0221H1..  
        - Tuổi: Giới hạn tuổi từ 20-29  
        - Giới tính: Chỉ chấp nhận Nam/Nữ  
        - Điểm thi: Mặc định 0.0 cho 4 cột điểm, được tính hệ số lần lượt 1-1-2-3, được nhập vào từ chương trình với yêu cầu >=0.0 && <=10.0  
        - Điểm tổng kết: Lấy kết quả trung bình của điểm thi khi 4 cột điểm đã có điểm, mặc định là -1  
        - Xếp loại: Nếu điểm trung bình trên 8.5 xếp loại giỏi  
                    Nếu điểm trung bình trên 7.0 xếp loại khá  
                    Nếu điểm trung bình trên 5.5 xếp loại trung bình  
                    Nếu điểm trung bình trên 4.0 xếp loại yếu  
                    Nếu điểm trung bình trên 0.0 xếp loại kém  
                    Nếu điểm trung bình là -1 thì không xếp loại  
    Đoc/ghi với file CSV.  
    Làm việc với menu.  
2.Cài đặt chức năng:  
    - 1.Read file:  
        Lựa chọn đọc từ file sẽ thực hiện tính năng đọc danh sách học viên từ file csv có sẵn  
        Nhấn enter để quay lại menu  
    - 2.Add student:  
        Lựa chọn thêm học viên sẽ thực hiện tính năng thêm 1 học viên mới với thông tin:  
            Tên, mã học viên, tuổi, giới tính, điểm thi mặc định là 0.0
        Yêu cầu:  
            Hiển thị mẫu để người dùng nhập  
            Kiểm tra nếu trùng mã học viên thì dừng nhập  
            Nếu dữ liệu hợp lệ thực hiện thêm dữ liệu vào bộ nhớ và thông báo kết quả  
            Nhấn enter để quay lại menu  
    - 3.Edit student:  
        Lựa chọn sửa học viên sẽ thực hiện tính năng sửa 1 học viên lấy từ mã học viên và sửa thông tin :  
            Tên, tuổi, giới tính  
        Yêu cầu:  
            Hiển thị mẫu để người dùng nhập  
            Kiểm tra nếu không có mã học viên thì dừng nhập  
            Nếu dữ liệu hợp lệ thực hiện thêm dữ liệu vào bộ nhớ và thông báo kết quả  
            Nhấn enter để quay lại menu  
    - 4.Remove student:  
        Lựa chọn xóa học viên sẽ thực hiện tính năng xóa 1 học viên lấy từ mã học viên  
        Yêu cầu:  
            Hiển thị mẫu để người dùng nhập  
            Kiểm tra nếu không có mã học viên thì dừng nhập  
            Nếu dữ liệu hợp lệ thực hiện xóa dữ liệu từ bộ nhớ và thông báo kết quả  
            Nhấn enter để quay lại menu  
    - 5.Import score:  
        Lựa chọn nhập điểm sẽ thực hiện tính năng thêm điểm cho 1 học viên lấy từ mã học viên  
        Yêu cầu:  
            Hiển thị mẫu để người dùng nhập  
            Kiểm tra nếu không có mã học viên thì dừng nhập  
            Nếu dữ liệu hợp lệ thực hiện sửa điểm cột thứ nhất  
            Nhấn Y/N để tiếp tục nhập điểm cột 2 hoặc dừng nhập  
            Kiểm tra dũ liệu rồi tiếp tục với điểm cột 3 và 4  
            Nếu nhập xong thông báo kết quả  
            Nhấn enter để quay lại menu  
    - 6.Sort student:  
        Lựa chọn sắp xếp học viên sẽ thực hiện tính năng sắp xếp danh sách học viên  
            theo thứ tự giảm dần của điểm trung bình  
    - 7.Ranking list:  
        Lựa chọn danh sách xếp loại sẽ thực hiện tính năng hiển thị tên và xếp loại của các học viên, kèm thống kê số lượng học viên cùng loại  
    - X.Exit system:  
        Lựa chọn tắt phần mềm sẽ thực hiện tính năng thoát khỏi chương trình