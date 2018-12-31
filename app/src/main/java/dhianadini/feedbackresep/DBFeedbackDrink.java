package dhianadini.feedbackresep;

import com.google.firebase.database.IgnoreExtraProperties;

@IgnoreExtraProperties
public class DBFeedbackDrink {
    private String feedbackId;
    private String feedbackDrink;

    public DBFeedbackDrink(){
        //this constructor is required
    }

    public DBFeedbackDrink(String feedbackId, String feedbackDrink) {
        this.feedbackId = feedbackId;
        this.feedbackDrink = feedbackDrink;
    }

    public String getFeedbackId() {
        return feedbackId;
    }

    public String getFeedbackDrink() {
        return feedbackDrink;
    }
}