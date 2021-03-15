package cn.ganjiacheng.model.metadata;

/**
 * @ClassName HiveFieldMetadata
 * @description:
 * @author: again
 * @Date: 2021/3/10 7:54 下午
 */
public class FieldMetadataModel {
    /**
     * 字段名
     */
    private String fieldName;

    /**
     * 数据类型
     */
    private String dataType;

    /**
     * 字段备注
     */
    private String fieldComment;

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public String getFieldComment() {
        return fieldComment;
    }

    public void setFieldComment(String fieldComment) {
        this.fieldComment = fieldComment;
    }
}