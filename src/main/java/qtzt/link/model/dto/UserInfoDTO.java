package qtzt.link.model.dto;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: yuanlin
 * @date: 2021-06-01 15:46:11
 * @description:
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@ColumnWidth(25)
public class UserInfoDTO {
    @ExcelProperty("账户名")
    private String userName;
    @ExcelProperty("手机号")
    private String mobile;
    @ExcelProperty("邮箱")
    private String email;
    @ExcelProperty("注册时间")
    private String regTime;
    @ExcelProperty("注册IP")
    private String regIp;
    @ExcelProperty("最后登录时间")
    private String lastLogTime;
    @ExcelProperty("最后登录IP")
    private String lastLogIp;
}
