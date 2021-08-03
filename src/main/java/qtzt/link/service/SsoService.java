package qtzt.link.service;

import qtzt.link.annotation.MyDataSource;
import qtzt.link.model.dto.UserInfoDTO;
import qtzt.link.model.dto.UserLogDTO;

import java.util.List;

/**
 * @author: yuanlin
 * @date: 2021-06-01 16:04:24
 * @description:
 */

public interface SsoService {
    @MyDataSource(name = "db-sso")
    UserInfoDTO getUserInfoDTO(Integer userId);

    @MyDataSource(name = "db-sso")
    List<UserLogDTO> getUserLogDTOs(Integer userId);
}
