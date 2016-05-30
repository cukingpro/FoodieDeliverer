package Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import com.example.huy.foodiedelivere.R;

import java.util.ArrayList;

import model.Manifest;

/**
 * Created by huy on 30/05/2016.
 */
public class ManifestArrayAdapter extends ArrayAdapter<Manifest> {

    private ImageLoader imageLoader;
    private ArrayList<Manifest> manifest;

    public ManifestArrayAdapter(Context context, int layoutId, ArrayList<Manifest> manifest, ImageLoader imageLoader) {
        super(context, layoutId, manifest);
        this.manifest = manifest;
        this.imageLoader = imageLoader;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;

        if (v == null) {
            LayoutInflater vi = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = vi.inflate(R.layout.manifest_layout, null);
        }

//        ViewHolder holder = (ViewHolder) v.getTag();

//        if (holder == null) {
//            holder = new ViewHolder(v);
//            v.setTag(holder);
//        }
        ViewHolder holder = new ViewHolder(v);
        Manifest m = manifest.get(position);
        String image_url = m.getProduct().getImages()[0].getLarge_url();
        if (image_url != null) {
            holder.image.setImageUrl(image_url, imageLoader);
        } else {
            holder.image.setImageResource(R.drawable.no_avatar);
        }

        holder.quantity.setText("x" + m.getQuantity());

        return v;


    }

    private class ViewHolder {
        NetworkImageView image;
        TextView quantity;

        public ViewHolder(View v) {
            image = (NetworkImageView) v.findViewById(R.id.nwivProduct);
            quantity = (TextView) v.findViewById(R.id.tvQuantity);

//            v.setTag(this);
        }
    }
}
