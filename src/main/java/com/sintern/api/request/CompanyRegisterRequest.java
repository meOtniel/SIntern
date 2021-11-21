package com.sintern.api.request;

public class CompanyRegisterRequest {

    private String email;
    private String password;
    private String name;
    private String address;
    private String domain;

    public CompanyRegisterRequest() {}

    public CompanyRegisterRequest(String email, String password, String name, String address, String domain) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.address = address;
        this.domain = domain;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }
  
   public void setAddress(String address) {
        this.address = address;
    }
   
    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }
}
