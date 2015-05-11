/**
 * 
 */
package com.usmilitary.adapters;

import java.util.ArrayList;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.usmilitary.R;
import com.usmilitary.model.RankModel;

/**
 * @author darshanbidkar Adapter for displaying all ranks of a particular branch
 */
public class RankAdapter extends ArrayAdapter<RankModel> {

	private final LayoutInflater mInflater;

	public RankAdapter(Context context, int resource,
			ArrayList<RankModel> objects) {
		super(context, resource, objects);
		this.mInflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}

	private static class ViewHolder {
		TextView title;
		ImageView img;
	}

	@SuppressLint("InflateParams")
	@Override
	public View getView(int position, View convertView,
			android.view.ViewGroup parent) {
		RankModel currentRank = super.getItem(position);
		ViewHolder viewHolder;
		if (convertView == null) {
			viewHolder = new ViewHolder();
			convertView = this.mInflater.inflate(R.layout.cell_detail, null);
			viewHolder.title = (TextView) convertView
					.findViewById(R.id.cell_detail_title);
			viewHolder.img = (ImageView) convertView
					.findViewById(R.id.cell_detail_img);
			convertView.setTag(viewHolder);

		} else {
			viewHolder = (ViewHolder) convertView.getTag();
		}
		viewHolder.title.setText(currentRank.getTitle());
		Picasso.with(super.getContext()).load(currentRank.getInsigniaImage())
				.into(viewHolder.img);

		return convertView;
	}
}
