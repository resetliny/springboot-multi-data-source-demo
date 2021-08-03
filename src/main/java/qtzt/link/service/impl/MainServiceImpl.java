package qtzt.link.service.impl;

import qtzt.link.mapper.MainMapper;
import qtzt.link.model.dto.ProjectInfoDTO;
import qtzt.link.model.dto.UserLogDTO;
import qtzt.link.service.MainService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author: yuanlin
 * @date: 2021-06-01 17:06:26
 * @description:
 */
@Service
public class MainServiceImpl implements MainService {
    @Resource
    MainMapper mainMapper;

    /**
     * 默认数据源
     */
    @Override
    public ProjectInfoDTO getSiteInfoDTO(Integer comId, Integer userId){
        return mainMapper.getSiteInfoById(comId, userId);
    }

    @Override
    public Integer getUserIdByProjectId(Integer comId){
        return mainMapper.getUserIdByProjectId(comId);
    }

    @Override
    public List<UserLogDTO> getUserLogList(Integer userId){
        return mainMapper.getUserLogList(userId);
    }

}
