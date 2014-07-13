package models.request.export;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Date;

/**
 * Created by Sagar Gopale on 6/25/14.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ExportRequest {
    public Date startDate;
    public Date endDate;

    public ExportRequest() {
    }

    public ExportRequest(Date startDate, Date endDate) {
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}
