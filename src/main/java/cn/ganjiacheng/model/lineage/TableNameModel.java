package cn.ganjiacheng.model.lineage;

/**
 * @ClassName TableNameModel
 * @description:
 * @author: again
 * @Date: 2021/3/10 8:45 下午
 */
public class TableNameModel {
    private String dbName;
    private String tableName;

    public static String dealNameMark(String name) {
        if(name.startsWith("`") && name.endsWith("`")) {
            return name.substring(1, name.length()-1);
        }else{
            return name;
        }
    }

    public static TableNameModel parseTableName(String tableName) {
        TableNameModel tableNameModel = new TableNameModel();
        String[] splitTable = tableName.split("\\.");
        if(splitTable.length == 2) {
            tableNameModel.setDbName(splitTable[0]);
            tableNameModel.setTableName(splitTable[1]);
        }else if(splitTable.length == 1) {
            tableNameModel.setTableName(splitTable[0]);
        }
        return tableNameModel;
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TableNameModel that = (TableNameModel) o;

        if (dbName != null ? !dbName.equals(that.dbName) : that.dbName != null) {
            return false;
        }
        return tableName != null ? tableName.equals(that.tableName) : that.tableName == null;
    }

    @Override
    public int hashCode() {
        int result = dbName != null ? dbName.hashCode() : 0;
        result = 31 * result + (tableName != null ? tableName.hashCode() : 0);
        return result;
    }
}
