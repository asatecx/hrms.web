package af.base.model;

/*
 * HTTP Request クライアント情報
 */
public class ClientInformation {
    
    /**
     * クライアントID取得用Cook
     */
    public static final String CLIENTID_COOKIE_NAME = "PF_CLIENT_ID" ;
    
    /**
     * クライアントIP
     */
    private String clientIP ;

    /**
     * クライアントID（クライアント識別ID、Cookieに保存、初回アクセス時設定）
     */
    private String clientID ;
    
    private boolean newFlag = true ;

    private String userID ;
    
    /**
     * クライアントIP取得 
     * @return
     */
    public String getClientIP() {
        return clientIP;
    }

    /**
     * 
     * @param clientIP
     */
    public void setClientIP(String clientIP) {
        this.clientIP = clientIP;
    }

    /**
     * クライアントID取得
     * @return
     */
    public String getClientID() {
        return clientID;
    }

    public void setClientID(String clientID) {
        this.clientID = clientID;
    }

    /**
     * ユーザーID
     * @return
     */
    public String getUserID() {     return userID;     }

    public void setUserID(String userID) {  this.userID = userID; }

    public boolean isNew() {
        return this.newFlag;
    }

    public void setNew(boolean isNew) {
        this.newFlag = isNew;
    }

}
