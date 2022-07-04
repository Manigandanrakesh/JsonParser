package com.json.mapping.module;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

import java.util.List;
import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonRootName("children")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ParentSiblingChild<T extends SiblingChild> {
    @JsonProperty(value = "text")
    private String text;
    @JsonProperty(value = "periodGroupId")
    private String periodGroupId;
    @JsonProperty(value = "periodGroup")
    private String periodGroup;
    private SiblingChild siblingChild;
    @JsonProperty(value = "children")
    private List<ParentSiblingChild<SiblingChild>> parentSiblingChildren;
    @JsonProperty(value = "siblingCount")
    private int siblingCount;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getPeriodGroupId() {
        return periodGroupId;
    }

    public void setPeriodGroupId(String periodGroupId) {
        this.periodGroupId = periodGroupId;
    }

    public String getPeriodGroup() {
        return periodGroup;
    }

    public void setPeriodGroup(String periodGroup) {
        this.periodGroup = periodGroup;
    }


    public SiblingChild getSiblingChild() {
        return siblingChild;
    }

    public void setSiblingChild(SiblingChild siblingChild) {
        this.siblingChild = siblingChild;
    }

    public List<ParentSiblingChild<SiblingChild>> getParentSiblingChildren() {
        return parentSiblingChildren;
    }

    public void setParentSiblingChildren(List<ParentSiblingChild<SiblingChild>> parentSiblingChildren) {
        this.parentSiblingChildren = parentSiblingChildren;
    }

    public int getSiblingCount() {
        return Objects.isNull(parentSiblingChildren) ? 0: parentSiblingChildren.size();
    }
}
