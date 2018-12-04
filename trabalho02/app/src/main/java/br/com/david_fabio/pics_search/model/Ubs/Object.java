package br.com.david_fabio.pics_search.model.Ubs;


import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import br.com.david_fabio.pics_search.model.Pic.Pics;
import br.com.david_fabio.pics_search.model.Ubs.Example;
import br.com.david_fabio.pics_search.model.Ubs.Ubs;

public class Object extends Example {

    @SerializedName("next")
    @Expose
    private Integer next;
    @SerializedName("array")
    @Expose
    private List<Ubs> array = null;



    public Integer getNext() {
        return next;
    }

    public void setNext(Integer next) {
        this.next = next;
    }

    public List<Ubs> getArray() {
        return array;
    }

    public void setArray(List<Ubs> array) {
        this.array = array;
    }



}
