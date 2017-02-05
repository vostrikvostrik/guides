package com.vostrik.db.beans.item;

/**
 * User: User
 * Date: 27.12.16
 * Time: 15:30
 */
public class TagItem {
    String text;
    Long weight;
    String link;

    public TagItem(String text, Long weight, String link) {
        this.text = text;
        this.weight = weight;
        this.link = link;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Long getWeight() {
        return weight;
    }

    public void setWeight(Long weight) {
        this.weight = weight;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

}
