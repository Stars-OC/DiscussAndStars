package xyz.starsoc.replay.pojo;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@TableName("discuss")
@Builder
public class Discuss {

    @TableId(type = IdType.AUTO)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long discussId;

    private Long username;

    private String title;

    private String content;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Long updateTime;

    @TableField(fill = FieldFill.INSERT,updateStrategy = FieldStrategy.NEVER)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Long createTime;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long courseId;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Integer deleted;
}
