package br.com.david_fabio.pics_search.model.Pic;

import java.lang.reflect.Array;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Object extends Example{

    @SerializedName("next")
    @Expose
    private Integer next;
    @SerializedName("array")
    @Expose
    private List<Pics> array = null;





    public Integer getNext() {
        return next;
    }

    public void setNext(Integer next) {
        this.next = next;
    }

    public List<Pics> getArrayM() {
        return array;
    }

    public void setArrayM(List<Pics> array) {
        this.array = array;
    }
}
