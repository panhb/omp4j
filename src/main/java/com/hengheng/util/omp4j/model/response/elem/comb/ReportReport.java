package com.hengheng.util.omp4j.model.response.elem.comb;

import com.hengheng.util.omp4j.model.base.BaseModel;
import com.hengheng.util.omp4j.model.response.elem.ResultElement;
import com.hengheng.util.omp4j.model.response.elem.TaskElement;
import com.hengheng.util.omp4j.model.response.elem.orig.Asset;
import com.hengheng.util.omp4j.model.response.elem.orig.Nvt;
import com.hengheng.util.omp4j.model.response.elem.orig.Preference;
import lombok.Data;

import java.util.List;

/**
 * @author panhb
 */
@Data
public class ReportReport extends BaseModel{

    private String id;
    private Version omp;
    private Sort sort;
    private Filters filters;
    private ReportSeverityClass severity_class;
    private Count user_tags;
    private String scan_run_status;
    private Count hosts;
    private Count closed_cves;
    private Count vulns;
    private Count os;
    private Count apps;
    private Count ssl_certs;
    private TaskElement task;
    private ReportScan scan;
    private String timestamp;
    private String scan_start;
    private String timezone;
    private String timezone_abbrev;
    private ReportPorts ports;
    private ReportResults results;
    private ReportResultCount result_count;
    private ReportResultCount.FullFiltered severity;
    private ReportHost host;
    private HostText host_start;
    private HostText host_end;
    private String scan_end;
    private ReportErrors errors;
    private String report_format;

    @Data
    public static class Count extends BaseModel {

        private String count;

    }

    @Data
    public static class HostText extends BaseModel {

        private String text;
        private String host;

    }

    @Data
    public static class Version extends BaseModel{

        private String version;

    }

    @Data
    public static class ReportResultCount extends BaseModel{

        private String text;
        private String full;
        private String filtered;
        private FullFiltered debug;
        private FullFiltered hole;
        private FullFiltered info;
        private FullFiltered log;
        private FullFiltered warning;

        @Data
        public static class FullFiltered extends BaseModel{

            private String full;
            private String filtered;
        }
    }

    @Data
    public static class ReportScan extends BaseModel{

        private ReportTask task;

        @Data
        public static class ReportTask extends BaseModel{

            private Slave slave;
            private List<Preference> preferences;

            @Data
            public static class Slave extends BaseModel{

                private String id;
                private String name;
                private String host;
                private String port;

            }
        }
    }

    @Data
    public static class ReportHost extends BaseModel{

        private String ip;
        private String start;
        private String end;
        private Asset asset;
        private ReportHostResultCount.Page port_count;
        private ReportHostResultCount result_count;
        private List<ReportDetail> detail;

        @Data
        public static class ReportDetail extends BaseModel{

            private String name;
            private String value;
            private String extra;
            private Source source;

            @Data
            public static class Source extends BaseModel {

                private String type;
                private String name;
                private String description;

            }
        }

        @Data
        public static class ReportHostResultCount extends BaseModel{

            private String page;
            private Page false_positive;
            private Page hole;
            private Page info;
            private Page log;
            private Page warning;

            /**
             * @author panhb
             */
            @Data
            public static class Page extends BaseModel{

                private String page;
            }
        }
    }

    @Data
    public static class ReportErrors extends BaseModel{

        private String count;
        private List<ReportError> error;

        @Data
        public static class ReportError extends BaseModel {

            private String port;
            private String description;
            private String scan_nvt_version;
            private String severity;
            private Host host;
            private Nvt nvt;

        }
    }

    @Data
    public static class ReportSeverityClass extends BaseModel{

        private String id;
        private String name;
        private String full_name;
        private List<SeverityRange> severity_range;

        @Data
        public static class SeverityRange extends BaseModel{

            private String name;
            private String min;
            private String max;

        }
    }

    @Data
    public static class ReportResults extends BaseModel{

        private String max;
        private String start;
        private List<ResultElement> result;

    }
}
