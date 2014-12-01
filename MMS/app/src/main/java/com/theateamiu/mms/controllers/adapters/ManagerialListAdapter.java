package com.theateamiu.mms.controllers.adapters;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.theateamiu.mms.R;
import com.theateamiu.mms.models.Managerial;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.List;


public class ManagerialListAdapter  extends ArrayAdapter<Managerial>{
    private Context context;
    private List<Managerial> managerialList;

    public ManagerialListAdapter(Context context,List<Managerial> managerialList) {
        super(context, R.layout.listview_row_managerial, R.id.tvListViewRowManagerialName, managerialList);

        this.context = context;
        this.managerialList= managerialList;

    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;

        if(row == null){
            row = LayoutInflater.from(context).
                    inflate(R.layout.listview_row_managerial, parent, false);
        }

        ImageView imageView = (ImageView)row.findViewById(R.id.ivListViewRowManagerial);
        TextView tvName = (TextView)row.findViewById(R.id.tvListViewRowManagerialName);
        TextView tvRank = (TextView)row.findViewById(R.id.tvListViewRowManagerialRank);
        TextView tvDuration = (TextView)row.findViewById(R.id.tvListViewRowManagerialDuration);

        Managerial managerial = getManagerial(position);

        tvName.setText(managerial.getName());

        String ranking = "DR: "+managerial.getRankInDist()+"\n"+"CR: "+managerial.getRankInCountry();
        tvRank.setText(ranking);

        String duration = managerial.getStartDate()+" to "+managerial.getEndDate();
        tvDuration.setText(duration);

        Uri imageUri = Uri.parse(managerial.getImagePath());
        try {
            InputStream is = getContext().getContentResolver().openInputStream(imageUri);
            Drawable drawable = Drawable.createFromStream(is,"");
            imageView.setImageDrawable(drawable);
        } catch (FileNotFoundException e) {
            imageView.setImageDrawable(context.getResources().getDrawable(R.drawable.content_picture));
        }
        return row;
    }//end method getView

    public Managerial getManagerial(int position){
        return managerialList.get(position);
    }

    class ViewHolder{
        ImageView ivManagerial=null;

        ViewHolder(View row){
            ivManagerial = (ImageView)row.findViewById(R.id.ivListViewRowManagerial);
        }
    }
}
