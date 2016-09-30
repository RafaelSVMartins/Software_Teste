package br.com.livroandroid.carrosteste3.Activitys.domain;

import java.io.Serializable;

/**
 * Created by Rrafael on 27/09/2016.
 */
public class Carro implements Serializable {

    public Long id;
    public String tipo;
    public String nome;
    public String desc;
    public String urlFoto;
    public String urlInfo;
    public String urlVideo;
    public String latitude;
    public String longitude;

    @Override
    public String toString() {
        return "Carro{" +
                "nome='" + nome + '\'' +
                '}';
    }
}
