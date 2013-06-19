package xxxxxx.yyyyyy.zzzzzz.app.user;

import java.io.Serializable;

import javax.validation.constraints.Size;

import javax.validation.constraints.NotNull;

public class UserSearchForm implements Serializable {

    /**
     * serial version uid.
     */
    private static final long serialVersionUID = 1L;

    @NotNull
    @Size(min = 0)
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
