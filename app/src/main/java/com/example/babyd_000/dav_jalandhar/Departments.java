package com.example.babyd_000.dav_jalandhar;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class Departments extends Fragment implements View.OnClickListener{


    public Departments() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_departments, container, false);

        //Declarations.....
        TextView Biotech = (TextView)view.findViewById(R.id.Biotech);
        TextView Botany = (TextView)view.findViewById(R.id.Botany);
        TextView Chemistry = (TextView)view.findViewById(R.id.Chemistry);
        TextView Commerce = (TextView)view.findViewById(R.id.Commerce);
        TextView ComSc = (TextView)view.findViewById(R.id.ComSc);
        TextView Econimics = (TextView)view.findViewById(R.id.Economics);
        TextView English = (TextView)view.findViewById(R.id.English);
        TextView FoodSc = (TextView)view.findViewById(R.id.FoodSc);
        TextView Geography = (TextView)view.findViewById(R.id.Geography);
        TextView Hindi = (TextView)view.findViewById(R.id.Hindi);
        TextView History = (TextView)view.findViewById(R.id.HIstory);
        TextView Math = (TextView)view.findViewById(R.id.Math);
        TextView Music = (TextView)view.findViewById(R.id.Music);
        TextView Physics = (TextView)view.findViewById(R.id.Physics);
        TextView Philosophy = (TextView)view.findViewById(R.id.Philosophy);
        TextView PoliSc = (TextView)view.findViewById(R.id.PoliSc);
        TextView Punjabi = (TextView)view.findViewById(R.id.Punjabi);
        TextView PhyEdu = (TextView)view.findViewById(R.id.PhyEdu);
        TextView Sanskrit = (TextView)view.findViewById(R.id.Sanskrit);
        TextView Zoology = (TextView)view.findViewById(R.id.Zoology);

        //Initialising OnCllickListeners
        view.findViewById(R.id.TRBiotech).setOnClickListener(this);
        view.findViewById(R.id.TRBotany).setOnClickListener(this);
        view.findViewById(R.id.TRChemistry).setOnClickListener(this);
        view.findViewById(R.id.TRCommerce).setOnClickListener(this);
        view.findViewById(R.id.TRComSc).setOnClickListener(this);
        view.findViewById(R.id.TREconomics).setOnClickListener(this);
        view.findViewById(R.id.TREnglish).setOnClickListener(this);
        view.findViewById(R.id.TRFoodSc).setOnClickListener(this);
        view.findViewById(R.id.TRGeography).setOnClickListener(this);
        view.findViewById(R.id.TRHindi).setOnClickListener(this);
        view.findViewById(R.id.TRHistory).setOnClickListener(this);
        view.findViewById(R.id.TRMath).setOnClickListener(this);
        view.findViewById(R.id.TRMusic).setOnClickListener(this);
        view.findViewById(R.id.TRPhysics).setOnClickListener(this);
        view.findViewById(R.id.TRPhilosophy).setOnClickListener(this);
        view.findViewById(R.id.TRPoliSc).setOnClickListener(this);
        view.findViewById(R.id.TRPunjabi).setOnClickListener(this);
        view.findViewById(R.id.TRPhyEdu).setOnClickListener(this);
        view.findViewById(R.id.TRSanskrit).setOnClickListener(this);
        view.findViewById(R.id.TRZoology).setOnClickListener(this);

        //Setting Texts
        Biotech.setText(Html.fromHtml("<b><h4><font color='#000000'>BIO-TECHNOLOGY<br></font></h4><h6><font color='#808080'>*B.Sc. &nbsp;(Bio-Technology)<br>&nbsp;(6Semesters)</font></h6></b>"));
        Botany.setText(Html.fromHtml("<b><h4><font color='#000000'>BOTANY<br></font></h4><h6><font color='#808080'>*B.Sc.&nbsp;(Medical)</font></h6></b>"));
        Commerce.setText(Html.fromHtml("<b><h4><font color='#000000'>COMMERCE<br></font></h4><h6><font color='#808080'>*B.Sc.&nbsp;(Chemistry)&nbsp;(4 Semesters)</font></h6></b>"));
        Chemistry.setText(Html.fromHtml("<b><h4><font color='#000000'>CHEMISTRY&nbsp;SCIENCE<br></font></h4><h6><font color='#808080'>*BCA&nbsp;(6 Semesters)<br>*B.Sc.&nbsp;(6 Semesters)<br>*M.Sc.&nbsp;(4 Semesters)</font></h6></b>"));
        ComSc.setText(Html.fromHtml("<b><h4><font color='#000000'>COMPUTER&nbsp;SCIENCE<br></font></h4><h6><font color='#808080'>*BCA&nbsp;(6 Semesters)<br>*B.Sc.&nbsp;(6 Semesters)<br>*M.Sc.&nbsp;(4 Semesters)</font></h6></b>"));
        Econimics.setText(Html.fromHtml("<b><h4><font color='#000000'>ECONOMICS<br></font></h4><h6><font color='#808080'>*B.Sc.&nbsp;(Economics)(6 Semesters)<br>*BA&nbsp;(Hons.)&nbsp;(4 Semesters)<br>*M.A.(Economics)&nbsp;(4 Semesters)</font></h6></b>"));
        English.setText(Html.fromHtml("<b><h4><font color='#000000'>ENGLISH<br></font></h4><h6><font color='#808080'>*English&nbsp;(Hons.)(6 Semesters)<br>*BA&nbsp;(Hons.)&nbsp;(4 Semesters)<br>*M.A.(English)&nbsp;(4 Semesters)</font></h6></b>"));
        FoodSc.setText(Html.fromHtml("<b><h4><font color='#000000'>FOOD&nbsp;SCIENCE<br></font></h4><h6><font color='#808080'>*Add&nbsp;on&nbsp;Courses<br>*Bachelor&nbsp;of&nbsp;FS&nbsp;(8 Semesters)</font></h6></b>"));
        Geography.setText(Html.fromHtml("<b><h4><font color='#000000'>Geography<br></font></h4><h6><font color='#808080'>*Geography&nbsp;(Honors)</font></h6></b>"));
        Hindi.setText(Html.fromHtml("<b><h4><font color='#000000'>HINDI<br></font></h4><h6><font color='#808080'>*M.A.&nbsp;(Hindi)&nbsp;(4 Semesters)</font></h6></b>"));
        History.setText(Html.fromHtml("<b><h4><font color='#000000'>HISTORY<br></font></h4><h6><font color='#808080'>*History&nbsp;(Hons.)<br>*M.A.&nbsp;(Hindi)(4 Semesters)</font></h6></b>"));
        Math.setText(Html.fromHtml("<b><h4><font color='#000000'>MATHEMATICS<br></font></h4><h6><font color='#808080'>*M.Sc.&nbsp;(Mathematics)<br>&nbsp;(4 Semesters)</font></h6></b>"));
        Physics.setText(Html.fromHtml("<b><h4><font color='#000000'>PHYSICS<br></font></h4><h6><font color='#808080'>*M.Sc.&nbsp;(Physics)&nbsp;(4 Semesters)</font></h6></b>"));
        Philosophy.setText(Html.fromHtml("<b><h4><font color='#000000'>PHILOSOPHY<br></font></h4><h6><font color='#808080'>*As&nbsp;an&nbsp;Optional&nbsp;Subject</font></h6></b>"));
        Music.setText(Html.fromHtml("<b><h4><font color='#000000'>MUSIC<br></font></h4><h6><font color='#808080'>*As&nbsp;an&nbsp;Optional&nbsp;Subject</font></h6></b>"));
        PoliSc.setText(Html.fromHtml("<b><h4><font color='#000000'>POLITICAL SCIENCE<br></font></h4><h6><font color='#808080'>*Political&nbsp;Sc.&nbsp;(Hons.)<br>*M.A.(Political Sc.)</font></h6></b>"));
        Punjabi.setText(Html.fromHtml("<b><h4><font color='#000000'>PUNJABI<br></font></h4><h6><font color='#808080'>*M.A.&nbsp;(Punjabi)&nbsp;(4 Semesters)</font></h6></b>"));
        PhyEdu.setText(Html.fromHtml("<b><h4><font color='#000000'>PHYSICAL&nbsp;EDUCATION<br></font></h4><h6><font color='#808080'>*As&nbsp;an&nbsp;Optional&nbsp;Subject</font></h6></b>"));
        Sanskrit.setText(Html.fromHtml("<b><h4><font color='#000000'>SANSKRIT<br></font></h4><h6><font color='#808080'>*M.A.&nbsp;(Sanskrit)&nbsp;(4 Semesters)</font></h6></b>"));
        Zoology.setText(Html.fromHtml("<b><h4><font color='#000000'>ZOOLOGY<br></font></h4><h6><font color='#808080'>*M.Sc.&nbsp;(Zoology)&nbsp;(4 Semesters)</font></h6></b>"));

        return view;
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.TRBiotech)
        {
            Uri uri = Uri.parse("http://davjalandhar.com/index.php/departments/bio-technology");
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);
        }
        else if (v.getId() == R.id.TRBotany)
        {
            Uri uri = Uri.parse("http://davjalandhar.com/index.php/departments/botany");
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);
        }
        else if (v.getId() == R.id.TRChemistry)
        {
            Uri uri = Uri.parse("http://davjalandhar.com/index.php/departments/chemistry");
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);
        }
        else if (v.getId() == R.id.TRCommerce)
        {
            Uri uri = Uri.parse("http://davjalandhar.com/index.php/departments/commerce");
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);
        }
        else if (v.getId() == R.id.TRComSc)
        {
            Uri uri = Uri.parse("http://davjalandhar.com/index.php/departments/computer-science");
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);
        }
        else if (v.getId() == R.id.TREconomics)
        {
            Uri uri = Uri.parse("http://davjalandhar.com/index.php/departments/economics");
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);
        }
        else if (v.getId() == R.id.TREnglish)
        {
            Uri uri = Uri.parse("http://davjalandhar.com/index.php/departments/english");
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);
        }
        else if (v.getId() == R.id.TRFoodSc)
        {
            Uri uri = Uri.parse("http://davjalandhar.com/index.php/departments/foodscienceandtech");
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);
        }
        else if (v.getId() == R.id.TRGeography)
        {
            Uri uri = Uri.parse("http://davjalandhar.com/index.php/departments/geography");
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);
        }
        else if (v.getId() == R.id.TRHindi)
        {
            Uri uri = Uri.parse("http://davjalandhar.com/index.php/departments/hindi");
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);
        }
        else if (v.getId() == R.id.TRHistory)
        {
            Uri uri = Uri.parse("http://davjalandhar.com/index.php/departments/history");
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);
        }
        else if (v.getId() == R.id.TRMath)
        {
            Uri uri = Uri.parse("http://davjalandhar.com/index.php/departments/mathematics");
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);
        }
        else if (v.getId() == R.id.TRMusic)
        {
            Uri uri = Uri.parse("http://davjalandhar.com/index.php/departments/music");
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);
        }
        else if (v.getId() == R.id.TRPhysics)
        {
            Uri uri = Uri.parse("http://davjalandhar.com/index.php/departments/physics");
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);
        }
        else if (v.getId() == R.id.TRPhilosophy)
        {
            Uri uri = Uri.parse("http://davjalandhar.com/index.php/departments/philosophy");
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);
        }
        else if (v.getId() == R.id.TRPoliSc)
        {
            Uri uri = Uri.parse("http://davjalandhar.com/index.php/departments/polotical-science");
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);
        }
        else if (v.getId() == R.id.TRPunjabi)
        {
            Uri uri = Uri.parse("http://davjalandhar.com/index.php/departments/punjabi");
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);
        }
        else if (v.getId() == R.id.TRPhyEdu)
        {
            Uri uri = Uri.parse("http://davjalandhar.com/index.php/departments/sports");
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);
        }
        else if (v.getId() == R.id.TRSanskrit)
        {
            Uri uri = Uri.parse("http://davjalandhar.com/index.php/departments/sanskrit");
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);
        }
        else if (v.getId() == R.id.TRZoology)
        {
            Uri uri = Uri.parse("http://davjalandhar.com/index.php/departments/zoology");
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);
        }
    }
}
