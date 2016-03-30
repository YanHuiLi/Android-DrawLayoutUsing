package android.archer.com.drawlayoutusing;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Archer on 2016/3/25.
 */
public class ContentFragment extends Fragment{

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

       View view=inflater.inflate(R.layout.fragment_content,container,false);
        //获取View的实例化
        TextView textView = (TextView) view.findViewById(R.id.TextView);


        String text=getArguments().getString("text");
        textView.setText(text);
        return view;
    }
}
