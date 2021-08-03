package qtzt.link.service.impl;

import qtzt.link.annotation.MyDataSource;
import qtzt.link.mapper.SsoMapper;
import qtzt.link.model.dto.UserInfoDTO;
import qtzt.link.model.dto.UserLogDTO;
import qtzt.link.service.SsoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: yuanlin
 * @date: 2021-06-01 16:04:59
 * @description:
 */

@Service
@Slf4j
public class SsoServiceImpl implements SsoService {
    @Resource
    SsoMapper userCenterManageMapper;

    @MyDataSource(name = "db-user-center")
    @Override
    public UserInfoDTO getUserInfoDTO(Integer userId){
        return userCenterManageMapper.getUserInfoById(userId);
    }

    @MyDataSource(name = "db-user-center")
    @Override
    public List<UserLogDTO> getUserLogDTOs(Integer userId){
        List<UserLogDTO> userLogInList = userCenterManageMapper.getUserLogInList(userId);
        List<UserLogDTO> userLogOutList = userCenterManageMapper.getUserLogOutList(userId);
        List<UserLogDTO> userLogDTOS = new ArrayList<>();
        userLogDTOS.addAll(userLogInList);
        userLogDTOS.addAll(userLogOutList);
        return userLogDTOS;
    }
}
