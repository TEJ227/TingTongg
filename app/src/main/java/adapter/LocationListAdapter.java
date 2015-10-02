package adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.rsolutions.tingtongg.R;

import java.util.List;

import model.Locations;

/**
 * Created by TEJ's on 9/30/2015.
 */
public class LocationListAdapter extends BaseAdapter {
    private Activity activity;
    private LayoutInflater inflater;
    private List<Locations> locationItems;

    public LocationListAdapter(Activity activity, List<Locations> locationItems) {
        this.activity = activity;
        this.locationItems = locationItems;
    }
    @Override
    public int getCount() {
        return locationItems.size();
    }

    @Override
    public Object getItem(int position) {
        return locationItems.get(position);
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
            convertView = inflater.inflate(R.layout.location_list, null);

        TextView location_name = (TextView) convertView.findViewById(R.id.location_name);

        Locations l=locationItems.get(position);
        location_name.setText(l.getLocation_nm());
        return convertView;
    }
}
