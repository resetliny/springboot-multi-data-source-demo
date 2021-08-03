package qtzt.link.service;

import qtzt.link.annotation.MyDataSource;

import java.time.LocalDate;
import java.util.List;

/**
 * @author: yuanlin
 * @date: 2021-06-01 16:46:23
 * @description:
 */

public interface SlaveService {
    @MyDataSource(name = "db-slave")
    List<Integer> getProjectIdList(LocalDate dayId);

    @MyDataSource(name = "db-slave")
    Integer getTotalCount();

    @MyDataSource(name = "db-slave")
    Integer getValidCount();

    @MyDataSource(name = "db-slave")
    List<Integer> getValidUserList();
}
