package models.request.export;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Date;

/**
 * Created by Sagar Gopale on 6/25/14.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ExportRequest {

    public String startDate;
    public String endDate;
    public String recipient;

    public ExportRequest() {
    }

    public ExportRequest(String startDate, String endDate, String recipient) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.recipient = recipient;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }
}
