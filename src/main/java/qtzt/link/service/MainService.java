package qtzt.link.service;

import qtzt.link.model.dto.ProjectInfoDTO;
import qtzt.link.model.dto.UserLogDTO;

import java.util.List;

public interface MainService {
    ProjectInfoDTO getSiteInfoDTO(Integer comId, Integer userId);

    Integer getUserIdByProjectId(Integer comId);

    List<UserLogDTO> getUserLogList(Integer userId);
}
