package com.lipek.serializable;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlAccessType;

@XmlRootElement(name = "logins")
@XmlAccessorType(XmlAccessType.FIELD)
public class LoginList 
{
    @XmlElement(name = "login")
    private List<Login> logins = null;
 
    public List<Login> getLogins() {
        return logins;
    }
 
    public void setLogins(List<Login> logins) {
        this.logins = logins;
    }
}
