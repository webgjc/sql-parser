package cn.ganjiacheng.model.lineage;

import java.util.HashSet;

/**
 * @ClassName HiveFieldLineageModel
 * @description:
 * @author: again
 * @Date: 2021/3/10 8:52 下午
 */
public class FieldLineageModel {
    /**
     * 目标字段
     */
    private FieldNameModel targetField;

    /**
     * 来源字段列表
     */
    private HashSet<FieldNameWithProcessModel> sourceFields;

    public FieldNameModel getTargetField() {
        return targetField;
    }

    public void setTargetField(FieldNameModel targetField) {
        this.targetField = targetField;
    }

    public HashSet<FieldNameWithProcessModel> getSourceFields() {
        return sourceFields;
    }

    public void setSourceFields(HashSet<FieldNameWithProcessModel> sourceFields) {
        this.sourceFields = sourceFields;
    }
}
