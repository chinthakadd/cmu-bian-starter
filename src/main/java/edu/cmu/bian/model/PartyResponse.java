package edu.cmu.bian.model;

import java.util.List;

public class PartyResponse {

    private List<Party> content;

    public List<Party> getContent() {
        return content;
    }

    public void setContent(List<Party> content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "PartyResponse{" +
                "content=" + content +
                '}';
    }
}
