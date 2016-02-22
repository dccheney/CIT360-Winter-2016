package acp;

import java.io.Serializable;

/**
 * Created by ke7mzp on 2/10/2016.
 */
public class Login implements Serializable {
    private String uName;
    private String password;

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
