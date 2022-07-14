package com.hengheng.util.omp4j.model.response.elem.common;

import com.hengheng.util.omp4j.model.base.BaseModel;
import lombok.Data;

import java.util.List;

/**
 * @author panhb
 */
@Data
public class CommonResult extends BaseModel {

    private String id;
    private String name;
    private Permissions.Name owner;
    private String comment;
    private String creation_time;
    private String modification_time;
    private UserTags user_tags;

    private String in_use;
    private String writable;
    private Permissions permissions;

    @Data
    public static class UserTags extends BaseModel {

        private String count;
        private List<Tag> tag;

        @Data
        public static class Tag extends BaseModel {

            private String id;
            private String name;
            private String value;
            private String comment;

        }
    }

    @Data
    public static class Permissions extends BaseModel {

        private List<Name> permission;

        @Data
        public static class Name extends BaseModel{

            private String name;
        }
    }
}

