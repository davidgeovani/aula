package br.com.david_fabio.pics_search.model;

import com.google.gson.annotations.SerializedName;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Perfil {

    // SerializedName: nome que o campo vai receber no json



    @SerializedName("id")
    @Expose
    private int id = 0;

    @SerializedName("name")
    @Expose
    private String name = "";

    @SerializedName("email")
    @Expose
    private String email = "";
    @SerializedName("cep")
    @Expose
    private String cep = "";




    /**
     * No args constructor for use in serialization
     */
    public Perfil() {
    }

    /**


     * @param email

     * @param name
     */


    public Perfil( String name, String email, String cep) {

        super();
        this.id = id;
        this.name = name;
        this.email = email;
        this.cep = cep;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return name;
    }

    public void setNome(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }


}
