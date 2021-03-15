package cn.ganjiacheng.model.lineage;

import java.util.Objects;

/**
 * @ClassName FieldNameWithProcessModel
 * @description:
 * @author: again
 * @Date: 2021/3/10 8:51 下午
 */
public class FieldNameWithProcessModel {
    private String dbName;
    private String tableName;
    private String fieldName;
    private String process;

    public String getDbName() {
        return dbName;
    }

    public void setDbName(String dbName) {
        this.dbName = dbName;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getProcess() {
        return process;
    }

    public void setProcess(String process) {
        this.process = process;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        FieldNameWithProcessModel that = (FieldNameWithProcessModel) o;
        return Objects.equals(dbName, that.dbName) &&
                Objects.equals(tableName, that.tableName) &&
                Objects.equals(fieldName, that.fieldName) &&
                Objects.equals(process, that.process);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dbName, tableName, fieldName, process);
    }
}
