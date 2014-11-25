package com.theateamiu.mms.constituents.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.theateamiu.mms.R;
import com.theateamiu.mms.constituents.listsrowmodels.Managerial;

import java.util.List;


public class ManagerialListAdapter  extends ArrayAdapter<Managerial>{
    private Context context;
    private LayoutInflater layoutInflater;
    private List<Managerial> managerialList;

    public ManagerialListAdapter(Context context,List<Managerial> managerialList) {
        super(context, R.layout.listview_row_managerial, R.id.tvListViewRowManagerName, managerialList);

        this.context = context;
        this.managerialList= managerialList;
        layoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        //checkList();
    }

    public void checkList(){
        for(Managerial m: managerialList){
            Toast.makeText(context,m.toString(), Toast.LENGTH_LONG).show();
        }
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = layoutInflater.inflate(R.layout.listview_row_managerial,parent,false);
        ImageView imageView = (ImageView)row.findViewById(R.id.ivListViewRowManagerial);
        TextView tvName = (TextView)row.findViewById(R.id.tvListViewRowManagerialName);
        TextView tvRank = (TextView)row.findViewById(R.id.tvListViewRowManagerialRank);
        TextView tvDuration = (TextView)row.findViewById(R.id.tvListViewRowManagerialDuration);

        Managerial managerial = managerialList.get(position);

        tvName.setText(managerial.name);

        String ranking = "DR: "+managerial.rankInDist+"\n"+"CR: "+managerial.rankInCountry;
        tvRank.setText(ranking);

        String duration = managerial.startDate+" to "+managerial.endDate;
        tvDuration.setText(duration);

        // TODO: check imagePath parsing
        /*
        Uri imageUri = Uri.parse(managerial.imagePath);
        try {
            InputStream is = context.getContentResolver().openInputStream(
                    imageUri);
            Drawable drawable = Drawable.createFromStream(is, "");
            imageView.setImageDrawable(drawable);
        } catch (FileNotFoundException e) {
            //Toast.makeText(context,e.toString(),Toast.LENGTH_LONG).show();
        }//end try-catch
*/
        return row;
    }//end method getView

    public Managerial getManagerial(int position){
        return managerialList.get(position);
    }
}
