package models.data.form;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.joda.time.DateTime;
import play.data.format.Formats;
import play.data.validation.Constraints;
import play.db.ebean.Model;

import javax.annotation.Nullable;
import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by Sagar Gopale on 5/4/14.
 */
@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class EconomicStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Constraints.Required
    private String name;

    @ManyToOne
    private DataCollectionForm1 dataCollectionForm1;

    @ManyToOne
    private DataCollectionForm6 dataCollectionForm6;

    @Formats.DateTime(pattern = "MM/dd/yy")
    private Timestamp created = new Timestamp(DateTime.now().toDate().getTime());

    public EconomicStatus() {
    }

    public EconomicStatus(String name, DataCollectionForm1 dataCollectionForm1, DataCollectionForm6 dataCollectionForm6) {
        this.name = name;
        this.dataCollectionForm1 = dataCollectionForm1;
        this.dataCollectionForm6 = dataCollectionForm6;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DataCollectionForm1 getDataCollectionForm1() {
        return dataCollectionForm1;
    }

    public void setDataCollectionForm1(DataCollectionForm1 dataCollectionForm1) {
        this.dataCollectionForm1 = dataCollectionForm1;
    }

    public DataCollectionForm6 getDataCollectionForm6() {
        return dataCollectionForm6;
    }

    public void setDataCollectionForm6(DataCollectionForm6 dataCollectionForm6) {
        this.dataCollectionForm6 = dataCollectionForm6;
    }

    public Timestamp getCreated() {
        return created;
    }

    public void setCreated(Timestamp created) {
        this.created = created;
    }

    public static Model.Finder<Long, EconomicStatus> find = new Model.Finder<Long, EconomicStatus>(
            Long.class, EconomicStatus.class
    );
}
