/**
 * 
 */
package com.usmilitary.adapters;

import java.util.List;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.usmilitary.R;
import com.usmilitary.model.USMilitaryGroupModel;

/**
 * @author darshanbidkar The adapter that will show list of branches. eg. army,
 *         air force, etc.
 */
public class HomeListAdapter extends ArrayAdapter<USMilitaryGroupModel> {

	private Context mContext;
	private LayoutInflater mInflater;

	public HomeListAdapter(Context context, int resource,
			List<USMilitaryGroupModel> objects) {
		super(context, resource, objects);
		this.mInflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		this.mContext = context;
	}

	private static class ViewHolder {
		TextView title;
		ImageView img;
	}

	@SuppressLint("InflateParams")
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		USMilitaryGroupModel currentModel = super.getItem(position);
		ViewHolder viewHolder;
		if (convertView == null) {
			viewHolder = new ViewHolder();
			convertView = this.mInflater.inflate(R.layout.cell_home, null);
			viewHolder.title = (TextView) convertView
					.findViewById(R.id.cell_title);
			viewHolder.img = (ImageView) convertView
					.findViewById(R.id.cell_img);
			convertView.setTag(viewHolder);

		} else {
			viewHolder = (ViewHolder) convertView.getTag();
		}

		viewHolder.title.setText(currentModel.getTitle());
		Picasso.with(this.mContext).load(currentModel.getLogo())
				.into(viewHolder.img);
		return convertView;
	}
}
