package com.example.duas;

public class UvmsConnection {
    private String login;
    private String password;
    private String uvmsHost;
    private String uvmsPort;
    private String token;

    public UvmsConnection() {
        this.uvmsPort = "4184";
        this.login = "admin";
        this.token = "disconnected";
    }
    public String getLogin() {
        return login;
    }
    public void setLogin(String login) throws Exception  {
        if ( login != null && login.trim().length() != 0 ) {
            if ( !login.matches( "([a-zA-Z0-9_]+)" ) || login.trim().length() < 3 ) {
                throw new Exception( "Login name invalid (must contain letters, numbers and/or _ and be at least 3 characters long)" );
            }
        } else {
            throw new Exception( "Login name is mandatory" );
        }
        this.login = login.trim();
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public String getUvmsHost() {
        return uvmsHost;
    }
    public void setUvmsHost(String uvmsHost) throws Exception  {
        if ( uvmsHost != null && uvmsHost.trim().length() != 0 ) {
            if ( !uvmsHost.matches( "([a-zA-Z0-9_.]+)" ) || uvmsHost.trim().length() < 3 ) {
                throw new Exception( "UVMS hostname invalid (must contain letters|numbers|_|. and be at least 3 characters long)" );
            }
        } else {
            throw new Exception( "UVMS hostname is mandatory" );
        }
        this.uvmsHost = uvmsHost.trim();
    }

    public String getUvmsPort() {
        return uvmsPort;
    }
    public void setUvmsPort(String uvmsPort)  throws Exception {
        if ( uvmsPort != null && uvmsPort.trim().length() != 0 ) {
            if ( !uvmsPort.matches( "([0-9]+)" ) || uvmsPort.trim().length() < 4 || uvmsPort.length() > 5 ) {
                throw new Exception( "UVMS Port number invalid (must be a number between 1001 and 65535)" );
            }
        } else {
            throw new Exception( "UVMS Port number is mandatory" );
        }
        this.uvmsPort = uvmsPort.trim();
    }

    public void setToken(String token) {
        this.token = token;
    }
    public String getToken() {
        return token;
    }

    @Override
    public String toString() {
        return (this.getLogin()+":"+this.getPassword()+"@"+this.getUvmsHost()+":"+this.getUvmsPort()+" => '"+this.getToken()+"'");
    }
}
