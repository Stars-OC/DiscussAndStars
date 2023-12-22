package xyz.starsoc.replay.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import xyz.starsoc.replay.pojo.ReplyStar;

@Mapper
public interface ReplyStarMapper extends BaseMapper<ReplyStar> {

    @Override
    @Delete("delete from reply_star where content_id = #{contentId} and username = #{username}")
    int deleteById(ReplyStar entity);


    @Select("select count(*) from reply_star where content_id = #{contentId}")
    int getStarsByContentId(Long contentId);
}
