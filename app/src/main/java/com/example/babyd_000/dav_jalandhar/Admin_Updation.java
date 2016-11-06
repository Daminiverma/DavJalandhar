package com.example.babyd_000.dav_jalandhar;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;


/**
 * A simple {@link Fragment} subclass.
 */
public class Admin_Updation extends Fragment implements View.OnClickListener{
    Context ctx;
    Spinner spin;
    Button BtnUpdate;
    SharedPreferences.Editor editor;
    SharedPreferences pref;
    EditText  UpDesc;
    EditText UpTitle;
    String type,tab,type1="updt",tit1;
    String marquee[];
    public Admin_Updation() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.admin__updation, container, false);
        ctx = inflater.getContext();

        pref = PreferenceManager.getDefaultSharedPreferences(ctx);
        editor = pref.edit();
        BtnUpdate = (Button)view.findViewById(R.id.BtnUpdate);

        view.findViewById(R.id.URBPR).setOnClickListener(this);
        view.findViewById(R.id.URBNB).setOnClickListener(this);
        view.findViewById(R.id.URBPN).setOnClickListener(this);
        view.findViewById(R.id.URBW).setOnClickListener(this);
        view.findViewById(R.id.URBM).setOnClickListener(this);

        UpTitle = (EditText) view.findViewById(R.id.UpTitle);
        UpDesc = (EditText) view.findViewById(R.id.UpDesc);

        BtnUpdate.setEnabled(false);
        UpTitle.setEnabled(false);
        UpDesc.setEnabled(false);

        spin = (Spinner) view.findViewById(R.id.SelectedTitle);
        spin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                BtnUpdate.setEnabled(true);
                if (type.equals("Marquee")) {
                    UpTitle.setText((parent.getSelectedItem().toString()).replace("*** ", "").replace(" ***", ""));
                    for (int i = 0; i < 4; i++) {
                        if (parent.getSelectedItem().toString().equals(marquee[i])) {
                            UpDesc.setText(marquee[i + 1]);
                        }
                    }

                } else {
                    UpTitle.setText((parent.getSelectedItem().toString()).replace("*  ", ""));
                    String title = parent.getSelectedItem().toString();
                    title = title.replace("*  ", "");
                    String tempresult = null;
                    try {
                        tempresult = new Background1(ctx).execute(type, title).get();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (ExecutionException e) {
                        e.printStackTrace();
                    }
                    String result[] = tempresult.split("<!--");
                    UpDesc.setText(result[0]);
                }
                tit1 = UpTitle.getText().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        BtnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tit2 = UpTitle.getText().toString();
                String desc = UpDesc.getText().toString();
                Toast.makeText(ctx, "type= "+type1+"table= "+tab+"Title 1= "+tit1+"Title 2= "+tit2+"Desc= "+desc, Toast.LENGTH_SHORT).show();
                String result = null;
                try {
                    result = new BackgroundAdmin(ctx).execute(type1, tab, tit1, tit2, desc).get();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
                Toast.makeText(ctx, "" + result, Toast.LENGTH_SHORT).show();
            }
        });


        return view;
    }

    @Override
    public void onClick(View v) {
        //String res[] = new String[10];
        List<String> list = new ArrayList<String>();
        if (v.getId() == R.id.URBPR)
        {
            type= "Releases";
            tab="releases";
            String temp1 = pref.getString("PressReleases", "nil");
            String temp[] = temp1.split("<br><br>");
            for (int i=0; i<=5; i++)
            {
                list.add(temp[i]);
            }
        }
        else if (v.getId()== R.id.URBNB)
        {
            type= "Notice";
            tab="notice";
            String temp1 = pref.getString("NoticeBoard", "nil");
            String temp[] = temp1.split("<br><br>");
            for (int i=0; i<=5; i++)
            {
                list.add(temp[i]);
            }
        }
        else if (v.getId()== R.id.URBPN)
        {
            type="Placements";
            tab="placement";
            String temp1 = pref.getString("Placements", "nil");
            String temp[] = temp1.split("<br><br>");
            for (int i=0; i<5; i++)
            {
                list.add(temp[i]);
            }
        }
        else if (v.getId()== R.id.URBW)
        {
            type="Workshop";
            tab="workshop";
            String temp1 = pref.getString("Workshop", "nil");
            String temp[] = temp1.split("<br><br>");
            for (int i=0; i<5; i++)
            {
                list.add(temp[i]);
            }
        }
        else if (v.getId()== R.id.URBM)
        {
            type = "Marquee";
            tab="marquee";
            String temp = pref.getString("Marquee", "Please Refresh..<br>.<br>.<br>.<br>");
            marquee = temp.split("<br>");
            for (int i=0; i<4; i++)
            {
                if (i%2==0)
                {
                    list.add(marquee[i]);
                }
            }
        }
        UpDesc.setEnabled(true);
        UpTitle.setEnabled(true);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(ctx, android.R.layout.simple_spinner_item, list);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(adapter);

    }
}