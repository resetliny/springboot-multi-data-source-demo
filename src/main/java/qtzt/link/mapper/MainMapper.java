package qtzt.link.mapper;

import qtzt.link.model.dto.ProjectInfoDTO;
import qtzt.link.model.dto.UserLogDTO;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p></p>
 * @author yuan
 * @className MainMapper
 * @since Created in 2021年6月1日
 * @modified By
 */
public interface MainMapper {
    
    @Select("")
    Integer getUserIdByProjectId(Integer projectId);

    @Select("")
    List<UserLogDTO> getUserLogList(Integer userId);

    @Select("")
    ProjectInfoDTO getSiteInfoById(Integer comId, Integer userId);
}
