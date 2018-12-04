package br.com.david_fabio.pics_search.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Distrito {

    // SerializedName: nome que o campo vai receber no json



    @SerializedName("idDist")
    @Expose
    private int idDist = 0;

    @SerializedName("name")
    @Expose
    private String name = "";





    /**
     * No args constructor for use in serialization
     */
    public Distrito() {
    }

    /**



     @param idDist
     * @param name
     */


    public Distrito(String name, int idDist) {

        super();
        this.idDist = idDist;
        this.name = name;

    }

    public int getIdDist() {
        return idDist;
    }

    public void setId(int idDist) {
        this.idDist = idDist;
    }

    public String getNome() {
        return name;
    }

    public void setNome(String name) {
        this.name = name;
    }


}
