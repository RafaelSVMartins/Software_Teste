package br.com.livroandroid.carrosteste3.Activitys.Fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import br.com.livroandroid.carrosteste3.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class CarroFragment extends Fragment {

    private int tipo;
    public CarroFragment() {
        // Required empty public constructor
    }

    public static CarroFragment newInstance(int tipo) {
        Bundle b = new Bundle();
        b.putInt("tipo",tipo);
        CarroFragment f = new CarroFragment();
        f.setArguments(b);
        return f;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            this.tipo = getArguments().getInt("tipo");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_carro, container, false);
        TextView text = (TextView) view.findViewById(R.id.text2);
        text.setText("Carros" + getString(tipo));
        return view;
    }

}
