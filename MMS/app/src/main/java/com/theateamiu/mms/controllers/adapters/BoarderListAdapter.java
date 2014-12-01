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
import android.widget.Toast;

import com.theateamiu.mms.R;
import com.theateamiu.mms.models.Boarder;

import java.io.InputStream;
import java.util.List;


public class BoarderListAdapter extends ArrayAdapter<Boarder> {
    List<Boarder> boarderList;
    Context context;
    LayoutInflater inflater;

    public BoarderListAdapter(Context context,List<Boarder> boarderList) {
        super(context, R.layout.listview_row_boarder,R.id.tvListViewRowBoarderName, boarderList);
        this.context=context;
        this.boarderList = boarderList;
        //checkBoarderList();
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    private void checkBoarderList() {
        for(Boarder b: boarderList){
            Toast.makeText(context,b.toString(),Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        if(row == null){
            row = inflater.inflate(R.layout.listview_row_boarder,null);
        }


        ImageView imageView = (ImageView)row.findViewById(R.id.ivListViewRowBoarder);
        TextView tvName = (TextView)row.findViewById(R.id.tvListViewRowBoarderName);
        TextView tvContact = (TextView)row.findViewById(R.id.tvListViewRowBoarderContact);
        TextView tvInfo = (TextView)row.findViewById(R.id.tvListViewRowBoarderInfo);

        Boarder boarder = boarderList.get(position);

        tvName.setText(boarder.getName());
        tvContact.setText(boarder.getPhoneNo());
        // TODO: set some useful information about the boarder
        tvInfo.setText(boarder.getBloodGroup());

        Uri imageUri = Uri.parse(boarder.getImageURL());

        try {
            InputStream is = getContext().getContentResolver().openInputStream(imageUri);
            Drawable drawable = Drawable.createFromStream(is,"");
            imageView.setImageDrawable(drawable);
        } catch (Exception e) {
            imageView.setImageDrawable(context.getResources().getDrawable(R.drawable.content_picture));
        }

        return  row;
    }

    public Boarder getBoarder(int position){
        return boarderList.get(position);
    }
}
