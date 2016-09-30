package br.com.livroandroid.carrosteste3.Activitys.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.List;

import br.com.livroandroid.carrosteste3.Activitys.adapter.CarroAdapter;
import br.com.livroandroid.carrosteste3.Activitys.domain.Carro;
import br.com.livroandroid.carrosteste3.Activitys.domain.CarroService;
import br.com.livroandroid.carrosteste3.R;

/**
 * Created by Rrafael on 27/09/2016.
 */
public class CarrosFragments extends BaseFragment {

        private String tipo;
        protected RecyclerView recyclerView;
        private List<Carro> carros;

    public static CarrosFragments newInstance(String tipo) {
        Bundle args = new Bundle();
        args.putString("tipo",tipo);
        CarrosFragments f = new CarrosFragments();
        f.setArguments(args);
        return f;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            this.tipo = getArguments().getString("tipo");
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_carros,container,false);
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setHasFixedSize(true);
        view.findViewById(R.id.fab).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(),recyclerView + "Exemplo de FAB button. ", Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        taskCarros();
    }

    private void taskCarros() {
        this.carros = CarroService.geCarros(getContext(),this.tipo);
        recyclerView.setAdapter(new CarroAdapter(carros, getContext(),onClickCarro()));
    }

    private CarroAdapter.CarroOnClickListener onClickCarro() {
        return new CarroAdapter.CarroOnClickListener() {

            @Override
            public void onClickCarro(View view, int idx) {
                Carro c =carros.get(idx);
                Toast.makeText(getContext(),"Nome do Carro: " + c.nome,Toast.LENGTH_SHORT).show();
            }
        };
    }
}
