package qtzt.link.mapper;

import org.apache.ibatis.annotations.Select;

import java.time.LocalDate;
import java.util.List;

/**
 * <p></p>
 * @author yuan
 * @className SlaveMapper
 * @since Created in 2021年6月1日
 * @modified By
 */
public interface SlaveMapper {
    
    @Select("")
    List<Integer> listActiveProjectId(LocalDate dayId);

    @Select("")
    Integer getTotalCount();

    @Select("")
    Integer getValidCount();

    @Select("")
    List<Integer> getValidUserList();

}
