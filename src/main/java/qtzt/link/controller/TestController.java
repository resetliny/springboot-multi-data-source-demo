package qtzt.link.controller;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.write.metadata.WriteSheet;
import qtzt.link.model.dto.ProjectInfoDTO;
import qtzt.link.model.dto.UserInfoDTO;
import qtzt.link.model.dto.UserLogDTO;
import qtzt.link.service.SsoService;
import qtzt.link.service.MainService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author: yuanlin
 * @date: 2021-06-01 17:15:39
 * @description:
 */

@RestController
@Slf4j
public class TestController {

    @Autowired
    MainService mainServiceImpl;

    @Autowired
    SsoService ssoServiceImpl;

    /**
     * 文件下载（失败了会返回一个有部分数据的Excel）
     * <p>1. 创建excel对应的实体对象 参照 各个dto对象
     * <p>2. 设置返回的 参数
     * <p>3. 直接写，这里注意，finish的时候会自动关闭OutputStream,当然你外面再关闭流问题不大
     */
    @GetMapping("/test/download")
    public void download(Integer projectId,HttpServletResponse response) throws IOException {

        // 这里注意 有同学反应使用swagger 会导致各种问题，请直接用浏览器或者用postman
        response.setContentType("application/vnd.ms-excel");
        response.setCharacterEncoding("utf-8");
        // 这里URLEncoder.encode可以防止中文乱码 当然和easy-excel没有关系
        String fileName = URLEncoder.encode(Integer.toString(projectId), "UTF-8");
        response.setHeader("Content-disposition", "attachment;filename=" + fileName + ".xlsx");

        Integer userId = mainServiceImpl.getUserIdByProjectId(projectId);
        //站点信息
        ProjectInfoDTO projectInfoDTO = mainServiceImpl.getSiteInfoDTO(projectId, userId);
        List<ProjectInfoDTO> projectInfoDTOList = new ArrayList<>();
        projectInfoDTOList.add(projectInfoDTO);
        UserInfoDTO userInfoDTO = ssoServiceImpl.getUserInfoDTO(userId);

        //用户的登录记录
        List<UserLogDTO> totalLogList = ssoServiceImpl.getUserLogDTOs(userId);

        if(totalLogList.size() > 0){
            UserLogDTO userLogDTO = totalLogList.get(0);
            userInfoDTO.setLastLogTime(userLogDTO.getLogTime());
            userInfoDTO.setLastLogIp(userLogDTO.getLogIp());
        }
        List<UserInfoDTO> userInfoDTOList = new ArrayList<>();
        userInfoDTOList.add(userInfoDTO);

        ExcelWriter excelWriter = null;
        try{
            excelWriter = EasyExcel.write(response.getOutputStream()).build();
            WriteSheet sheet1 = EasyExcel.writerSheet(0,"项目信息").head(ProjectInfoDTO.class).build();
            excelWriter.write(projectInfoDTOList, sheet1);
            WriteSheet sheet2 = EasyExcel.writerSheet(1,"用户信息").head(UserInfoDTO.class).build();
            excelWriter.write(userInfoDTOList, sheet2);
            WriteSheet sheet3 = EasyExcel.writerSheet(2,"用户登入登出记录").head(UserLogDTO.class).build();
            excelWriter.write(totalLogList, sheet3);
        }finally {
            // 千万别忘记finish 会帮忙关闭流
            if (excelWriter != null) {
                excelWriter.finish();
            }
        }
    }
}
