package qtzt.link.model.dto;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: yuanlin
 * @date: 2021-06-01 15:53:11
 * @description:
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@ColumnWidth(25)
public class UserLogDTO {
    @ExcelProperty("用户ID")
    private String userId;
    @ExcelProperty("登入/登出时间")
    private String logTime;
    @ExcelProperty("登入/登出IP")
    private String logIp;
    @ExcelProperty("登入/登出端口")
    private String logPort;
    @ExcelProperty("登入/登出")
    private String logType;
}
