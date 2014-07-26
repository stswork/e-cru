package models.actor.mail;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by Sagar Gopale on 7/27/14.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Mail {

    public String recipient;
    public String exportUrl;

    public Mail() {
    }

    public Mail(String recipient, String exportUrl) {
        this.recipient = recipient;
        this.exportUrl = exportUrl;
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public String getExportUrl() {
        return exportUrl;
    }

    public void setExportUrl(String exportUrl) {
        this.exportUrl = exportUrl;
    }
}
