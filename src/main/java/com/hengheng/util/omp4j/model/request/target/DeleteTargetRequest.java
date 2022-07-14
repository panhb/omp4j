package com.hengheng.util.omp4j.model.request.target;

import com.hengheng.util.omp4j.model.base.BaseRequest;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import lombok.Data;

/**
 * @author panhb
 */
@XStreamAlias("delete_target")
@Data
public class DeleteTargetRequest extends BaseRequest {

    @XStreamAsAttribute
    private String target_id;

}


