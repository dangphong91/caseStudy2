<h1>Giới thiệu Case Study Module 2:</h1>
<h2>Phần mềm quản lý học viên.</h2>
<h3>1.Mô tả chương trình:</h3>
    Xây dựng ứng dụng quản lý học viên gồm các thông tin:<br>
        - Tên: Bao gồm họ và tên<br>
        - Mã học viên: Mã bắt buộc là C0221H1..<br>
        - Tuổi: Giới hạn tuổi từ 20-29<br>
        - Giới tính: Chỉ chấp nhận Nam/Nữ<br>
        - Điểm thi: Mặc định 0.0 cho 4 cột điểm, được tính hệ số lần lượt 1-1-2-3, được nhập vào từ chương trình với yêu cầu >=0.0 && <=10.0<br>
        - Điểm tổng kết: Lấy kết quả trung bình của điểm thi khi 4 cột điểm đã có điểm, mặc định là -1<br>
        - Xếp loại: Nếu điểm trung bình trên 8.5 xếp loại giỏi<br>
                    Nếu điểm trung bình trên 7.0 xếp loại khá<br>
                    Nếu điểm trung bình trên 5.5 xếp loại trung bình<br>
                    Nếu điểm trung bình trên 4.0 xếp loại yếu<br>
                    Nếu điểm trung bình trên 0.0 xếp loại kém<br>
                    Nếu điểm trung bình là -1 thì không xếp loại<br>
    Đọc/ghi với file CSV.<br>
    Làm việc với menu.<br>
<h3>2.Cài đặt chức năng:</h3>
    <h4>- 1.Read file:</h4>
        Lựa chọn đọc từ file sẽ thực hiện tính năng đọc danh sách học viên từ file csv có sẵn<br>
        Nhấn enter để quay lại menu<br>
    <h4>- 2.Add student:</h4>
        Lựa chọn thêm học viên sẽ thực hiện tính năng thêm 1 học viên mới với thông tin:<br>
            Tên, mã học viên, tuổi, giới tính, điểm thi mặc định là 0.0<br>
        Yêu cầu:<br>
            Hiển thị mẫu để người dùng nhập<br>
            Kiểm tra nếu trùng mã học viên thì dừng nhập<br>
            Nếu dữ liệu hợp lệ thực hiện thêm dữ liệu vào bộ nhớ và thông báo kết quả<br>
            Nhấn enter để quay lại menu<br>
    <h4>- 3.Edit student:</h4>
        Lựa chọn sửa học viên sẽ thực hiện tính năng sửa 1 học viên lấy từ mã học viên và sửa thông tin :<br>
            Tên, tuổi, giới tính<br>
        Yêu cầu:<br>
            Hiển thị mẫu để người dùng nhập<br>
            Kiểm tra nếu không có mã học viên thì dừng nhập<br>
            Nếu dữ liệu hợp lệ thực hiện thêm dữ liệu vào bộ nhớ và thông báo kết quả<br>
            Nhấn enter để quay lại menu<br>
    <h4>- 4.Remove student:</h4>
        Lựa chọn xóa học viên sẽ thực hiện tính năng xóa 1 học viên lấy từ mã học viên<br>
        Yêu cầu:<br>
            Hiển thị mẫu để người dùng nhập<br>
            Kiểm tra nếu không có mã học viên thì dừng nhập<br>
            Nếu dữ liệu hợp lệ thực hiện xóa dữ liệu từ bộ nhớ và thông báo kết quả<br>
            Nhấn enter để quay lại menu<br>
    <h4>- 5.Import score:</h4>
        Lựa chọn nhập điểm sẽ thực hiện tính năng thêm điểm cho 1 học viên lấy từ mã học viên<br>
        Yêu cầu:<br>
            Hiển thị mẫu để người dùng nhập<br>
            Kiểm tra nếu không có mã học viên thì dừng nhập<br>
            Nếu dữ liệu hợp lệ thực hiện sửa điểm cột thứ nhất<br>
            Nhấn Y/N để tiếp tục nhập điểm cột 2 hoặc dừng nhập<br>
            Kiểm tra dũ liệu rồi tiếp tục với điểm cột 3 và 4<br>
            Nếu nhập xong thông báo kết quả<br>
            Nhấn enter để quay lại menu<br>
    <h4>- 6.Sort student:</h4>
        Lựa chọn sắp xếp học viên sẽ thực hiện tính năng sắp xếp danh sách học viên<br>
            theo thứ tự giảm dần của điểm trung bình<br>
    <h4>- 7.Ranking list:</h4>
        Lựa chọn danh sách xếp loại sẽ thực hiện tính năng hiển thị tên và xếp loại của các học viên, kèm thống kê số lượng học viên cùng loại<br>
    <h4>- X.Exit system:</h4>
        Lựa chọn tắt phần mềm sẽ thực hiện tính năng thoát khỏi chương trình