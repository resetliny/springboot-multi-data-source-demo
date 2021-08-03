package qtzt.link.mapper;

import qtzt.link.model.dto.UserInfoDTO;
import qtzt.link.model.dto.UserLogDTO;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p></p>
 * @author yuan
 * @className SsoMapper
 * @since Created in 2021年6月1日
 * @modified By
 */
public interface SsoMapper {
    
    @Select("")
    UserInfoDTO getUserInfoById(Integer userId);

    @Select("")
    List<UserLogDTO> getUserLogInList(Integer userId);

    @Select("")
    List<UserLogDTO> getUserLogOutList(Integer userId);

}
