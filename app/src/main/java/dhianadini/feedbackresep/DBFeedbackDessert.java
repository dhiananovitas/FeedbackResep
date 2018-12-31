package dhianadini.feedbackresep;

import com.google.firebase.database.IgnoreExtraProperties;

@IgnoreExtraProperties
public class DBFeedbackDessert {
    private String feedbackId;
    private String feedbackDessert;

    public DBFeedbackDessert(){
        //this constructor is required
    }

    public DBFeedbackDessert(String feedbackId, String feedbackDessert) {
        this.feedbackId = feedbackId;
        this.feedbackDessert = feedbackDessert;
    }

    public String getFeedbackId() {
        return feedbackId;
    }

    public String getFeedbackDessert() {
        return feedbackDessert;
    }
}
