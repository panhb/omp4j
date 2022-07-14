package com.hengheng.util.omp4j.model.response.elem.comb;

import com.hengheng.util.omp4j.model.base.BaseModel;
import lombok.Data;

import java.util.List;

/**
 * @author panhb
 */
@Data
public class ReportPorts extends BaseModel{

    private String max;
    private String start;
    private String count;
    private List<Port> port;

    /**
     * @author panhb
     */
    @Data
    public static class Port extends BaseModel{

        private String text;
        private String host;
        private String severity;
        private String threat;

    }
}
