package com.kingstargroup.ecard.hibernate.termregister;



/**
 * AbstractTTifRegistration generated by MyEclipse - Hibernate Tools
 */

public abstract class AbstractTTifRegistration  implements java.io.Serializable {


    // Fields    

     private TTifRegistrationId id;
     private long deviceId;
     private String deviceName;
     private String txDate;
     private String txTime;
     private String comments;


    // Constructors

    /** default constructor */
    public AbstractTTifRegistration() {
    }

	/** minimal constructor */
    public AbstractTTifRegistration(TTifRegistrationId id) {
        this.id = id;
     
    }
    
    /** full constructor */
    public AbstractTTifRegistration(TTifRegistrationId id, long deviceId, String deviceName, String txDate, String txTime, String comments) {
        this.id = id;
        this.deviceId = deviceId;
        this.deviceName = deviceName;
        this.txDate = txDate;
        this.txTime = txTime;
        this.comments = comments;
    }
    

   
    // Property accessors

    public TTifRegistrationId getId() {
        return this.id;
    }
    
    public void setId(TTifRegistrationId id) {
        this.id = id;
    }

    public long getDeviceId() {
        return this.deviceId;
    }
    
    public void setDeviceId(long deviceId) {
        this.deviceId = deviceId;
    }

    public String getDeviceName() {
        return this.deviceName;
    }
    
    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public String getTxDate() {
        return this.txDate;
    }
    
    public void setTxDate(String txDate) {
        this.txDate = txDate;
    }

    public String getTxTime() {
        return this.txTime;
    }
    
    public void setTxTime(String txTime) {
        this.txTime = txTime;
    }

    public String getComments() {
        return this.comments;
    }
    
    public void setComments(String comments) {
        this.comments = comments;
    }
   








}