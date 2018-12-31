package dhianadini.feedbackresep;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class FeedbackDessertList extends ArrayAdapter<DBFeedbackDessert> {
    private Activity context;
    List<DBFeedbackDessert> feedbackDessertList;

    public FeedbackDessertList(Activity context, List<DBFeedbackDessert> feedbackDessertList) {
        super(context, R.layout.item_feedback_dessert, feedbackDessertList);
        this.context = context;
        this.feedbackDessertList = feedbackDessertList;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View listViewItem = inflater.inflate(R.layout.item_feedback_dessert, null, true);

        TextView textViewFeedback = (TextView) listViewItem.findViewById(R.id.textViewFeedback);

        DBFeedbackDessert feedbackDessert = feedbackDessertList.get(position);
        textViewFeedback.setText(feedbackDessert.getFeedbackDessert());

        return listViewItem;
    }
}
