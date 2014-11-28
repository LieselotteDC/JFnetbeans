package Logica;

import java.sql.Date;

public class Review {

    private int reviewId;
    private double score;
    private String login;
    private int productId;
    private boolean status;
    private String beoordeling;
     private Date startdatum;

    public Review() {
        this.reviewId = 0;
        this.score = 0;
        this.login = null;
        this.productId = 0;
        this.status = true;
        this.beoordeling = null;
        this.startdatum=null;
    }

    public Review(int reviewId, double score, String login, int productId, boolean status, String beoordeling, Date startdatum) {
        this.reviewId = reviewId;
        this.score = score;
        this.login = login;
        this.productId = productId;
        this.status = status;
        this.beoordeling = beoordeling;
        this.startdatum=startdatum;
    }

    public Review(String login, int productId) {
        this.reviewId = 0;
        this.score = 0;
        this.login = login;
        this.productId = productId;
        this.status = true;
        this.beoordeling = null;
        this.startdatum=null;
    }

    public Review(int reviewId, double score, String beoordeling) {
        this.reviewId = reviewId;
        this.score = score;
        this.login = null;
        this.productId = 0;
        this.status = true;
        this.beoordeling = beoordeling;
        this.startdatum=null;
    }

    public Review(int reviewId, double score,int productId, String beoordeling) {
        this.reviewId = reviewId;
        this.score = score;
        this.login = null;
        this.productId = productId;
        this.status = true;
        this.beoordeling = beoordeling;
        this.startdatum=null;
    }

    public int getReviewId() {
        return reviewId;
    }

    public void setReviewId(int reviewId) {
        this.reviewId = reviewId;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public String getLogin() {
        return login;
    }

    public Date getStartdatum() {
        return startdatum;
    }

    public void setStartdatum(Date startdatum) {
        this.startdatum = startdatum;
    }

    
    public void setLogin(String login) {
        this.login = login;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getBeoordeling() {
        return beoordeling;
    }

    public void setBeoordeling(String beoordeling) {
        this.beoordeling = beoordeling;
    }

}
