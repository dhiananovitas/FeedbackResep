package dhianadini.feedbackresep;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import dhianadini.feedbackresep.DBFeedbackDrink;
import dhianadini.feedbackresep.R;

public class FeedbackDrinkList extends ArrayAdapter<DBFeedbackDrink> {
    private Activity context;
    List<DBFeedbackDrink> feedbackDrinkList;

    public FeedbackDrinkList(Activity context, List<DBFeedbackDrink> feedbackDrinkList) {
        super(context, R.layout.item_feedback_drink, feedbackDrinkList);
        this.context = context;
        this.feedbackDrinkList = feedbackDrinkList;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View listViewItem = inflater.inflate(R.layout.item_feedback_drink, null, true);

        TextView textViewFeedback = (TextView) listViewItem.findViewById(R.id.textViewFeedback);

        DBFeedbackDrink feedbackDrink = feedbackDrinkList.get(position);
        textViewFeedback.setText(feedbackDrink.getFeedbackDrink());

        return listViewItem;
    }
}
