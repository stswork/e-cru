package models.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import models.data.form.BarthelIndexForm;
import models.data.form.FormType;
import play.data.validation.Constraints;
import play.db.ebean.Model;

import javax.persistence.*;

/**
 * Created by Sagar Gopale on 5/3/14.
 */
@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class Answer extends Model {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @OneToOne
    private Question question;

    @Constraints.Required
    private String answer;

    @Constraints.Required
    private FormType formType;

    @OneToOne
    private BarthelIndexForm barthelIndexForm;


}
