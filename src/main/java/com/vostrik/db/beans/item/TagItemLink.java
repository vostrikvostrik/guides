package com.vostrik.db.beans.item;

/**
 * User: User
 * Date: 01.01.17
 * Time: 12:15
 */
public class TagItemLink {
    String tagName;
    String tagLink;
    String tagDescr;
    String tagType;

    public TagItemLink(String tagName, String tagLink, String tagDescr, String tagType) {
        this.tagName = tagName;
        this.tagLink = tagLink;
        this.tagDescr = tagDescr;
        this.tagType = tagType;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    public String getTagLink() {
        return tagLink;
    }

    public void setTagLink(String tagLink) {
        this.tagLink = tagLink;
    }

    public String getTagDescr() {
        return tagDescr;
    }

    public void setTagDescr(String tagDescr) {
        this.tagDescr = tagDescr;
    }

    public String getTagType() {
        return tagType;
    }

    public void setTagType(String tagType) {
        this.tagType = tagType;
    }
}
