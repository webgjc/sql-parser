package cn.ganjiacheng.model.lineage;

import java.util.Set;

/**
 * @ClassName HiveFieldLineageSelectItemModel
 * @description:
 * @author: again
 * @Date: 2021/3/10 8:51 下午
 */
public class FieldLineageSelectItemModel {
    private Set<String> fieldNames;
    private String alias;
    private String process;

    public Set<String> getFieldNames() {
        return fieldNames;
    }

    public void setFieldNames(Set<String> fieldNames) {
        this.fieldNames = fieldNames;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getProcess() {
        return process;
    }

    public void setProcess(String process) {
        this.process = process;
    }
}
