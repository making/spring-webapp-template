package xxxxxx.yyyyyy.zzzzzz.app.user;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.springframework.format.annotation.DateTimeFormat;

public class UserForm implements Serializable {
    /**
     * Validation group for create user
     */
    public static interface UserCreateGroup {
    }

    /**
     * Validation group for update user
     */
    public static interface UserUpdateGroup {
    }

    /**
     * Validation group for delete user
     */
    public static interface UserDeleteGroup {
    }

    /**
     * serial version uid.
     */
    private static final long serialVersionUID = 1L;

    @Null(groups = { UserCreateGroup.class })
    @NotNull(groups = { UserUpdateGroup.class, UserDeleteGroup.class })
    @Min(0)
    private Integer id;

    @Null(groups = { UserDeleteGroup.class })
    @NotNull(groups = { UserUpdateGroup.class, UserCreateGroup.class })
    @Size(min = 1, max = 20)
    private String name;

    @Null(groups = { UserDeleteGroup.class })
    @NotNull(groups = { UserUpdateGroup.class, UserCreateGroup.class })
    @Size(min = 1, max = 50)
    @Email
    private String email;

    @Null(groups = { UserDeleteGroup.class })
    @NotNull(groups = { UserUpdateGroup.class, UserCreateGroup.class })
    @Past
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birth;

    @Null(groups = { UserDeleteGroup.class })
    @NotNull(groups = { UserUpdateGroup.class, UserCreateGroup.class })
    @Size(min = 6, max = 30)
    private String password;

    @Null(groups = { UserDeleteGroup.class })
    @NotNull(groups = { UserUpdateGroup.class, UserCreateGroup.class })
    @Size(min = 6, max = 30)
    private String confirmPassword;

    @Null(groups = { UserCreateGroup.class })
    @NotNull(groups = { UserUpdateGroup.class, UserDeleteGroup.class })
    @Min(0)
    private Integer version;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

}
