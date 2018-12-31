package dhianadini.feedbackresep;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class FeedbackFoodList extends ArrayAdapter<DBFeedbackFood> {
    private Activity context;
    List<DBFeedbackFood> feedbackFoodList;

    public FeedbackFoodList(Activity context, List<DBFeedbackFood> feedbackFoodList) {
        super(context, R.layout.item_feedback_food, feedbackFoodList);
        this.context = context;
        this.feedbackFoodList = feedbackFoodList;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View listViewItem = inflater.inflate(R.layout.item_feedback_food, null, true);

        TextView textViewFeedback = (TextView) listViewItem.findViewById(R.id.textViewFeedback);

        DBFeedbackFood feedbackFood = feedbackFoodList.get(position);
        textViewFeedback.setText(feedbackFood.getFeedbackFood());

        return listViewItem;
    }
}
