package xyz.starsoc.replay.pojo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class ReplyResources {

    private List<String> images = new ArrayList<>();

    private List<String> videos = new ArrayList<>();

    private List<String> audios = new ArrayList<>();

    public static String toJson(ReplyResources resources) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.writeValueAsString(resources);
        } catch (JsonProcessingException e) {
            return null;
        }
    }

    public static ReplyResources fromJson(String str) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.readValue(str, ReplyResources.class);
        } catch (JsonProcessingException e) {
            return null;
        }
    }
}
