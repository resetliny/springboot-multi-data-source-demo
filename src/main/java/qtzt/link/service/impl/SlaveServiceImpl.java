package qtzt.link.service.impl;

import qtzt.link.annotation.MyDataSource;
import qtzt.link.mapper.SlaveMapper;
import qtzt.link.service.SlaveService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.util.List;

/**
 * @author: yuanlin
 * @date: 2021-06-01 16:46:45
 * @description:
 */
@Service
public class SlaveServiceImpl implements SlaveService {
    @Resource
    SlaveMapper slaveMapper;

    /**
     * 临时代替用一下，做测试
     */
    @MyDataSource(name = "db-slave")
    @Override
    public List<Integer> getProjectIdList(LocalDate dayId){
        return slaveMapper.listActiveProjectId(dayId);
    }

    @MyDataSource(name = "db-slave")
    @Override
    public Integer getTotalCount(){
        return slaveMapper.getTotalCount();
    }

    @MyDataSource(name = "db-slave")
    @Override
    public Integer getValidCount(){
        return slaveMapper.getValidCount();
    }

    @MyDataSource(name = "db-slave")
    @Override
    public List<Integer> getValidUserList(){
        return slaveMapper.getValidUserList();
    }
}
