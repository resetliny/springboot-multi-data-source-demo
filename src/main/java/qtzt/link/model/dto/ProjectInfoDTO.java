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
public class ProjectInfoDTO {
    @ExcelProperty("项目id")
    private String projectId;
    @ExcelProperty("介绍")
    private String description;
    @ExcelProperty("创建时间")
    private String addTime;
    @ExcelProperty("开始时间")
    private String startTime;
}
