package com.example.michus.vidas;

import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import static android.R.attr.fragment;
import static android.R.attr.id;
import static com.example.michus.vidas.R.id.content_vidas;


/**
 * A placeholder fragment containing a simple view.
 */
public class VidasFragment extends Fragment {

    private Button vida1Mas;
    private Button vida1Menos;
    private Button veneno1Mas;
    private Button veneno1Menos;
    private Button robaA2;

    private Button vida2Mas;
    private Button vida2Menos;
    private Button veneno2Mas;
    private Button veneno2Menos;
    private Button robaA1;


    private TextView pantalla1,pantalla2;
    int vida=20;
    int veneno=0;
    int vida2=20;
    int veneno2=0;



    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.menu_vidas,menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == R.id.action_settings) {
            reset();
            Snackbar.make(getView(), "nueva partida", Snackbar.LENGTH_LONG).show();

        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_vidas, container, false);

        //USUARIO1
        pantalla1 = (TextView) view.findViewById(R.id.TvPantalla1);
        vida1Mas = (Button)  view.findViewById(R.id.BtVida1Mas);
        vida1Menos= (Button) view.findViewById((R.id.BtVida1Menos));
        veneno1Mas=(Button) view.findViewById(R.id.BtVeneno1Mas);
        veneno1Menos=(Button) view.findViewById(R.id.BtVeneno1Menos);
        robaA2=(Button) view.findViewById(R.id.BtRobaA2);

        //USUARIO2

        pantalla2 = (TextView) view.findViewById(R.id.TvPantalla2);
        vida2Mas = (Button)  view.findViewById(R.id.BtVida2Mas);
        vida2Menos= (Button) view.findViewById((R.id.BtVida2Menos));
        veneno2Mas=(Button) view.findViewById(R.id.BtVeneno2Mas);
        veneno2Menos=(Button) view.findViewById(R.id.BtVeneno2Menos);
        robaA1=(Button) view.findViewById(R.id.BtRobaA1);



        //USUARIO 1
        pantalla1.setText(vida+"/"+veneno);

        robaA2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                vida2--;
                vida++;
                pantalla2.setText(vida2+"/"+veneno2);
                pantalla1.setText(vida+"/"+veneno);

            }
        });


        vida1Mas.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                    vida++;
                    pantalla1.setText(vida+"/"+veneno);

            }
        });

        vida1Menos.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                vida--;
                pantalla1.setText(vida+"/"+veneno);

            }
        });

        veneno1Mas.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if (veneno<10){
                    veneno++;
                    pantalla1.setText(vida+"/"+veneno);
                }
                if (veneno==10)Snackbar.make(getView(),"Te han envenenado ya no puedes continuar",Snackbar.LENGTH_LONG).show();
            }
        });

        veneno1Menos.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if (veneno>0){
                    veneno--;
                    pantalla1.setText(vida+"/"+veneno);
                }
            }
        });

        //USUARIO2
        pantalla2.setText(vida2+"/"+veneno2);

        robaA1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                vida--;
                vida2++;
                pantalla1.setText(vida+"/"+veneno);
                pantalla2.setText(vida2+"/"+veneno2);

            }
        });
        vida2Mas.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                vida2++;
                pantalla2.setText(vida2+"/"+veneno2);

            }
        });

        vida2Menos.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                vida2--;
                pantalla2.setText(vida2+"/"+veneno2);

            }
        });

        veneno2Mas.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if (veneno2<10){
                    veneno2++;
                    pantalla2.setText(vida2+"/"+veneno2);
                }
                if (veneno2==10)Snackbar.make(getView(),"Te han envenenado ya no puedes continuar",Snackbar.LENGTH_LONG).show();
            }
        });

        veneno2Menos.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if (veneno2>0){
                    veneno2--;
                    pantalla2.setText(vida2+"/"+veneno2);
                }
            }
        });



        return view;
    }
    public void reset() {
        vida=20;
        vida2=20;
        veneno=0;
        veneno2=0;
        pantalla1.setText(vida+"/"+veneno);
        pantalla2.setText(vida2+"/"+veneno2);
    }
}