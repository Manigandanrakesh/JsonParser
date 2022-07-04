package com.json.mapping.module;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

import java.util.List;
import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonRootName("root")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ParentRoot {
    @JsonProperty(value = "text")
    private String text;
    @JsonProperty(value = "children")
    private List<ParentSiblingChild<SiblingChild>> siblingChild;
    @JsonProperty(value = "siblingCount")
    private int siblingCount;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<ParentSiblingChild<SiblingChild>> getSiblingChild() {
        return siblingChild;
    }

    public void setSiblingChild(List<ParentSiblingChild<SiblingChild>> siblingChild) {
        this.siblingChild = siblingChild;
    }

    public int getSiblingCount() {
        return Objects.isNull(siblingChild) ? 0: siblingChild.size();
    }
}
