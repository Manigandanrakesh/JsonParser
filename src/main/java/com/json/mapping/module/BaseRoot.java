package com.json.mapping.module;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Objects;
import java.util.Queue;

@JsonRootName("GetPeriodGroupRes")
public class BaseRoot {
    @JsonProperty(value = "root")
    private ParentRoot parentRoot;
    @JsonProperty(value = "serviceStatus")
    private BaseRootSiblings baseRootSiblings;

    @JsonProperty(value = "totalCount")
    private int totalCount;

    public ParentRoot getParentRoot() {
        return parentRoot;
    }

    public void setParentRoot(ParentRoot parentRoot) {
        this.parentRoot = parentRoot;
    }

    public BaseRootSiblings getBaseRootSiblings() {
        return baseRootSiblings;
    }

    public void setBaseRootSiblings(BaseRootSiblings baseRootSiblings) {
        this.baseRootSiblings = baseRootSiblings;
    }

    public int getTotalCount() {
        totalCount=0;
        if(Objects.nonNull(parentRoot) && Objects.nonNull(parentRoot.getSiblingChild())){
            Queue<ParentSiblingChild<SiblingChild>> childQueue = new ArrayDeque<>(parentRoot.getSiblingChild());
           while(!childQueue.isEmpty()){
               ParentSiblingChild<SiblingChild> parentSiblingChild= childQueue.poll();
               totalCount++;
               List<ParentSiblingChild<SiblingChild>> childList= parentSiblingChild.getParentSiblingChildren();
               if(Objects.nonNull(childList)) childQueue.addAll(childList);
           }
        }
        return totalCount;
    }
}
