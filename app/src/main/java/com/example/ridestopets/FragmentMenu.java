package com.example.ridestopets;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentMenu extends Fragment {

    public FragmentMenu() {
        // Required empty public constructor
    }

    private int id_user;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View rootview = inflater.inflate(R.layout.fragment_menu, container, false);

        Intent userLogin = getActivity().getIntent();

        id_user = userLogin.getIntExtra("id_user" , 0);

        try {
//            id_user =
//            Intent userLogin = getActivity().getIntent();
//
//            id_user = userLogin.getIntExtra("id_user" , 0);

        }catch(Exception e) {
//            Toast.makeText(getContext(), e.getMessage(), Toast.LENGTH_LONG).show();
        }

        return rootview;
    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        //inflate menu
        inflater.inflate(R.menu.menu, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
//        return super.onOptionsItemSelected(item);
        switch (item.getItemId()){

            case R.id.home:
                try {
                    Intent intent = new Intent(getContext(),HomeActivity.class);
                    intent.putExtra("id_user",id_user);
                    startActivity(intent);
                }catch(Exception e) {
                    Toast.makeText(getContext(), e.getMessage(), Toast.LENGTH_LONG).show();
                }

                return true;

            case R.id.perfil:
                try {
                    Intent viewPerfil = new Intent(getContext(),PerfilActivity.class);
                    viewPerfil.putExtra("id_user",id_user);
                    startActivity(viewPerfil);
                }catch(Exception e) {
                    Toast.makeText(getContext(), e.getMessage(), Toast.LENGTH_LONG).show();
                }

                return true;


            case R.id.cadpet:
                try {
                    Intent viewCadPet = new Intent(getContext(),CadPetsActivity.class);
                    viewCadPet.putExtra("id_user",id_user);
                    startActivity(viewCadPet);
                }catch(Exception e) {
                    Toast.makeText(getContext(), e.getMessage(), Toast.LENGTH_LONG).show();
                }

                return true;

            case R.id.sair:
                Intent exit = new Intent(getContext(),LoginActivity.class);
                startActivity(exit);
                return true;
        }

        return true;
    }
}
