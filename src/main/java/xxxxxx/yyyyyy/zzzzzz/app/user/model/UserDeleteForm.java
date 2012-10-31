package xxxxxx.yyyyyy.zzzzzz.app.user.model;

import java.io.Serializable;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class UserDeleteForm implements Serializable {
    /**
     * serial version uid.
     */
    private static final long serialVersionUID = 1L;

    @NotNull
    @Min(0)
    private Integer id;

    @NotNull
    @Min(0)
    private Integer version;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

}
