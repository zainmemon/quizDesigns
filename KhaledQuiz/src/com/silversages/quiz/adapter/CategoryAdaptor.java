package com.silversages.quiz.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.silversages.quiz.R;
import com.silversages.quiz.object.CategoryObject;

public class CategoryAdaptor extends BaseAdapter {

	private Activity activity;
	private CategoryObject[] data;
	private static LayoutInflater inflater = null;

	// public ImageLoader imageLoader;

	public CategoryAdaptor(Activity a, CategoryObject[] _data) {
		activity = a;
		data = _data;
		inflater = (LayoutInflater) activity
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}

	public int getCount() {
		return data.length;
	}

	public Object getItem(int position) {
		return position;
	}

	public long getItemId(int position) {

		return position;

	}

	public void Notify() {
		notifyDataSetChanged();

	}

	public static void slide_down(Context ctx, View v) {

		Animation a = AnimationUtils.loadAnimation(ctx, R.anim.slide_down);
		if (a != null) {
			a.reset();
			if (v != null) {
				v.clearAnimation();
				v.startAnimation(a);
			}
		}
	}

	public static void slide_up(Context ctx, View v) {

		Animation a = AnimationUtils.loadAnimation(ctx, R.anim.slide_up);
		if (a != null) {
			a.reset();
			if (v != null) {
				v.clearAnimation();
				v.startAnimation(a);
			}
		}
	}

	public View getView(int position, View convertView, ViewGroup parent) {
		View vi = convertView;
		if (convertView == null)
			vi = inflater.inflate(R.layout.row_category, null);
		TextView title = (TextView) vi.findViewById(R.id.text_titleFirst); // title
		ImageView arrow = (ImageView) vi.findViewById(R.id.image_down_arrow);
		final Context c;

		final RelativeLayout collapsible = (RelativeLayout) vi
				.findViewById(R.id.firstcollapsed);
		collapsible.setVisibility(View.GONE);

		CategoryObject _object = data[(position)];
		c = activity.getBaseContext();

		title.setText(_object.getName());
		arrow.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				if (collapsible.isShown()) {
					CategoryAdaptor.slide_up(c, collapsible);
					collapsible.setVisibility(View.GONE);
				} else {
					collapsible.setVisibility(View.VISIBLE);

					CategoryAdaptor.slide_down(c, collapsible);
				}

			}
		});

		return vi;

	}
}
