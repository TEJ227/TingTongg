package adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import com.rsolutions.tingtongg.R;

import java.util.List;

import app.AppController;
import model.Services;

/**
 * Created by TEJ's on 9/22/2015.
 */
public class CustomListAdapter extends BaseAdapter {
    private Activity activity;
    private LayoutInflater inflater;
    private List<Services> servicesItems;
    ImageLoader imageLoader = AppController.getInstance().getImageLoader();

    public CustomListAdapter(Activity activity, List<Services> servicesItems) {
        this.activity = activity;
        this.servicesItems = servicesItems;
    }

    @Override
    public int getCount() {
        return servicesItems.size();
    }

    @Override
    public Object getItem(int location) {
        return servicesItems.get(location);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (inflater == null)
            inflater = (LayoutInflater) activity
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null)
            convertView = inflater.inflate(R.layout.custom_list, null);

        if (imageLoader == null)
            imageLoader = AppController.getInstance().getImageLoader();
        NetworkImageView thumbNail = (NetworkImageView) convertView
                .findViewById(R.id.thumbnail);
        TextView title = (TextView) convertView.findViewById(R.id.title);
        TextView details = (TextView) convertView.findViewById(R.id.details);


        // getting movie data for the row
        Services s = servicesItems.get(position);

        // thumbnail image
        thumbNail.setImageUrl(s.getThumbnailUrl(), imageLoader);

        // title
        title.setText(s.getTitle());

        // rating
        details.setText(s.getDetails());



        return convertView;
    }

}