package ru.org.adons.mplace.list;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import ru.org.adons.mplace.Place;
import ru.org.adons.mplace.R;
import ru.org.adons.mplace.view.ViewActivity;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    private List<Place> places = new ArrayList<Place>();
    private final TypedValue backgroundValue = new TypedValue();
    private int itemBackground;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public final TextView textView;
        public final View holderView;

        public ViewHolder(View v) {
            super(v);
            holderView = v;
            textView = (TextView) v.findViewById(android.R.id.text1);
        }
    }

    public RecyclerAdapter(Context context) {
        context.getTheme().resolveAttribute(R.attr.selectableItemBackground, backgroundValue, true);
        itemBackground = backgroundValue.resourceId;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(android.R.layout.simple_list_item_1, parent, false);
        view.setBackgroundResource(itemBackground);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.textView.setText(places.get(position).getName());
        // VIEW PLACE
        holder.holderView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), ViewActivity.class);
                intent.putExtra(ViewActivity.EXTRA_ID, places.get(position).getID());
                intent.putExtra(ViewActivity.EXTRA_NAME, places.get(position).getName());
                v.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return places.size();
    }

    // to load all using Loader
    public void setPlaces(List<Place> places) {
        this.places = places;
    }

    // to add one
    public void addPlace(int rowID) {
        // TODO: implement incremental adding to prevent reload all items via Loader
    }
}