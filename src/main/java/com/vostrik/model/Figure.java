package com.vostrik.model;

import javax.json.Json;
import javax.json.JsonObject;
import java.io.StringWriter;

/**
 * User: User
 * Date: 06.02.17
 * Time: 17:46
 */
public class Figure {
    private JsonObject json;

    public Figure(JsonObject json) {
        this.json = json;
    }

    public JsonObject getJson() {
        return json;
    }

    public void setJson(JsonObject json) {
        this.json = json;
    }

    @Override
    public String toString() {
        StringWriter writer = new StringWriter();
        Json.createWriter(writer).write(json);
        return writer.toString();
    }
}