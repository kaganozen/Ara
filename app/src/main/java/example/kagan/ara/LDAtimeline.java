package example.kagan.ara;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kagan on 22.01.2016.
 */
public class LDAtimeline extends ArrayAdapter {
    List list = new ArrayList();

    public LDAtimeline(Context context, int resource) {
        super(context, resource);
    }

    static class LayoutHandler
    {

        TextView NAME,IDNAME,MESSAGE;
    }

    @Override
    public void add(Object object) {
        super.add(object);
        list.add(0,object);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View row = convertView;
        LayoutHandler layoutHandler;
        if(row == null)
        {
            LayoutInflater layoutInflater =(LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = layoutInflater.inflate(R.layout.actionbox,parent,false);
            layoutHandler = new LayoutHandler();
            layoutHandler.NAME =(TextView) row.findViewById(R.id.txt_name);
            layoutHandler.IDNAME =(TextView) row.findViewById(R.id.txt_idname);
            layoutHandler.MESSAGE =(TextView) row.findViewById(R.id.txt_message);


            row.setTag(layoutHandler);
        }
        else
        {
            layoutHandler = (LayoutHandler) row.getTag();

        }

        DPtimeline dataProvider = (DPtimeline)this.getItem(position);
        layoutHandler.NAME.setText(dataProvider.getName());
        layoutHandler.IDNAME.setText(dataProvider.getIdname());
        layoutHandler.MESSAGE.setText(dataProvider.getMessage());



        return row;
    }
}
