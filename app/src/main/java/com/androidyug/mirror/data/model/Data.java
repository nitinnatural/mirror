
package com.androidyug.mirror.data.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Data implements Serializable {

    private String sign;
    private String from_date;
    private String to_date;
    private String tagline;
    private String image_url;
    private String element;
    private String quality;
    private String ruling_planet;
    private String keyword;
    private List<Chapter> chapter = new ArrayList<Chapter>();


    public List<Chapter> getChapter() {
        return chapter;
    }

    public void setChapter(List<Chapter> chapter) {
        this.chapter = chapter;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    /**
     * 
     * @return
     *     The fromDate
     */
    public String getFromDate() {
        return from_date;
    }

    /**
     * 
     * @param fromDate
     *     The from_date
     */
    public void setFromDate(String fromDate) {
        this.from_date = fromDate;
    }

    /**
     * 
     * @return
     *     The toDate
     */
    public String getToDate() {
        return to_date;
    }

    /**
     * 
     * @param toDate
     *     The to_date
     */
    public void setToDate(String toDate) {
        this.to_date = toDate;
    }

    /**
     * 
     * @return
     *     The tagline
     */
    public String getTagline() {
        return tagline;
    }

    /**
     * 
     * @param tagline
     *     The tagline
     */
    public void setTagline(String tagline) {
        this.tagline = tagline;
    }

    /**
     * 
     * @return
     *     The imageUrl
     */
    public String getImageUrl() {
        return image_url;
    }

    /**
     * 
     * @param imageUrl
     *     The image_url
     */
    public void setImageUrl(String imageUrl) {
        this.image_url = imageUrl;
    }

    /**
     * 
     * @return
     *     The element
     */
    public String getElement() {
        return element;
    }

    /**
     * 
     * @param element
     *     The element
     */
    public void setElement(String element) {
        this.element = element;
    }

    /**
     * 
     * @return
     *     The quality
     */
    public String getQuality() {
        return quality;
    }

    /**
     * 
     * @param quality
     *     The quality
     */
    public void setQuality(String quality) {
        this.quality = quality;
    }

    /**
     * 
     * @return
     *     The rulingPlanet
     */
    public String getRulingPlanet() {
        return ruling_planet;
    }

    /**
     * 
     * @param rulingPlanet
     *     The ruling_planet
     */
    public void setRulingPlanet(String rulingPlanet) {
        this.ruling_planet = rulingPlanet;
    }

    /**
     * 
     * @return
     *     The keyword
     */
    public String getKeyword() {
        return keyword;
    }

    /**
     * 
     * @param keyword
     *     The keyword
     */
    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }



}
