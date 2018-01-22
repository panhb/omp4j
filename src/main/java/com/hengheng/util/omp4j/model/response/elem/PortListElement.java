package com.hengheng.util.omp4j.model.response.elem;

import com.hengheng.util.omp4j.model.response.elem.common.CommonResult;
import com.hengheng.util.omp4j.model.response.elem.orig.PortCount;
import com.hengheng.util.omp4j.model.response.elem.orig.PortRange;
import lombok.Data;

import java.util.List;

/**
 * @author panhb
 */
@Data
public class PortListElement extends CommonResult {

    private PortCount port_count;
    private List<PortRange> port_ranges;
    private List<TargetElement> targets;

}
