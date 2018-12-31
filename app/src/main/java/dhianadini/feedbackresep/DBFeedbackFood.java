package dhianadini.feedbackresep;

import com.google.firebase.database.IgnoreExtraProperties;

@IgnoreExtraProperties
public class DBFeedbackFood {
    private String foodId;
    private String foodName;

    public DBFeedbackFood(){
        //this constructor is required
    }

    public DBFeedbackFood(String foodId, String foodName) {
        this.foodId = foodId;
        this.foodName = foodName;
    }

    public String getFeedbackId() {
        return foodId;
    }

    public String getFeedbackFood() {
        return foodName;
    }
}
