package android.archer.com.drawlayoutusing;

import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;



public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {


    private DrawerLayout mDrawerLayout;
    private ListView mDrawerList;
    private ArrayList<String> menuLists;
    private  String mTitle;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTitle= (String) getTitle();

        mDrawerLayout= (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerList= (ListView) findViewById(R.id.Left_drawer);
        menuLists=new ArrayList<>();
        for (int i=0;i<5;i++){
            menuLists.add("Button" + i);

            ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, menuLists);
            mDrawerList.setAdapter(adapter);
            mDrawerList.setOnItemClickListener(this);
            /**

            ActionBarDrawerToggle drawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.drawable.ic_drawer, R.string.drawer_open, R.string.drawer_close)
            {

                @Override
                public void onDrawerOpened(View drawerView) {
                    super.onDrawerOpened(drawerView);


                    getActionBar().setTitle(R.string.choose);
                }


                @Override
                public void onDrawerClosed(View drawerView) {
                    super.onDrawerClosed(drawerView);
                    getActionBar().setTitle(mTitle);
                }
            };

            mDrawerLayout.setDrawerListener(drawerToggle);
             */

        }



    }





    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        //每当点击一个按钮时，动态插入一个fragment到视图中。
        Fragment contentFragment =new ContentFragment();
        Bundle args=new Bundle();
        args.putString("text", menuLists.get(position));
        contentFragment.setArguments(args);


        FragmentManager fm=getFragmentManager();
        fm.beginTransaction().replace(R.id.content_frame,contentFragment).commit();

        mDrawerLayout.closeDrawer(mDrawerList);
    }
}
