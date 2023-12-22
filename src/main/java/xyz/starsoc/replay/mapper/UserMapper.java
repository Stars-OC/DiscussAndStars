package xyz.starsoc.replay.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import xyz.starsoc.replay.pojo.User;

@Mapper
public interface UserMapper extends BaseMapper<User> {
}
