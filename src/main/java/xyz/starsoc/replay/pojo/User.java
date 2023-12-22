package xyz.starsoc.replay.pojo;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@TableName("user")
public class User {

    @TableId(type = IdType.AUTO)
    private Long username;

    private String nickname;

    private String avatarUrl;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    private String description;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField(fill = FieldFill.INSERT,updateStrategy = FieldStrategy.NEVER)
    private Long createTime;

    @TableField(updateStrategy = FieldStrategy.NEVER)
    private Integer role;
}
