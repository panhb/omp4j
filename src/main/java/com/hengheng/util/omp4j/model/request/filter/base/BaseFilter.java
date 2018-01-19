package com.hengheng.util.omp4j.model.request.filter.base;


import com.hengheng.util.omp4j.model.base.BaseModel;
import lombok.Data;

/**
 * @author panhb
 */
@Data
public class BaseFilter extends BaseModel {

    private String uuid;
    private String name;
    private String created;
    private String modified;
    private String owner;

    private Integer rows;
    private Integer first;
    private String sortReverse;
    private String sort;

    private Boolean apply_overrides;
    private Integer autofp;
    private String levels;
    private Integer min_qod;
    private Boolean notes;
    private Boolean overrides;
    private String timezone;

}
