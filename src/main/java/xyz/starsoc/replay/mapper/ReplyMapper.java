package xyz.starsoc.replay.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import xyz.starsoc.replay.pojo.Reply;

@Mapper
public interface ReplyMapper extends BaseMapper<Reply> {

    @Select("select scores from reply where content_id = #{contentId}")
    Integer getScore(Long contentId);
}
