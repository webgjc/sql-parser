package cn.ganjiacheng.model.metadata;

import java.util.List;

/**
 * @ClassName HiveTableMetadata
 * @description:
 * @author: again
 * @Date: 2021/3/10 7:53 下午
 */
public class TableMetadataModel {
    /**
     * 库名
     */
    private String dbName;

    /**
     * 表名
     */
    private String tableName;

    /**
     * 表类型
     */
    private String tableType;

    /**
     * 备注
     */
    private String tableComment;

    /**
     * 分区
     */
    private String partition;

    /**
     * 行格式
     */
    private String rowFormat;

    /**
     * 存储格式
     */
    private String store;

    /**
     * 存储位置
     */
    private String location;

    /**
     * 属性(压缩格式)
     */
    private String properties;

    /**
     * 字段
     */
    private List<FieldMetadataModel> fields;

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

    public String getTableType() {
        return tableType;
    }

    public void setTableType(String tableType) {
        this.tableType = tableType;
    }

    public String getTableComment() {
        return tableComment;
    }

    public void setTableComment(String tableComment) {
        this.tableComment = tableComment;
    }

    public String getPartition() {
        return partition;
    }

    public void setPartition(String partition) {
        this.partition = partition;
    }

    public String getRowFormat() {
        return rowFormat;
    }

    public void setRowFormat(String rowFormat) {
        this.rowFormat = rowFormat;
    }

    public String getStore() {
        return store;
    }

    public void setStore(String store) {
        this.store = store;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getProperties() {
        return properties;
    }

    public void setProperties(String properties) {
        this.properties = properties;
    }

    public List<FieldMetadataModel> getFields() {
        return fields;
    }

    public void setFields(List<FieldMetadataModel> fields) {
        this.fields = fields;
    }
}
