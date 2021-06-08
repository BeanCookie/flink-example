package cn.lz.flink.app.model;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@Builder
public class NginxLog {
    private String clientIp;
    private LocalDateTime timestamp;
    private String request;
    private String responseStatus;
    private String bodyBytesSent;
    private String httpReferer;
    private String httpUserAgent;

}
