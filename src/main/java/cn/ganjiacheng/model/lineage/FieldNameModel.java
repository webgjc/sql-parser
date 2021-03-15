package cn.ganjiacheng.model.lineage;

import java.util.Objects;

/**
 * @ClassName FieldNameModel
 * @description:
 * @author: again
 * @Date: 2021/3/10 8:50 下午
 */
public class FieldNameModel {
    private String dbName;
    private String tableName;
    private String fieldName;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        FieldNameModel that = (FieldNameModel) o;
        return Objects.equals(dbName, that.dbName) &&
                Objects.equals(tableName, that.tableName) &&
                Objects.equals(fieldName, that.fieldName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dbName, tableName, fieldName);
    }
}
